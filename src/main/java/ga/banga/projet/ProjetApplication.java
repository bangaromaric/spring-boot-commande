package ga.banga.projet;

import ga.banga.projet.entities.*;
import ga.banga.projet.metier.MetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {
    @Autowired
    MetierImpl metier;

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        metier.insertSociete(new Societe("SEEG","VILLE","contact@seeg.ga","748sdsd"));
        metier.insertSociete(new Societe("CNSS","Renovation","contact@cnss.ga","78451"));
        metier.insertParticulier(new Particulier("Romaric BANGA","Akebe","bangaromaric@gmail.ga"));
        metier.insertParticulier(new Particulier("Tanguy BANGA","Akebe","bangatanguy@gmail.ga"));
        metier.insertProduit(new Produit("Pain", Unite.G,1,125));


    }
}
