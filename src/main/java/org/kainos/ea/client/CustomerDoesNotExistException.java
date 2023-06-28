package org.kainos.ea.client;

public class CustomerDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return "Customer does not exist";
    }
}
