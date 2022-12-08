package com.nriker.mvc2.model;

public class SwitterPost {
    private final String userName;
    private final String userPassword;
    private final String postTitle;
    private final String postMessage;

    public SwitterPost (String userName, String userPassword,
     String postTitle, String postMessage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.postTitle = postTitle;
        this.postMessage = postMessage;
    }

    public String getUserName() { return userName; }

    public String getUserPassword() { return userPassword; }

    public String getPostTitle() { return postTitle; }

    public String getPostMessage() { return postMessage; }
}
