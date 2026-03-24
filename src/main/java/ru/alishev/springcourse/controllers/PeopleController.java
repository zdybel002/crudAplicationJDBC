package ru.alishev.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.dao.PersonDAO;
import ru.alishev.springcourse.model.Book;
import ru.alishev.springcourse.model.Person;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;


    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    // Pobranie wszystkich osoby
    @GetMapping()
    public String all(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    // Pobranie jednej persony
    @GetMapping("/{id}")
    public String showOnePerson(@PathVariable int id, Model model){
        model.addAttribute("person", personDAO.show(id));

        // 2. Pobierz listę książek przypisanych do tej osoby
        List<Book> books = personDAO.getBooksByPersonId(id);
        model.addAttribute("books", books);

        return "people/show";
    }

    // dodanie nowego czytelnika
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "people/new";
        }

        personDAO.save(person);
        return "redirect:/people";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult,
                         @PathVariable("id") int id ){

            if(bindingResult.hasErrors()){
                return "people/edit";
            }



        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }

}
