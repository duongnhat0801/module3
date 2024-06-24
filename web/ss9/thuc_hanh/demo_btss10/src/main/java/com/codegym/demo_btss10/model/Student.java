package com.codegym.demo_btss10.model;

public class Student {
    private int id;
    private String name;
    private String gender;
    private int score;
    private String grade;

    public Student(int id, String name, String gender, int score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public Student() {
    }

    public Student(String name, String gender, int score, String grade) {
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.grade = grade;
    }

    public Student(int id, String name, String gender, int score, String grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.grade = grade;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        if (score >= 90) {
            return "Giỏi";
        } else if (score >= 80) {
            return "Khá";
        } else if (score >= 60) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}
