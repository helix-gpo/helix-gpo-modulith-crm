package com.helix.gpo.crm.shared.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AuthTokenInvalidException extends RuntimeException {

    public AuthTokenInvalidException(String message) {
        super(message);
    }

}
