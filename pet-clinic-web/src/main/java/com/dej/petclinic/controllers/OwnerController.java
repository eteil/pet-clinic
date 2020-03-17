package com.dej.petclinic.controllers;

import com.dej.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping({"/owners"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImpl";
    }
}
