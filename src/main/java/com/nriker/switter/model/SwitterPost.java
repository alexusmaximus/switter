package com.nriker.switter.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class SwitterPost {
    
    @Id
    private final String id;
    private final String userName;
    private final String postTitle;
    private final String postMessage;

    public SwitterPost (String id, String userName,
     String postTitle, String postMessage) {
        this.id = id;
        this.userName = userName;
        this.postTitle = postTitle;
        this.postMessage = postMessage;
    }

    public String getId() { return id; }

    public String getUserName() { return userName; }

    public String getPostTitle() { return postTitle; }

    public String getPostMessage() { return postMessage; }
}
