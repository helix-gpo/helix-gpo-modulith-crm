package com.helix.gpo.crm.testimonial;

import com.helix.gpo.crm.aws.AwsServiceApi;
import com.helix.gpo.crm.project.ProjectServiceApi;
import com.helix.gpo.crm.shared.util.Constants;
import com.helix.gpo.crm.shared.payload.website.testimonial.TestimonialDtoResponse;
import com.helix.gpo.crm.shared.payload.website.testimonial.WebsiteTestimonialRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final AuthTokenService authTokenService;
    private final ProjectServiceApi projectServiceApi;
    private final AwsServiceApi awsServiceApi;

    @Value("${aws.bucket.testimonials}")
    private String awsBucket;

    @Transactional
    @Override
    public TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest websiteTestimonialRequest, MultipartFile image) {
        String authTokenValue = websiteTestimonialRequest.getAuthTokenValue();

        authTokenService.validateAuthToken(authTokenValue);

        Long projectId = websiteTestimonialRequest.getTestimonialDtoRequest().getProjectId();
        String imageUrl = image == null
                ? Constants.PLACEHOLDER_IMAGE
                : saveTestimonialImage(image, projectId);

        Testimonial testimonial = TestimonialMapper.mapToTestimonial(websiteTestimonialRequest.getTestimonialDtoRequest(), imageUrl);
        testimonial.setContentType(image == null
                ?  Constants.PLACEHOLDER_CONTENT_TYPE
                : image.getContentType());
        testimonial.setProjectId(projectId);
        testimonial.setCreationDate(LocalDate.now());
        testimonial.setLastUpdate(LocalDate.now());
        testimonial.setShowOnWebsite(false);
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        TestimonialDtoResponse testimonialDtoResponse = prepareTestimonialDtoResponse(savedTestimonial);

        authTokenService.invalidateAuthToken(authTokenValue);

        log.info("New Testimonial saved: {}", savedTestimonial);
        return testimonialDtoResponse;
    }

    private String saveTestimonialImage(MultipartFile image, Long projectId) {
        String originalFilename = image.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String key = projectId + "." + extension;
        return awsServiceApi.uploadFile(awsBucket, image, key);
    }

    @Override
    public List<TestimonialDtoResponse> getAllWebsiteTestimonials() {
        List<Testimonial> testimonials = testimonialRepository.findAllByShowOnWebsiteOrderByCreationDateDesc(true);
        return testimonials.stream()
                .map(this::prepareTestimonialDtoResponse)
                .toList();
    }

    @Override
    public BigDecimal getTestimonialAverageResult() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAll();
        double average = websiteTestimonials.stream()
                .mapToInt(Testimonial::getResult)
                .average()
                .orElse(0.0);
        return BigDecimal.valueOf(average);
    }

    private TestimonialDtoResponse prepareTestimonialDtoResponse(Testimonial testimonial) {
        String awsBucketKey = testimonial.getImageUrl().isEmpty()
                ? Constants.PLACEHOLDER_IMAGE
                : testimonial.getImageUrl();
        String imageUrl = awsServiceApi.generatePresignedUrl(awsBucket, awsBucketKey, testimonial.getContentType());

        TestimonialDtoResponse testimonialDtoResponse = TestimonialMapper.mapToTestimonialDto(testimonial, imageUrl);
        testimonialDtoResponse.setWebsiteProjectDto(projectServiceApi.getProjectByid(testimonial.getProjectId()));

        return testimonialDtoResponse;
    }

}
