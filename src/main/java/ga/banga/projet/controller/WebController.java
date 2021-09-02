package ga.banga.projet.controller;


import ga.banga.projet.entities.Client;
import ga.banga.projet.entities.Particulier;
import ga.banga.projet.entities.Societe;
import ga.banga.projet.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

     @GetMapping("/societe")
    public String getSocietes(Model model) {
        Collection<Societe> sos = metier.getSocietes();
        model.addAttribute("societes", sos);
        return "societe";
    }

     @GetMapping("/addClient")
     public String addParticulier(Model model) {
         model.addAttribute("client", new Particulier());
        return "addClient";
     }

    @PostMapping("/addClient")
    public String particulierSubmit(@ModelAttribute Particulier particulier, Model model, @RequestParam String type, @RequestParam String mat) {

        if (type.equals("1")){
            metier.insertParticulier(particulier);
            return "redirect:/";
        }
        else {
            Societe societe = new Societe(particulier.getNom(),particulier.getAdresse(),particulier.getMail(),mat);
            metier.insertSociete(societe);
            return "redirect:/societe";
        }


//
//        model.addAttribute("name", particulier);
    }



}
