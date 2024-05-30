package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Athlete {

    private Integer id;
    private String lastName;
    private String firstName;
    private String country;
    private Character sex;
    private Integer age;
    private List<Discipline> discipline;

    public Athlete(Integer id, String lastName, String firstName, String country, Character sex, Integer age,
            List<Discipline> discipline) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
        this.sex = sex;
        this.age = age;
        this.discipline = discipline != null ? discipline : new ArrayList<>();
    }

    public Athlete(String firstName, String lastName, String ageText, String sexText, String countryText) {
        this(null, lastName, firstName, countryText, sexText.charAt(0), Integer.parseInt(ageText), new ArrayList<>());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(List<Discipline> discipline) {
        this.discipline = discipline;
    }

    public String getName() {
        return lastName + " " + firstName;
    }

    public void addDiscipline(Discipline discipline) {
        this.discipline.add(discipline);
    }

    public void removeDiscipline(Discipline discipline) {
        this.discipline.remove(discipline);
    }

    public void addAthlete(String firstName, String lastName, String age, String coutry) {
        Athlete athlete = new Athlete(null, firstName, lastName, coutry, 'M', Integer.parseInt(age), new ArrayList<>());

    }

    @Override
    public String toString() {
        return "Athlete{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", country=" + country
                + ", sex=" + sex + ", age=" + age + ", discipline=" + discipline + '}';
    }
}
