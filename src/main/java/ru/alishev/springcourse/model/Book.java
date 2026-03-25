package ru.alishev.springcourse.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Tytuł nie może być pusty")
    @Size(min = 2, max = 100, message = "Tytuł powinien mieć od 2 do 200 znaków")
    private String title;

    @NotEmpty(message = "Autor nie może być pusty")
    @Size(min = 2, max = 100, message = "Imię i nazwisko autora powinno mieć od 2 do 100 znaków")
    private String author;

    @Max(value = 2026, message = "Rok wydania nie może być z przyszłości")
    @Min(value = 1500, message = "Rok wydania musi być większy niż 1500")
    private int year;

    private Integer personId;

    public Book() {}

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Integer getPersonId() { return personId; }
    public void setPersonId(Integer personId) { this.personId = personId; }
}
