package com.Personas.APIpersonas.controller;
import com.Personas.APIpersonas.domain.Person;
import com.Personas.APIpersonas.domain.service.PersonService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {this.personService = personService;}

    @GetMapping(value = "/traer-todo")
    public List<Person> getAll() {return personService.getAll();}

    @GetMapping(value = "/traer-por-genero")
    public Person getByGender(@PathVariable("gender")char gender) {return personService.getByGender(gender);}

    @GetMapping(value = "/traer-mayor-edad")
    public List<Person> getByYears() {return personService.getByYears();}

    @GetMapping(value = "/traer-nombre")
    public Person getByName(@PathVariable("name")String name) {return personService.getByName(name);}

    @PutMapping(value = "/actualizar")
    public Integer update (@RequestBody Person person){
        Integer updatePerson = personService.update(person);
        return updatePerson;
    }
    @PostMapping(value = "/guardar")
    public String getByArray(@RequestBody Person person) {return String.valueOf(personService.save(person));}

}
