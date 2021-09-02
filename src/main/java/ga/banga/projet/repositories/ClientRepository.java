package ga.banga.projet.repositories;


import ga.banga.projet.entities.Client;
import ga.banga.projet.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{



}
