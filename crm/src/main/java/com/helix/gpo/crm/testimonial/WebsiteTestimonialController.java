package com.helix.gpo.crm.testimonial;

import com.helix.gpo.crm.shared.payload.website.testimonial.TestimonialDtoResponse;
import com.helix.gpo.crm.shared.payload.website.testimonial.WebsiteTestimonialRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/website/testimonials")
@RequiredArgsConstructor
class WebsiteTestimonialController {

    private final TestimonialService testimonialService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<TestimonialDtoResponse> addTestimonial(@RequestPart(name = "payload") WebsiteTestimonialRequest websiteTestimonialRequest,
                                                                 @RequestPart(name = "image", required = false) MultipartFile image) {
        return new ResponseEntity<>(testimonialService.addTestimonial(websiteTestimonialRequest, image), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestimonialDtoResponse>> getAllWebsiteTestimonials() {
        return new ResponseEntity<>(testimonialService.getAllWebsiteTestimonials(), HttpStatus.OK);
    }

    @GetMapping(value = "/average")
    public ResponseEntity<BigDecimal> getAllWebsiteTestimonialsAverage() {
        return new ResponseEntity<>(testimonialService.getTestimonialAverageResult(), HttpStatus.OK);
    }

}
