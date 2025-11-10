package com.helix.gpo.crm.testimonial;

import com.helix.gpo.crm.shared.payload.website.testimonial.TestimonialDtoRequest;
import com.helix.gpo.crm.shared.payload.website.testimonial.TestimonialDtoResponse;

class TestimonialMapper {

    public static TestimonialDtoResponse mapToTestimonialDto(Testimonial testimonial, String imageUrl) {
        return TestimonialDtoResponse.builder()
                .id(testimonial.getId())
                .title(testimonial.getTitle())
                .description(testimonial.getDescription())
                .result(testimonial.getResult())
                .imageUrl(imageUrl)
                .creationDate(testimonial.getCreationDate())
                .lastUpdate(testimonial.getLastUpdate())
                .showOnWebsite(testimonial.getShowOnWebsite())
                .build();
    }

    public static Testimonial mapToTestimonial(TestimonialDtoRequest testimonialDtoRequest, String imageUrl) {
        return Testimonial.builder()
                .title(testimonialDtoRequest.getTitle())
                .description(testimonialDtoRequest.getDescription())
                .result(testimonialDtoRequest.getResult())
                .imageUrl(imageUrl)
                .showOnWebsite(testimonialDtoRequest.getShowOnWebsite())
                .build();
    }

}
