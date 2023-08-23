package com.persona.demo.persistence.repositoryimpl;
import com.persona.demo.Domain.Person;
import com.persona.demo.persistence.entities.PersonEntity;
import com.persona.demo.persistence.repository.CrudRepository;
import com.persona.demo.persistence.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    CrudRepository crudRepository;

    public PersonRepositoryImpl(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<Person> getAll(){

        List<Person> personList = new ArrayList<>();

        List<PersonEntity> personEntityList = crudRepository.findAll();

        personEntityList.forEach(personEntity -> {
            Person person = new Person(
                personEntity.getCc(),
                personEntity.getName(),
                personEntity.getLastname(),
                personEntity.getGender(),
                personEntity.getBorn_date(),
                personEntity.getYears(),
                personEntity.getCellphone()
            );
            personList.add(person);
        });
        return personList;
    }

    @Override
    public List<Person> getByGender(String gender){

        List<Person> personList = new ArrayList<>();

        List<PersonEntity> personEntityList = (List<PersonEntity>) crudRepository.getByGender(String.valueOf(gender));

        if(personEntityList == null){
            throw new RuntimeException("El genero no existe");
        }

        personEntityList.forEach(personEntity -> {
            Person person = new Person(
                    personEntity.getCc(),
                    personEntity.getName(),
                    personEntity.getLastname(),
                    personEntity.getGender(),
                    personEntity.getBorn_date(),
                    personEntity.getYears(),
                    personEntity.getCellphone()
            );
            personList.add(person);
        });
        return personList;
    }

    @Override
    public List<Person> getByEdad(Integer years){
        List<Person> personList = new ArrayList<>();
        List<PersonEntity> personEntityList = (List<PersonEntity>) crudRepository.getByEdad(years);
        if (personEntityList == null){
            throw new RuntimeException("Edad noexiste");
        }
        personEntityList.forEach(personEntity -> {
            Person person = new Person(
                    personEntity.getCc(),
                    personEntity.getName(),
                    personEntity.getLastname(),
                    personEntity.getGender(),
                    personEntity.getBorn_date(),
                    personEntity.getYears(),
                    personEntity.getCellphone()
            );
            personList.add(person);
        });
        return personList;
    }

    @Override
    public List<Person> getByMayores(Integer years){

            List<Person> personList = new ArrayList<>();
            List<PersonEntity> personEntityList = (List<PersonEntity>) crudRepository.getByMayores(years);
            if (personEntityList == null){
                throw new RuntimeException("No hay mayores de edad");
            }
            personEntityList.forEach(personEntity -> {
                Person person = new Person(
                        personEntity.getCc(),
                        personEntity.getName(),
                        personEntity.getLastname(),
                        personEntity.getGender(),
                        personEntity.getBorn_date(),
                        personEntity.getYears(),
                        personEntity.getCellphone()
                );
                personList.add(person);
            });
            return personList;
    }

    @Override
    public List<Person> getByName(String name){
        List<Person> personList = new ArrayList<>();
        List<PersonEntity> personEntityList = crudRepository.getByName(name);
        if(personEntityList == null){
            throw new RuntimeException("No existe el nombre que comienza por A");
        }
        personEntityList.forEach(personEntity -> {
            Person person = new Person(
                    personEntity.getCc(),
                    personEntity.getName(),
                    personEntity.getLastname(),
                    personEntity.getGender(),
                    personEntity.getBorn_date(),
                    personEntity.getYears(),
                    personEntity.getCellphone()
            );
            personList.add(person);
        });
        return personList;
    }

    @Override
    public Integer update(Person person){
        PersonEntity personEntity = new PersonEntity(
                person.getCc(),
                person.getName(),
                person.getLastname(),
                person.getGender(),
                person.getBorn_date(),
                person.getYears(),
                person.getCellphone()
        );
        return crudRepository.save(personEntity).getCc();
    }

    @Override
    public Integer save(Person person){
        PersonEntity personEntity = new PersonEntity(
                person.getCc(),
                person.getName(),
                person.getLastname(),
                person.getGender(),
                person.getBorn_date(),
                person.getYears(),
                person.getCellphone()
        );
        return crudRepository.save(personEntity).getCc();
    }
}