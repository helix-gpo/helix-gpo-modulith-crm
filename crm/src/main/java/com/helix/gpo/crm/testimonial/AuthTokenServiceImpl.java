package com.helix.gpo.crm.testimonial;

import com.helix.gpo.crm.shared.exception.types.AuthTokenInvalidException;
import com.helix.gpo.crm.shared.exception.types.ResourceAlreadyExistsException;
import com.helix.gpo.crm.shared.exception.types.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class AuthTokenServiceImpl {

    private final AuthTokenRepository authTokenRepository;

    public String createAuthTokenValue(String projectTitle) {
        String authTokenValue = projectTitle + "_" + UUID.randomUUID();
        return encodeToBase64(authTokenValue);
    }

    public void sendTokenMailToProjectPartner(AuthToken authToken) {
        String decodedTokenValue = decodeFromBase64(authToken.getValue());
        // todo: send email with decoded token value
    }

    public void validateAuthToken(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElse(null);
        if (authToken == null || !authToken.getValid() || authToken.getUsed()) {
            throw new AuthTokenInvalidException("Invalid auth-token!");
        }
        checkIfTestimonialAlreadyExists(authToken);
    }

    public void checkIfTestimonialAlreadyExists(AuthToken authToken) {
        if (authToken.getTestimonial() != null) {
            throw new ResourceAlreadyExistsException("AuthToken");
        }
    }

    public void invalidateAuthToken(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElseThrow(
                () -> new ResourceNotFoundException("AuthToken", "Value",  authTokenValue)
        );
        authToken.setUsed(true);
        authToken.setValid(false);
        authTokenRepository.save(authToken);
    }

    private String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    private String decodeFromBase64(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

}
