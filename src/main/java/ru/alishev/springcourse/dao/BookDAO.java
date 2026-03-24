package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.model.Book;
import ru.alishev.springcourse.model.Person;

import java.util.List;
import java.util.Optional;


@Component
public class BookDAO {

    private
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> index() {
       return jdbcTemplate.query(
               "SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book Where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }



    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book (title, author, year) VALUES (?, ?, ?)",
                book.getTitle(),
                book.getAuthor(),
                book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE id=?",
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getYear(),
                id);
    }

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM book where id=?", id);
    }

    // Ustawienie person_id na NULL (książka staje się wolna)
    public void release(int id) {
        jdbcTemplate.update("UPDATE book SET person_id = NULL WHERE id = ?", id);
    }

    // Przypisanie książki do konkretnej osoby
    public void assign(int id, int personId) {
        jdbcTemplate.update("UPDATE book SET person_id = ? WHERE id = ?", personId, id);
    }


    public Optional<Person> getBookOwner(int id) {
        // Łączymy tabele po person_id, żeby wyciągnąć dane osoby przypisanej do książki
        String sql = "SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id WHERE Book.id = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny();
    }


}
