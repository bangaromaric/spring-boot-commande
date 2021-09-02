package ga.banga.projet.repositories;


import ga.banga.projet.entities.Commande;
import ga.banga.projet.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocieteRepository extends JpaRepository<Societe,Long>{



}
