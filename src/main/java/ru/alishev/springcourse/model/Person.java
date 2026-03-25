package ru.alishev.springcourse.model;

import javax.validation.constraints.*;

public class Person {


    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 charters ")
    private String fullName;

    @Min(value = 1900, message = "Age should be grater than 1900")
    private Integer birthYear;

    public Person(int id, String fullName, Integer birthYear) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
}
