package com.github.dreamhead.zero.identity.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class UserRegistration {
    private final String username;
    private final String password;

    @JsonCreator
    public UserRegistration(@JsonProperty("username") final String username,
                            @JsonProperty("password") final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
