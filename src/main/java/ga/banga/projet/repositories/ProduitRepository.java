package ga.banga.projet.repositories;


import ga.banga.projet.entities.Particulier;
import ga.banga.projet.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>{

}
