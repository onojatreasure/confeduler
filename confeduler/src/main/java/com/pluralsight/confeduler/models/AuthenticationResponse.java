package com.pluralsight.confeduler.models;

import java.io.Serializable;
import java.util.List;

public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 345L;

    private final String jwt;
    private Long id;
    private String username;
    private List<String> roles;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
