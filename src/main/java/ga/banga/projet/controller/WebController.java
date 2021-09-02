package ga.banga.projet.controller;


import ga.banga.projet.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    IMetier metier;


    @GetMapping("/")
    public String home(Model model) {
//        model.addAttribute("greeting", new Client());
        return "index";
    }


}
