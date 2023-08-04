package com.Personas.APIpersonas.domain;
import java.time.Period;
import java.time.LocalDate;

public class Person {
    private Integer CC;
    private String name;
    private String lastname;
    private char gender;
    private LocalDate born;
    /*private int years;*/
    private Integer cel;

    public Person(Integer CC, String name, String lastname, char gender, LocalDate born, Integer cel) {
        this.CC = CC;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.born = born;
        /*this.years = calcularEdad();*/
        this.cel = cel;
    }

    /*public int calcularEdad(){
        LocalDate fechaActual = LocalDate.now();
        return Period.between(born,fechaActual).getYears();
    }*/

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

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public int getYears() {
        LocalDate actualDate = LocalDate.now();
        return Period.between(born, actualDate).getYears();
    }

    /*public void setYears(int years) {
        this.years = years;
    }*/

    public Integer getCel() {
        return cel;
    }

    public void setCel(Integer cel) {
        this.cel = cel;
    }
}
