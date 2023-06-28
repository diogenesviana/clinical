package br.com.clinical.project.service.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super(message);
    }

}

