package com.test.springmvc.crud.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

public class Student {
    private String teacherno;
    private String sno;

    @NotEmpty
    private String name;
    private Integer age;
    @Max(100)
    @Min(0)
    private Integer mark;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @NumberFormat(pattern = "#,###,###,#")
    private Float high;

    public Student() {
    }

    public Student(String teacherno, String sno, String name, Integer age, Integer mark) {
        this.sno = sno;
        this.name = name;
        this.teacherno = teacherno;
        this.age = age;
        this.mark = mark;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Student{" +
                "teacherno='" + teacherno + '\'' +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                ", brith=" + birth +
                ", high=" + high +
                '}';
    }
}
