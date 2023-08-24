package com.persona.demo.Domain.service;
import com.persona.demo.Domain.Person;
import com.persona.demo.persistence.repository.PersonRepository;
import com.persona.demo.persistence.repositoryimpl.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements PersonRepository {


    PersonRepositoryImpl personRepository;
    @Autowired
    public PersonService(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll(){
        return personRepository.getAll();
    }

    public List<Person> getByGender(String gender){
        return personRepository.getByGender(gender);
    }

    public List<Person> getByEdad(Integer years){
        return personRepository.getByEdad(years);
    }

    @Override
    public List<Person> getByMayores() {
        List<Person> person = personRepository.getAll();

        List<Person> mayorEdad = person.stream()
                .filter(person1 -> calcularEdad(person1.getBorn_date())>=18)
                .collect(Collectors.toList());
        return mayorEdad;
    }

    private int calcularEdad(LocalDate born_date) {
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - born_date.getYear();

        if (born_date.getMonthValue() > fechaActual.getMonthValue() ||
                (born_date.getMonthValue() == fechaActual.getMonthValue() &&
                        born_date.getDayOfMonth() > fechaActual.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }


    @Override
    public List<Person> getByName(String name){
        return personRepository.getByName(name);
    }

    @Override
    public Integer update(Person person){
        return  personRepository.update(person);
    }

    @Override
    public Integer save(Person person){
        return personRepository.save(person);
    }
}

