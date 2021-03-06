package ga.banga.projet.controller;


import ga.banga.projet.entities.*;
import ga.banga.projet.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Date;

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
        return "client/societe";
    }

    @GetMapping("/produit")
    public String getProduits(Model model) {
        Collection<Produit> result = metier.getProduits();
        model.addAttribute("produits", result);
        return "produit/produit";
    }

    @GetMapping("/addProduit")
    public String addProduit(Model model) {
        model.addAttribute("produit", new Produit());
        return "produit/addProduit";
    }

    @PostMapping("/addProduit")
    public String produitSubmit(@ModelAttribute Produit produit, Model model) {
            metier.insertProduit(produit);
            return "redirect:/produit";
    }


     @GetMapping("/addClient")
     public String addParticulier(Model model) {
         model.addAttribute("client", new Particulier());
        return "client/addClient";
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

    }


    @GetMapping("/commandes")
    public String getLigneCommandes(Model model) {
        Collection<LigneCommands> result = metier.getLigneCommands();
        model.addAttribute("commandesLigne", result);
        return "commande/commandes";
    }

    @GetMapping("/addCommandes")
    public String addCommande(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("clients", metier.getClients());
        model.addAttribute("produits", metier.getProduits());
        return "commande/addCommande";
    }

    @PostMapping("/addCommandes")
    public String commandeSubmit(@ModelAttribute Produit produit, Client client, String remise, String quantite, Model model) {
//        metier.insertProduit(produit);

        Commande cmd = metier.insertCommande(new Commande(new Date(),Integer.parseInt(remise),produit.getPrixUnitaire(),client));

        metier.insertLigneCommand( new LigneCommands(produit,cmd,Integer.parseInt(quantite)));


        return "redirect:/commandes";
    }





}
