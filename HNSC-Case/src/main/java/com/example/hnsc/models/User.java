package com.example.hnsc.models;

public class User {
    private int id;
    private String name;
    private  String email;
    private String password;
    private int otp_code;

    public User() {};
    public User(String name, String email, String password, int otp_code) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.otp_code = otp_code;
    }

    public User(int id, String name, String email, String password, int otp_code) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.otp_code = otp_code;
    }

    public int getOtp_code() {
        return otp_code;
    }

    public void setOtp_code(int otp_code) {
        this.otp_code = otp_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
