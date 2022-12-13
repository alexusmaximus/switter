package com.nriker.switter.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SwitterUser {

    @Id
    private final String id;
    private final String name;
    private final String password;
    private ArrayList<String> likes;

    public SwitterUser(String id, String name, String password, ArrayList<String> likes) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.likes = likes;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public ArrayList<String> getLikes() { return likes; }

    public void setLike(String likeId) {
        if (this.likes == null) {
            ArrayList <String> likes = new ArrayList<>();
            likes.add(likeId);
            this.likes = likes;
        } else {
        	this.likes.add(likeId);
		}
    }
}
