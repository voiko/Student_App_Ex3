package com.example.student_app_ex3.Model;

public class Student {
    String name = "";
    String id = "";
    int phone = 0;
    String address = "";
    boolean flag = false;


    public Student(){}
    public Student(String name, String id,int phone ,String address ,boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
        this.phone = phone;
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isFlag() {
        return flag;
    }
}