package com.example.findinternship.controller;


import com.example.findinternship.model.Internship;
import com.example.findinternship.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InternshipController {
    @Autowired
    private InternshipService internshipService;


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listInternships", internshipService.getAllInternships());
        return "index";
    }

    @GetMapping("/showNewInternshipForm")
    public String showNewInternshipForm(Model model){
        Internship internship = new Internship();
        model.addAttribute("internship", internship);
        return "new_internship";
    }

    @PostMapping("/saveInternship")
    public String saveInternship(@ModelAttribute("internship") Internship internship){
        internshipService.saveInternship(internship);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id, Model model){
        Internship internship= internshipService.getInternshipById(id);
        model.addAttribute("internship", internship);
        return "update_internship";
    }

    @GetMapping("/deleteInternship/{id}")
    public String deleteInternship(@PathVariable(value="id") long id){
        this.internshipService.deleteInternshipById(id);
        return "redirect:/";
    }
}
