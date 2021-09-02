package ga.banga.projet.controller;


import ga.banga.projet.entities.Particulier;
import ga.banga.projet.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class WebController {

    @Autowired
    IMetier metier;


    @GetMapping("/")
    public String home(Model model) {
        Collection<Particulier> part = metier.getParticuliers();
        model.addAttribute("particuliers", part);
        return "index";
    }


}
