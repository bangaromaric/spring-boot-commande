package ga.banga.projet.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@DiscriminatorValue("Societe")
public class Societe extends Client implements Serializable {
    private static final long serialVersionUID = 1L;


    private String MatriculeFinance;


    public Societe(String nom, String adresse, String mail, String matriculeFinance) {
        super(nom, adresse, mail);
        MatriculeFinance = matriculeFinance;
    }



    public Societe() {

    }
}
