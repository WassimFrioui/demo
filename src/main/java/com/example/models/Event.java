package com.example.models;

public class Event {

    private Integer id;
    private String name;
    private String description;
    private Boolean active;
    private Discipline discipline;

    public Event(Integer id, String name, String description, Boolean active, Discipline discipline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.discipline = discipline;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return active;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", discipline=" + discipline +
                '}';
    }

}
