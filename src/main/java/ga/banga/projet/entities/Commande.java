package ga.banga.projet.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Commande implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private int remise;
    private double montant;

    @ManyToOne
    private Client client;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @OneToMany(mappedBy = "commande")
    private Set<LigneCommands> ligneCommande;

    public Commande(Date date, int remise, double montant, Client client/*, Set<LigneCommands> ligneCommande*/) {
        this.date = date;
        this.remise = remise;
        this.montant = montant;
        this.client = client;
//        this.ligneCommande = ligneCommande;
    }

    public Commande() {

    }
}
