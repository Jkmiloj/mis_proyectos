package com.persona.demo.controller;
import com.persona.demo.Domain.Person;
import com.persona.demo.Domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/traer-todo")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping(value = "/genero/{gender}")
    public List<Person> getByGender(@PathVariable("gender") String gender){
        return personService.getByGender(gender);
    }

    @GetMapping(value = "/edad/{years}")
    public  List<Person> getByEdad(@PathVariable("years") Integer years){
        return personService.getByEdad(years);
    }

    @GetMapping(value = "/mayor-edad")
    public ResponseEntity<List<Person>> getByMayores() {
        List<Person> mayorEdad = personService.getByMayores();
        return new ResponseEntity<>(mayorEdad, HttpStatus.OK);
    }

    @GetMapping(value = "/traer-nombre/{name}")
    public List<Person> getByName(@PathVariable("name")String name) {
        return (List<Person>) personService.getByName(name);}

    @PutMapping(value = "/actualizar")
    public Integer update (@RequestBody Person person){
        return personService.update(person);
    }
    @PostMapping(value = "/guardar")
    public String getCc(@RequestBody Person person) {return String.valueOf(personService.save(person));}

}
