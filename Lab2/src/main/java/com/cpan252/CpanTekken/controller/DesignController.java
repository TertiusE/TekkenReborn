package com.cpan252.CpanTekken.controller;
import java.util.EnumSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.CpanTekken.model.Fighter.Anime;
import com.cpan252.CpanTekken.model.Fighter;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {
    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class).stream()
            .map(Anime::getTitle).collect(Collectors.toList());
        model.addAttribute("animes",animes);
        log.info("anime {}", animes);
    }

    @ModelAttribute
    public Fighter fighter() {
        return Fighter.builder().build();
    }
}
