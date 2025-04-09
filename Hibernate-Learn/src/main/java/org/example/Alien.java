package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    @Id
    private int id;
    private String name;
    private String tech;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTech() {
        return tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
