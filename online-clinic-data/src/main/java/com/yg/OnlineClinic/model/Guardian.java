package com.yg.OnlineClinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "guardians")
public class Guardian extends Person{

    @Builder
    public Guardian(Long id, String firstName, String lastName, String address, String city,
                    String telephone, Set<Pet> pets) {


        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;

        if (pets != null) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name="telephone")
    private String telephone;

    //many patients can have a single guardian
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "guardian")
    private Set<Pet>pets=new HashSet<>();

}
