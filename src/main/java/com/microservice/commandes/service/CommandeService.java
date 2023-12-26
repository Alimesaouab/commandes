package com.microservice.commandes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservice.commandes.modele.Commande;
import com.microservice.commandes.repository.CommandeRepository;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public Optional<Commande> updateCommande(Long id, Commande updatedCommande) {
        Optional<Commande> existingCommande = commandeRepository.findById(id);

        if (existingCommande.isPresent()) {
            updatedCommande.setId(id);
            return Optional.of(commandeRepository.save(updatedCommande));
        }

        return Optional.empty();
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}