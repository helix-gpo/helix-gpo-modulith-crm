package com.helix.gpo.crm.testimonial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    List<Testimonial> findAllByShowOnWebsiteOrderByCreationDateDesc(Boolean showOnWebsite);

    Optional<Testimonial> findByProjectId(Long projectId);

}
