package com.naidiuk.entity;

public class User {
    private String name;
    private String surname;
    private int salary;
    private int workExperienceYears;

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkExperienceYears() {
        return workExperienceYears;
    }

    public void setWorkExperienceYears(int workExperienceYears) {
        this.workExperienceYears = workExperienceYears;
    }
}
