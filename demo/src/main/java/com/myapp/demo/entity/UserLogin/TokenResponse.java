package com.myapp.demo.entity.UserLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {
    @JsonProperty("token")
    String token;
    @JsonProperty("identity")
    String identity;
    @JsonProperty("userName")
    String userName;
    @JsonProperty("userId")
    String userId;

    public String getToken() {
        return token;
    }

    public String getIdentity() {
        return identity;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}