package com.ankan.SpringJDBC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //manage particular bean
@Scope("prototype")
public class Developer {
    private int id;
    private String name;
    private String tech;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTech() {
        return tech;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
