package io.github.springcloud.mscreditevaluator.application.exceptions;

public class CustomerDataNotFoundException extends Exception {
    public CustomerDataNotFoundException() {
        super("Customer data not found!");
    }
}
