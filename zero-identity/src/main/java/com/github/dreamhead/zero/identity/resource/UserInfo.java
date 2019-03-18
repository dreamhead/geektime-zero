package com.github.dreamhead.zero.identity.resource;

public class UserInfo {
    private final String username;
    private final String password;

    public UserInfo(final String username, final String password) {
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
