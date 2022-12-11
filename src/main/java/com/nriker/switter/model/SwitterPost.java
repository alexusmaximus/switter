package com.nriker.switter.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

@Document
public class SwitterPost {
    
    @Id
    private final String id;
    private final String userId;
    private final String postTitle;
    private final String postMessage;
    private ArrayList <String> likes;

    public SwitterPost (String id, String userId,
     String postTitle, String postMessage, ArrayList <String> likes) {
        this.id = id;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postMessage = postMessage;
        this.likes = likes;
    }

    public String getId() { return id; }

    public String getuserId() { return userId; }

    public String getPostTitle() { return postTitle; }

    public String getPostMessage() { return postMessage; }

    public ArrayList <String> getLikes() { return likes; }

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
