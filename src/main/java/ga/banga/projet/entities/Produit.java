package ga.banga.projet.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Produit implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String designation;
    private Unite unite;
    private int poidsUnitaire;
    private int prixUnitaire;

//    @OneToMany(mappedBy = "produit")
//    private Set<LigneCommands> ligneCommande;


    public Produit(String designation, Unite unite, int poidsUnitaire, int prixUnitaire) {
        this.designation = designation;
        this.unite = unite;
        this.poidsUnitaire = poidsUnitaire;
        this.prixUnitaire = prixUnitaire;
    }

    public Produit() {

    }
}
