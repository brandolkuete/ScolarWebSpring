package com.brandolkuete.scolairewebspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Eleve extends Personne {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String niveau;
	private String filiere;
	
	public Eleve(String matricule, String nom, String prenom, String sexe, String date_nais,
			String nationalite, String addresse, int age, String niveau, String filiere) {
		this.niveau = niveau;
		this.filiere = filiere;
	}
	
	
	

}