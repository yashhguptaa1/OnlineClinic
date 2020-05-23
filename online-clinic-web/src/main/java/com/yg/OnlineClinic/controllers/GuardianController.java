package com.yg.OnlineClinic.controllers;


import com.yg.OnlineClinic.services.GuardianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/guardians")
@Controller
public class GuardianController {

    /*
    Client side gets controller which in turn gets service
    which in turn gets the data i.e  list of guaurdians

     */
    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }


    @RequestMapping({"","/","/index","/index.html"})
    public String listGuardians(Model model)
    {
        model.addAttribute("guardians",guardianService.findAll());
        return "guardians/index";
    }

    @RequestMapping("/guardians/find")
    public String findGuardians(){
        return "notimplemented";
    }

    @GetMapping("/{guardianId}")
    public ModelAndView showOwner(@PathVariable Long guardianId) {
        ModelAndView mav = new ModelAndView("guardians/guardianDetails");
        mav.addObject(guardianService.findById(guardianId));
        return mav;
    }
}
