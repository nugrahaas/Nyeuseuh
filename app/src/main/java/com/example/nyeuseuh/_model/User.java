package com.example.nyeuseuh._model;

public class User {

    String id;
    String nama;
    String username;
    String password;
    String outlet;
    String role;

    public User(String id, String nama, String username, String password, String outlet, String role) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.outlet = outlet;
        this.role = role;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
