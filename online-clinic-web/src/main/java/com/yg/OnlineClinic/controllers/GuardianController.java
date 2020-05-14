package com.yg.OnlineClinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guardians")
@Controller
public class GuardianController {

    @RequestMapping({"","/","/index","/index.html"})
    public String listGuardians()
    {
        return "guardians/index";
    }
}
