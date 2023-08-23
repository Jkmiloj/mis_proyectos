package com.persona.demo.Domain.service;
import com.persona.demo.Domain.Person;
import com.persona.demo.persistence.repository.PersonRepository;
import com.persona.demo.persistence.repositoryimpl.PersonRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService implements PersonRepository {

    PersonRepositoryImpl personRepository;

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
    public List<Person> getByMayores(Integer years) {
        List<Person> personEdad = personRepository.getByMayores(years);
        for (Person person:personEdad) {
            if (person.getYears() > 18) {
                personEdad.add(person);
            } else{
                personEdad.add(person);
            }
        }
        return personEdad;
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

