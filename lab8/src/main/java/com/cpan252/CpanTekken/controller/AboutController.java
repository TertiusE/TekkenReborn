package com.cpan252.CpanTekken.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    
    @GetMapping("/about")
    public String index() {
        return "about";
    }
}