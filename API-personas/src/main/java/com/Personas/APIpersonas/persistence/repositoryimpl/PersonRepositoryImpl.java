package com.Personas.APIpersonas.persistence.repositoryimpl;
import com.Personas.APIpersonas.domain.Person;
import com.Personas.APIpersonas.persistence.entities.PersonEntity;
import com.Personas.APIpersonas.persistence.repository.PersonRepository;
import com.Personas.APIpersonas.persistence.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    CrudRepository crudRepository;

    public PersonRepositoryImpl(CrudRepository crudRepository) {this.crudRepository = crudRepository;}

    public PersonRepositoryImpl() {
    }

    @Override
    public List<Person> getAll(){

        List<Person> personList = new ArrayList<>();

        List<PersonEntity> personEntitiesList = crudRepository.findAll();

        personEntitiesList.forEach(personEntity -> {
            Person person = new Person(
                personEntity.getCC(),
                personEntity.getName(),
                personEntity.getLastname(),
                personEntity.getGender(),
                personEntity.getBorn(),
                /*personEntity.getYears(),*/
                personEntity.getCel()
            );
            personList.add(person);
        });
        return personList;
    }

    @Override
    public Person getByGender(char gender){
        PersonEntity personEntity = crudRepository.getByGender(String.valueOf(gender));
        if(personEntity == null){
            throw new RuntimeException("El genero no es valido");
        }
        return new Person(
                personEntity.getCC(),
                personEntity.getName(),
                personEntity.getLastname(),
                personEntity.getGender(),
                personEntity.getBorn(),
                /*personEntity.getYears(),*/
                personEntity.getCel()
        );
     }

    @Override
    public List<Person> getByYears() {
        List<Person> personList = new ArrayList<>();

        List<PersonEntity> personEntitiesList = crudRepository.getByYears();

        personEntitiesList.forEach(personEntity -> {
            Person person = new Person(
                    personEntity.getCC(),
                    personEntity.getName(),
                    personEntity.getLastname(),
                    personEntity.getGender(),
                    personEntity.getBorn(),
                    /*personEntity.getYears(),*/
                    personEntity.getCel()
            );
        });
        return personList;
    }

    @Override
    public Person getByName(String name){
        PersonEntity personEntity = crudRepository.getByName(name);
        if(personEntity == null){
            throw new RuntimeException("No existe el nombre");
        }
        return new Person(
                personEntity.getCC(),
                personEntity.getName(),
                personEntity.getLastname(),
                personEntity.getGender(),
                personEntity.getBorn(),
                /*personEntity.getYears(),*/
                personEntity.getCel()
        );
    }

    @Override
    public Integer update(Person person){
        PersonEntity personEntity = new PersonEntity(
                person.getCC(),
                person.getName(),
                person.getLastname(),
                person.getGender(),
                person.getBorn(),
                person.getYears(),
                person.getCel()
        );
        return crudRepository.save(personEntity).getCel();
    }
    @Override
    public char save(Person person) {
        PersonEntity personEntity = new PersonEntity(
            person.getCC(),
            person.getName(),
            person.getLastname(),
            person.getGender(),
            person.getBorn(),
            person.getYears(),
            person.getCel()
        );
        return crudRepository.save(personEntity).getGender();
    }
}