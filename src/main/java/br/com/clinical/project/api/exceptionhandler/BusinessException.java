package br.com.clinical.project.api.exceptionhandler;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
