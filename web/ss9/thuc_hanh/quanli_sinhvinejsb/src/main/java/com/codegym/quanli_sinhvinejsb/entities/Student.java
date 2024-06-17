package com.codegym.quanli_sinhvinejsb.entities;

public class Student {
    private int id;
    private String name;
    private String email;
    private int phone;
    private Classroom class_id;

    public Student(int id, String name, String email, int phone, Classroom class_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.class_id = class_id;
    }

    public Student(String name, String email, int phone, Classroom class_id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.class_id = class_id;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Classroom getClass_id() {
        return class_id;
    }

    public void setClass_id(Classroom class_id) {
        this.class_id = class_id;
    }
}
