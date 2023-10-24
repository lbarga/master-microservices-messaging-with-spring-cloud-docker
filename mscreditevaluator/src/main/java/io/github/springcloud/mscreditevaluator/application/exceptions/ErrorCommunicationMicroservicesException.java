package io.github.springcloud.mscreditevaluator.application.exceptions;

import lombok.Getter;

public class ErrorCommunicationMicroservicesException extends Exception{

    @Getter
    private Integer statusCode;
    public ErrorCommunicationMicroservicesException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
