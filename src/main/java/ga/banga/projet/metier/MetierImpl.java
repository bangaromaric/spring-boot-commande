package ga.banga.projet.metier;

import ga.banga.projet.entities.*;
import ga.banga.projet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MetierImpl implements  IMetier{

    @Autowired
    ParticulierRepository particulierRepository;

    @Autowired
    SocieteRepository societeRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    LigneCommandeRepository ligneCommandeRepository;
     @Autowired
     ClientRepository clientRepository;


    @Override
    public Particulier insertParticulier(Particulier particulier) {
        return particulierRepository.save(particulier);
    }

    @Override
    public Collection<Particulier> getParticuliers() {
        return particulierRepository.findAll();
    }

    @Override
    public Optional<Particulier> findParticulierById(Long id) {
        return particulierRepository.findById(id);
    }

    @Override
    public Client insertClient(Client client) {
        return null;
    }
    @Override
    public Collection<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return Optional.empty();
    }


    @Override
    public Societe insertSociete(Societe societe) {
        return societeRepository.save(societe);
    }

    @Override
    public Collection<Societe> getSocietes() {
        return societeRepository.findAll();
    }

    @Override
    public Optional<Societe> findSocieteById(Long id) {
        return Optional.empty();
    }

    @Override
    public Produit insertProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Collection<Produit> getProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> findProduitById(Long id) {
        return Optional.empty();
    }

    @Override
    public Commande insertCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Collection<Commande> getCommandes() {
        return null;
    }

    @Override
    public Optional<Commande> findCommandeById(Long id) {
        return Optional.empty();
    }

    @Override
    public LigneCommands insertLigneCommand(LigneCommands ligneCommands) {
        return ligneCommandeRepository.save(ligneCommands);
    }

    @Override
    public Collection<LigneCommands> getLigneCommands() {
        return null;
    }

    @Override
    public Optional<LigneCommands> findLigneCommandsById(Long id) {
        return Optional.empty();
    }
}
