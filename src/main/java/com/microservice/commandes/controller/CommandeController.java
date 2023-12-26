package com.microservice.commandes.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.commandes.modele.Commande;
import com.microservice.commandes.repository.CommandeRepository;
import com.microservice.commandes.service.CommandeService;
@RestController
@RequestMapping("/commandes")
public class CommandeController  implements HealthIndicator {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommande() {
        return commandeService.getAllCommandes();
    }

    @PostMapping(value ="/saveCommande/{id}")
    public Commande saveCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping(value ="/updateCommande/{id}")
    public Optional<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return commandeService.updateCommande(id, commande);
    }

    @DeleteMapping(value ="/deleteCommande/{id}")
    public void deleteCommande(@PathVariable Long id) {
    	commandeService.deleteCommande(id);
    }
    
    @Override
    public Health health() {
        List<Commande> commandes = commandeService.getAllCommandes();
        if(commandes.isEmpty()){
            return Health.down().build();
        }
        return Health.up().build();
    }

}