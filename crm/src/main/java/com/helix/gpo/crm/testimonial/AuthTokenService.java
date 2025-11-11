package com.helix.gpo.crm.testimonial;

interface AuthTokenService {

    String createAuthTokenValue(Long projectId);

    void sendTokenMailToProjectPartner(AuthToken authToken);

    AuthToken validateAuthToken(String authTokenValue);

    void checkIfTestimonialAlreadyExists(AuthToken authToken);

    void invalidateAuthToken(String authTokenValue, Testimonial testimonial);

}
