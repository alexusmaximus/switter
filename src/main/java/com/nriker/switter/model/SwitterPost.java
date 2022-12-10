package com.nriker.switter.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class SwitterPost {
    
    @Id
    private final String id;
    private final String userID;
    private final String postTitle;
    private final String postMessage;

    public SwitterPost (String id, String userID,
     String postTitle, String postMessage) {
        this.id = id;
        this.userID = userID;
        this.postTitle = postTitle;
        this.postMessage = postMessage;
    }

    public String getId() { return id; }

    public String getUserID() { return userID; }

    public String getPostTitle() { return postTitle; }

    public String getPostMessage() { return postMessage; }
}
