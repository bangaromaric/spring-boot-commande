package ga.banga.projet.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@DiscriminatorValue("Particulier")
public class Particulier extends Client implements Serializable {
    private static final long serialVersionUID = 1L;


    public Particulier(String nom, String adresse, String mail) {
        super(nom, adresse, mail);
    }

    public Particulier() {

    }
}
