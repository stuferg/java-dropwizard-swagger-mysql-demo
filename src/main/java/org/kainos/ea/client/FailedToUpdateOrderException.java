package org.kainos.ea.client;

public class FailedToUpdateOrderException extends Throwable {
    @Override
    public String getMessage() {
        return "Could not update order";
    }
}
