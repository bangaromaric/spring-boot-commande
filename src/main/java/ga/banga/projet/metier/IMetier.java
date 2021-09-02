package ga.banga.projet.metier;

import ga.banga.projet.entities.*;

import java.util.Collection;
import java.util.Optional;

public interface IMetier {

    Particulier insertParticulier(Particulier particulier);
    Collection<Particulier> getParticuliers();
    Optional<Particulier> findParticulierById(Long id);

    Client insertClient(Client client);
    Collection<Client> getClients();
    Optional<Client> findClientById(Long id);

    Societe insertSociete(Societe societe);
    Collection<Societe> getSocietes();
    Optional<Societe> findSocieteById(Long id);

    Produit insertProduit(Produit produit);
    Collection<Produit> getProduits();
    Optional<Produit> findProduitById(Long id);

    Commande insertCommande(Commande commande);
    Collection<Commande> getCommandes();
    Optional<Commande> findCommandeById(Long id);

    LigneCommands insertLigneCommand(LigneCommands ligneCommands);
    Collection<LigneCommands> getLigneCommands();
    Optional<LigneCommands> findLigneCommandsById(Long id);




}
