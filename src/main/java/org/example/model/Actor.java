package org.example.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Actor {
    private String actorId;
    private String name;
    private LocalDate birthDate;

    public Actor(String actorId, String name, String birthDate) {
        this.actorId = actorId;
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getActorId() { return actorId; }
    public String getName() { return name; }
    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Actor{" + "name='" + name + '\'' + ", age=" + getAge() + '}';
    }
}
