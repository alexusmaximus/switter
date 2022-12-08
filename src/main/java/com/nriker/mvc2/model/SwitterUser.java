package com.nriker.mvc2.model;

public class SwitterUser {
    private final String name;
    private final String password;

    public SwitterUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() { return name; }

    public String getPassword() { return password; }
}
