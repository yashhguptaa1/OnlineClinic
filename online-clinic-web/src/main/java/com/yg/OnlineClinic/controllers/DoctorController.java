package com.yg.OnlineClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {

    @RequestMapping({"/doctors","/doctors/index","/doctors/index.html"})
    public String listDoctors()
    {
        return "doctors/index";
    }
}
