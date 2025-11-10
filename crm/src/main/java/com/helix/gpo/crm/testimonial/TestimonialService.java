package com.helix.gpo.crm.testimonial;

import com.helix.gpo.crm.shared.payload.website.testimonial.TestimonialDtoResponse;
import com.helix.gpo.crm.shared.payload.website.testimonial.WebsiteTestimonialRequest;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

interface TestimonialService {

    TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest testimonialRequest, MultipartFile image);

    List<TestimonialDtoResponse> getAllWebsiteTestimonials();

    BigDecimal getTestimonialAverageResult();

}
