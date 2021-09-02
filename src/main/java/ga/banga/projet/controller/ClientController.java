package ga.banga.projet.controller;

import ga.banga.projet.entities.*;
import ga.banga.projet.metier.MetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("api/")
public class ClientController {

    @Autowired
    MetierImpl metier;

    @GetMapping("particuliers")
    public Collection<Particulier> getClients(){
    Collection<Particulier> resul = metier.getParticuliers();
        if (resul.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        else
            return metier.getParticuliers();
    }

    @GetMapping("societes")
    public Collection<Societe> getSocietes(){
        return metier.getSocietes();
    }

    @PostMapping(value = "particulier/add")
    public ResponseEntity<Particulier> ajouterParticulier(@RequestBody Particulier particulier){
        metier.insertParticulier(particulier);
        return new ResponseEntity<>(particulier, HttpStatus.CREATED);
    }

    @GetMapping(value = "commande/add")
    public ResponseEntity<Particulier> ajouterCommande(/*@RequestBody Particulier particulier*/){
        Particulier particulier = new Particulier("Romaric BANGA","Akebe","bangaromaric@gmail.ga");
        Produit produit = new Produit("Pain", Unite.G,1,125);

        produit.setId(5L);
        particulier.setId(1L);

        Set<LigneCommands> listLigneCommands = new HashSet<>();



//        metier.insertLigneCommand(ligneCommands);

       Commande cmd = metier.insertCommande(new Commande(new Date(),2,200,particulier/*,listLigneCommands*/));

        LigneCommands ligneCommands = new LigneCommands(produit,cmd,2);
        listLigneCommands.add(ligneCommands);

        metier.insertLigneCommand( new LigneCommands(produit,cmd,2));



        return new ResponseEntity<>(particulier, HttpStatus.CREATED);
    }


    @PutMapping(value = "particulier/update")
    public ResponseEntity<Particulier> updateParticulier(@RequestBody Particulier newParticulier, @RequestParam Long id){
      return metier.findParticulierById(id)
                .map(particulier -> {
                    particulier = newParticulier;
                    particulier.setId(id);
                    metier.insertParticulier(particulier);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(particulier);
                })
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Particulier not found"));
    }
}
