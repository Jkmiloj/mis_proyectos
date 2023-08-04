package com.Personas.APIpersonas.persistence.repository;
import com.Personas.APIpersonas.domain.Person;
import java.util.List;

public interface PersonRepository {

    List<Person> getAll();
    Person getByGender(char gender);

    List<Person> getByYears();

    Person getByName(String name);

    Integer update(Person person);

    char save(Person person);
}
