package ga.banga.projet.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_client")
@DiscriminatorValue("Client")
public abstract class Client implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String adresse;
    private String mail;

    public Client(String nom, String adresse, String mail) {
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
    }

    public Client() {
    }
}
