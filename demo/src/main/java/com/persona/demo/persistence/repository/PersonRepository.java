package com.persona.demo.persistence.repository;
import com.persona.demo.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository {

    public List<Person> getAll();

    public List<Person> getByGender(String gender);

    public List<Person> getByEdad(Integer years);

    public List<Person> getByMayores();

    public List<Person> getByName(String name);

    Integer update(Person person);

    Integer save(Person person);
}
