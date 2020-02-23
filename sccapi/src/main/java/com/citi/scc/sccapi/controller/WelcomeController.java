package com.citi.scc.sccapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2; 
 

@Controller 
@Log4j2
public class WelcomeController {
 
    @GetMapping("/welcome")
	    public String welcome(Model model) {
	       log.info("welcome controller");
	        return "welcome.html";
	    }
}