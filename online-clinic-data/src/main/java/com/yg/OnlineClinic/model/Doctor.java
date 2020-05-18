package com.yg.OnlineClinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_specialities",joinColumns =@JoinColumn(name="doctor_id"),inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities=new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
