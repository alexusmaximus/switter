package com.nriker.switter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SwitterUser {

    @Id
    private final String id;
    private final String name;
    private final String password;

    public SwitterUser(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public String getPassword() { return password; }
}
