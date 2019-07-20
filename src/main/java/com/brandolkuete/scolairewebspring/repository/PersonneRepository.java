package com.brandolkuete.scolairewebspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandolkuete.scolairewebspring.entities.Personne;

public interface PersonneRepository<T extends Personne> extends JpaRepository<Personne, Long>{

}
