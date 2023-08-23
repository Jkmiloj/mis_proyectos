package com.persona.demo.persistence.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    private Integer cc;
    private String name;
    private String lastname;
    private String gender;
    private Date born_date;
    private Integer years;
    private String cellphone;

    public PersonEntity() {
    }

    public PersonEntity(Integer cc, String name, String lastname, String gender, Date born_date, Integer years, String cellphone) {
        this.cc = cc;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.born_date = born_date;
        this.years = years;
        this.cellphone = cellphone;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date) {
        this.born_date = born_date;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
