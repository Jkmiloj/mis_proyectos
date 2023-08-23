package com.persona.demo.persistence.repository;
import com.persona.demo.Domain.Person;
import com.persona.demo.persistence.entities.PersonEntity;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudRepository extends JpaRepository<PersonEntity, String> {

    @Query(value = "SELECT * FROM PERSON WHERE gender =:gender", nativeQuery = true)
    List<PersonEntity> getByGender(@Param("gender") String gender);

    @Query(value = "SELECT * FROM PERSON WHERE years =:years", nativeQuery = true)
    List<PersonEntity> getByEdad(@Param("years") Integer years);

    @Query(value = "SELECT * FROM PERSON WHERE years >= 18", nativeQuery = true)
    List<PersonEntity> getByMayores(@Param("years") Integer years);

    @Query(value = "SELECT *FROM person WHERE name LIKE 'A%' OR name LIKE 'a%'", nativeQuery = true)
    List<PersonEntity> getByName(@Param("name") String name);


}
