package com.example.juan.tuiter.model;

/**
 * Created by Juan on 24/07/2016.
 */
public class User {
    private int userId;
    private String username;
    private String userUrl;
    private String userPicture;

    public User(int userId, String username, String userUrl, String userPicture) {
        this.userId = userId;
        this.username = username;
        this.userUrl = userUrl;
        this.userPicture = userPicture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }
}
