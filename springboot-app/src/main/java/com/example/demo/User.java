package com.example.demo;

import jakarta.persistence.*; // 替换 javax 为 jakarta

@Entity
@Table(name = "t_user")
public class User {
    @Id
    private Long userId;
    private String username;
    private String email;

    // getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}