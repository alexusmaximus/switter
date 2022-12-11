package com.nriker.switter.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class SwitterPost {
    
    @Id
    private final String id;
    private final String userId;
    private final String postTitle;
    private final String postMessage;
    private String[] likes;

    public SwitterPost (String id, String userId,
     String postTitle, String postMessage, String[] likes) {
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

    public String[] getLikes() { return likes; }

    public void setLike(String[] likes) {
        this.likes = likes;
    }
}
