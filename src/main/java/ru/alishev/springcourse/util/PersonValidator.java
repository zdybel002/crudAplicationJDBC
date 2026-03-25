package ru.alishev.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alishev.springcourse.dao.PersonDAO;
import ru.alishev.springcourse.model.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Person person = (Person) o;


        if (personDAO.getPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Person with this name already exist");

        if(person.getBirthYear() == null){
            errors.rejectValue("birthYear", "", "Rok urodzenia nie może być pusty");
            return;
        }

        if (person.getBirthYear() < 1900){
            errors.rejectValue("birthYear", "", "Rok urodzenia musi być większy niż 1900");
        }

        int currentYear = java.time.Year.now().getValue();
        if (person.getBirthYear() > currentYear){
            errors.rejectValue("birthYear", "", "Rok urodzenia nie może być z przeszłości");
        }



    }
}
