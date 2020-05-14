package com.yg.OnlineClinic.controllers;

import com.yg.OnlineClinic.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
