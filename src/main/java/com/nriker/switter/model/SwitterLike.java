package com.nriker.switter.model;

import org.springframework.data.annotation.Id;

public class SwitterLike {
	@Id
	private String id;
	private String userId;
	private String postId;

	public SwitterLike(String id, String userId, String postId) {
		this.id = id;
		this.userId = userId;
		this.postId = postId;
	}

	public String getID() { return id; }
	public String getUserId() { return userId; }
	public String getPostId() { return postId; }
}
