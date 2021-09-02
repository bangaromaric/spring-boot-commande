package ga.banga.projet.repositories;


import ga.banga.projet.entities.Commande;
import ga.banga.projet.entities.Particulier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ParticulierRepository extends JpaRepository<Particulier,Long>{

}
