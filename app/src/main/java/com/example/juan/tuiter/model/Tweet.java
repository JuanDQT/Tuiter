package com.example.juan.tuiter.model;

/**
 * Created by Juan on 23/07/2016.
 */
public class Tweet {
    private int id;
    private String username;
    private String userUrl;
    private String date;
    private String userPicture;

    private String tweet;

    private int replies;
    private int retweets;
    private int likes;

    public Tweet(int id, String username, String userUrl, String date, String userPicture, String tweet, int replies, int retweets, int likes) {
        this.id = id;
        this.username = username;
        this.userUrl = userUrl;
        this.date = date;
        this.userPicture = userPicture;
        this.tweet = tweet;
        this.replies = replies;
        this.retweets = retweets;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
