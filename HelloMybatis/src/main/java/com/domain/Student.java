package com.domain;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String className;


    public Student() {
    }

    public Student(int id, String name, String sex, int age, String className) {
       this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
