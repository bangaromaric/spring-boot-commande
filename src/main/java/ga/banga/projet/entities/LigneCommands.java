package ga.banga.projet.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class LigneCommands implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

   private int quatite;

    public LigneCommands(Produit produit, Commande commande, int quatite) {
        this.produit = produit;
//        this.commande = commande;
        this.quatite = quatite;
    }

    public LigneCommands() {

    }
}
