package ga.banga.projet.repositories;

import ga.banga.projet.entities.LigneCommands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommands,Long> {
}
