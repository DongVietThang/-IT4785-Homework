package com.example.sqlite.model;

public class Student {
    int studentId;
    String name;
    String birth;
    String email;
    String address;

    public Student() {
    }

    public Student(int studentId, String name, String dateOfBirth, String email, String address) {
        this.studentId = studentId;
        this.name = name;
        this.birth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String dateOfBirth, String email, String address) {
        this.name = name;
        this.birth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
