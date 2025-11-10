package com.helix.gpo.crm.shared.exception.types;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;

    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s not found - %s: '%s'", resource, field, value));
        this.resourceName = resource;
    }

}
