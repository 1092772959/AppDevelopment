package com.myapp.demo.entity.UserLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLogin {
    @JsonProperty("user_id")
    String userId;
    @JsonProperty("password")
    String userPassword;

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
