package com.yg.OnlineClinic.controllers;


import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.GuardianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    //handling form post
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /*@RequestMapping({"","/","/index","/index.html"})
    public String listGuardians(Model model)
    {
        model.addAttribute("guardians",guardianService.findAll());
        return "guardians/index";
    }*/


    @RequestMapping("/find")
    public String findGuardians(Model model){

        model.addAttribute("guardian", Guardian.builder().build());

        return "guardians/findGuardians";
    }

    @GetMapping("/{guardianId}")
    public ModelAndView showOwner(@PathVariable Long guardianId) {
        ModelAndView mav = new ModelAndView("guardians/guardianDetails");
        mav.addObject(guardianService.findById(guardianId));
        return mav;
    }

    @GetMapping
    public String processFindForm(Guardian guardian, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (guardian.getLastName() == null) {
            guardian.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Guardian> results = guardianService.findAllByLastNameLike("%"+ guardian.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "guardians/findGuardians";
        } else if (results.size() == 1) {
            // 1 owner found
            guardian = results.get(0);
            return "redirect:/guardians/" + guardian.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "guardians/guardiansList";
        }
    }

}
