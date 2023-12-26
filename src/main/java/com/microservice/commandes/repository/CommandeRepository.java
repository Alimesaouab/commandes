package com.microservice.commandes.repository;

import com.microservice.commandes.modele.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Additional methods can be added here
}