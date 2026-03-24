package ru.alishev.springcourse.model;

import javax.validation.constraints.*;

public class Person {


    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 charters ")
    private String fullName;

    @Min(value = 0, message = "Age shpuld be grater than 0")
    private int birthYear;

    public Person(int id, String fullName, int birthYear) {
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
