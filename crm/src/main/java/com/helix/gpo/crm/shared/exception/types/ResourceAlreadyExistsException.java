package com.helix.gpo.crm.shared.exception.types;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
public class ResourceAlreadyExistsException extends RuntimeException {

    private String resourceName;

    public ResourceAlreadyExistsException(String resourceName) {
        super(String.format("%s already exists!", resourceName));
        this.resourceName = resourceName;
    }

}
