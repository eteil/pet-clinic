package com.dej.petclinic.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {

    @RequestMapping({"index"})
    public String index(){
        return "index";
    }
}
