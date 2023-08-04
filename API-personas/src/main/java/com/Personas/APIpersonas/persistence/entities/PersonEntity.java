package com.Personas.APIpersonas.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="person")
public class PersonEntity {

    @Id
    private Integer CC;
    private String name;
    private String lastname;
    private char gender;
    private LocalDate born;
    private int years;
    private Integer cel;

     public PersonEntity(Integer CC, String name, String lastname, char gender, LocalDate born, int years, Integer cel) {
        this.CC = CC;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.born = born;
        this.years = calcularEdad();
        this.cel = cel;
    }

    private int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(born,fechaActual).getYears();
    }

    public Integer getCC() {
        return CC;
    }

    public void setCC(Integer CC) {
        this.CC = CC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public char getGender() {
        return gender;
    }

    public void setGenero(char gender) {
        this.gender = gender;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Integer getCel() {
        return cel;
    }

    public void setCel(Integer cel) {
        this.cel = cel;
    }
}
