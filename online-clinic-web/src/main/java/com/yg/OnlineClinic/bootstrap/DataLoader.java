package com.yg.OnlineClinic.bootstrap;

import com.yg.OnlineClinic.model.Doctor;
import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.DoctorService;
import com.yg.OnlineClinic.services.GuardianService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    // specific springboot way of initializing data

    private final GuardianService guardianService;
    private final DoctorService doctorService;

    // dont need to use @autowire as we used spring to create this constructor
    public DataLoader(GuardianService guardianService, DoctorService doctorService)
    {


        this.guardianService = guardianService;
        this.doctorService = doctorService;
    }


    @Override
    public void run(String... args) throws Exception {

        Guardian guardian1=new Guardian();
        guardian1.setId(1L); // from extending BaseEntity
        guardian1.setFirstName("Sunit"); //from extending Person
        guardian1.setLastName("Gupta");//from extending Person

        guardianService.save(guardian1);// from extending CrudService

        Guardian guardian2=new Guardian();
        guardian2.setId(2L);
        guardian2.setFirstName("Sapna");
        guardian2.setLastName("Gupta");

        guardianService.save(guardian2);

        System.out.println("Loaded Guardians....");



        Doctor doctor1=new Doctor();
        doctor1.setId(1L);
        doctor1.setFirstName("Anmol");
        doctor1.setLastName("Malhotra");

        doctorService.save(doctor1);


        Doctor doctor2=new Doctor();
        doctor2.setId(2L);
        doctor2.setFirstName("Gurnoor");
        doctor2.setLastName("Kaur");

        doctorService.save(doctor2);

        System.out.println("Loaded Doctors....");




    }
}
