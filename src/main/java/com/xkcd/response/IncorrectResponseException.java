package com.xkcd.response;

public class IncorrectResponseException extends Exception{

    public IncorrectResponseException() {
        super();
    }

    public IncorrectResponseException(String message) {
        super(message);
    }

    public IncorrectResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectResponseException(Throwable cause) {
        super(cause);
    }

    protected IncorrectResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
