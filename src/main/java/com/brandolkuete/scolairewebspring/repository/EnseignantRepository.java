package com.brandolkuete.scolairewebspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brandolkuete.scolairewebspring.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
