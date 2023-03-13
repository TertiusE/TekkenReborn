package com.cpan252.CpanTekken.controller;
import java.util.EnumSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cpan252.CpanTekken.model.Fighter.Anime;
import com.cpan252.CpanTekken.repository.FighterRepository;

import jakarta.validation.Valid;

import com.cpan252.CpanTekken.model.Fighter;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {
    
    @Autowired
    private FighterRepository fighterRepository;

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

    @ModelAttribute
    public Fighter fighter() {
        return Fighter.builder().build();
    }

    @PostMapping
    public String processFighterAddition(@Valid Fighter fighter, BindingResult result) {
        if (result.hasErrors()){
            return "design";  
        }
        log.info("Processing fighter: {}", fighter);
        fighterRepository.save(fighter);
        return "redirect:/design";
    }
}
