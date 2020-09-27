package com.test.springmvc.crud.bean;

import java.util.List;

public class Teacher {
    private String teacherno;
    private String name;
    private Integer age;

    public Teacher() {
    }

    public Teacher(String teacherno, String name, Integer age) {
        this.teacherno = teacherno;
        this.name = name;
        this.age = age;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherno='" + teacherno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
