package com.yg.OnlineClinic.bootstrap;

import com.yg.OnlineClinic.model.*;
import com.yg.OnlineClinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    // specific springboot way of initializing data

    private final GuardianService guardianService;
    private final DoctorService doctorService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    // dont need to use @autowire as we used spring to create this constructor


    public DataLoader(GuardianService guardianService, DoctorService doctorService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.guardianService = guardianService;
        this.doctorService = doctorService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count= petTypeService.findAll().size();


        if(count==0)
        {
            loadData();

        }
    }

    private void loadData(){



        PetType cough=new PetType();
        cough.setName("cough");
        PetType savedCoughType=petTypeService.save(cough);

        PetType cold=new PetType();
        cold.setName("cold");
        PetType savedColdType=petTypeService.save(cold);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery=specialityService.save(surgery);


        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentist");
        Speciality savedDentistry=specialityService.save(dentistry);



        Guardian guardian1=new Guardian();
        guardian1.setFirstName("Sunit"); //from extending Person
        guardian1.setLastName("Gupta");//from extending Person
        guardian1.setAddress("A6/253");
        guardian1.setCity("Delhi");
        guardian1.setTelephone("7838136108");

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedCoughType);
        mikesPet.setGuardian(guardian1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("macho");
        guardian1.getPets().add(mikesPet);

        guardianService.save(guardian1);// from extending CrudService


        Guardian guardian2=new Guardian();
        guardian2.setFirstName("Sapna");
        guardian2.setLastName("Gupta");
        guardian2.setAddress("A6/253");
        guardian2.setCity("Delhi");
        guardian2.setTelephone("7838136108");


        guardianService.save(guardian2);

        Visit catVisit=new Visit();
        catVisit.setPet(mikesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Guardians....");



        Doctor doctor1=new Doctor();
        doctor1.setFirstName("Anmol");
        doctor1.setLastName("Malhotra");
        doctor1.getSpecialities().add(savedDentistry);

        doctorService.save(doctor1);


        Doctor doctor2=new Doctor();
        doctor2.setFirstName("Gurnoor");
        doctor2.setLastName("Kaur");
        doctor2.getSpecialities().add(savedSurgery);

        doctorService.save(doctor2);

        System.out.println("Loaded Doctors....");




    }
}
