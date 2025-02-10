package org.example.model;

public class Director {
    private String directorId;
    private String name;

    public Director(String directorId, String name) {
        this.directorId = directorId;
        this.name = name;
    }

    public String getDirectorId() { return directorId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Director{" + "name='" + name + '\'' + '}';
    }
}
