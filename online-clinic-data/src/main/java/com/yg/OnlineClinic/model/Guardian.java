package com.yg.OnlineClinic.model;

import java.util.Set;

public class Guardian extends Person{

    private Set<Pet>pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
