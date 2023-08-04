package com.Personas.APIpersonas.domain.service;
import com.Personas.APIpersonas.domain.Person;
import com.Personas.APIpersonas.persistence.repository.PersonRepository;
import com.Personas.APIpersonas.persistence.repositoryimpl.PersonRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

@Service

public class PersonService implements PersonRepository {

    PersonRepositoryImpl personRepository;

    public PersonService(PersonRepositoryImpl personRepository) {this.personRepository = personRepository;}

    @Override
    public List<Person> getAll() {
    List<Person> personList = personRepository.getAll();
    return personList;
    }

    @Override
    public Person getByGender(char Gender){
        return personRepository.getByGender(Gender);
    }

    @Override
    public List<Person> getByYears() {
        List<Person> personEdad = personRepository.getByYears();
            for (Person person:personEdad) {
                if (person.getYears() > 18) {
                    personEdad.add(person);
                } else if (person.getYears() == 5) {
                    personEdad.add(person);
                }
            }
            return personEdad;
        }


    @Override
    public Person getByName(String name){
        return personRepository.getByName(name);
    }

    @Override
    public Integer update(Person person){
        return  personRepository.update(person);
    }

    @Override
    public char save(Person person){
        return personRepository.save(person);
    }
}
