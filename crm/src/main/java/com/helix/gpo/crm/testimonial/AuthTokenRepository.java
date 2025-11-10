package com.helix.gpo.crm.testimonial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {

    Optional<AuthToken> findByValue(String value);

}
