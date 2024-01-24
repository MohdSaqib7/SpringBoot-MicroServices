package com.personal.JWTsecurity.models;

import lombok.Data;

@Data
public class JwtTokenRequest {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
