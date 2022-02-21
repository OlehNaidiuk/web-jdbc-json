package com.naidiuk.webJdbcJson.dto;

public class UserDto {
    private String name;
    private String surname;
    private int salary;
    private int workExperienceYears;
    private int yearsUntilRetirement;

    public UserDto() {}

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

    public int getYearsUntilRetirement() {
        return yearsUntilRetirement;
    }

    public void setYearsUntilRetirement(int yearsUntilRetirement) {
        this.yearsUntilRetirement = yearsUntilRetirement;
    }
}
