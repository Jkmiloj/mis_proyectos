package com.Personas.APIpersonas.persistence.repository;
import com.Personas.APIpersonas.persistence.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudRepository extends JpaRepository<PersonEntity,String> {

    List<PersonEntity> findAll();

    @Query(value = "SELECT p.gender"+
                    "FROM person p"+
                    "WHERE p.gender=: M OR "+
                    "p.gender=:F", nativeQuery = true)
    PersonEntity getByGender(@Param("gender") String gender);

    List<PersonEntity> getByYears();

    /*@Query (value = "SELECT *FROM person WHERE years >=: 18 OR years =: 5", nativeQuery = true)
    PersonEntity getByYears(@Param("years") int years);*/

    @Query(value = "SELECT *FROM person WHERE name LIKE 'A%' OR name LIKE 'a%'", nativeQuery = true)
    PersonEntity getByName(@Param("name") String name);


}
