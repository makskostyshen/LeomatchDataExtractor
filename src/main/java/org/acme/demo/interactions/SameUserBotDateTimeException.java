package org.acme.demo.interactions;

public class SameUserBotDateTimeException extends RuntimeException{

    public SameUserBotDateTimeException() {
    }
    public SameUserBotDateTimeException(String message) {
        super(message);
    }
}
