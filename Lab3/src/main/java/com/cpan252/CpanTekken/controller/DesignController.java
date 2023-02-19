package com.cpan252.CpanTekken.controller;
import java.util.EnumSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes; 
import com.cpan252.CpanTekken.model.Fighter.Anime;
import com.cpan252.CpanTekken.model.Fighter;
import com.cpan252.CpanTekken.model.FighterPool;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SessionAttributes("fighterPool")
@RequestMapping("/design")
public class DesignController {
    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class).stream().collect(Collectors.toList());
        model.addAttribute("animes",animes);
        log.info("anime {}", animes);
    }

    @ModelAttribute(name = "fighterPool")
    public FighterPool fighterPool() {
        return new FighterPool();
    }

    @ModelAttribute
    public Fighter fighter() {
        return Fighter.builder().build();
    }

    @PostMapping
    public String processFighterAddition(Fighter fighter, @ModelAttribute FighterPool pool, Errors errors) {
        if (errors.hasErrors()){
            return "design";  
        }
        System.out.println(fighter);
        pool.add(fighter);
        return "redirect:/design";
    }
}
