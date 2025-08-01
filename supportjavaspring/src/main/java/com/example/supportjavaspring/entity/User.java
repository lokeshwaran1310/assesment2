package com.example.supportjavaspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int uid;

    private String name;
    private String email;
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
