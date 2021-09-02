package ga.banga.projet.controller;


import ga.banga.projet.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @Autowired
    IMetier metier;



}
