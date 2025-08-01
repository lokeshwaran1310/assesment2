package com.supportjavaconsole.models;

public class User {
    private int uid;
    private String name;
    private String email;
    public User(int uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
