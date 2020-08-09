package com.vtb.zolotarev.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/about")
    public String showAboutPage(){
        return "about-page";
    }


}
