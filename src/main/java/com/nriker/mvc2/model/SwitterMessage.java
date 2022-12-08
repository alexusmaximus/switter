package com.nriker.mvc2.model;

public class SwitterMessage {
    private final String message;

    public SwitterMessage (String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
