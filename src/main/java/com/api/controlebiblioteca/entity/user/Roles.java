package com.api.controlebiblioteca.entity.user;


public enum Roles {
    ADMIN("admin"),
    USER("user");

    private String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
