package com.yg.OnlineClinic.controllers;

import com.yg.OnlineClinic.model.Doctor;
import com.yg.OnlineClinic.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    // using spring to autowire automatically
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @RequestMapping({"/doctors","/doctors/index","/doctors/index.html"})
    public String listDoctors(Model model)
    {
        model.addAttribute("doctors",doctorService.findAll());
        return "doctors/index";
    }

    @GetMapping("/api/doctors")
    public @ResponseBody Set<Doctor> getDoctorsJson(){

        return doctorService.findAll();

    }
}
