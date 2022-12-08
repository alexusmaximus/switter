package com.nriker.mvc2.model;

public class SwitterUser {
    private final String name;
    private final String passwort;

    public SwitterUser(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }

    public String getName() { return name; }

    public String getPasswort() { return passwort; }
}
