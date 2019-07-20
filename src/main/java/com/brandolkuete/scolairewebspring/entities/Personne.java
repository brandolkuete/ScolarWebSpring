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
public class Personne {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String date_nais;
	private String nationalite;
	private String addresse;
	private int age;
	
	public Personne(Long id, String matricule, String nom, String prenom, String sexe, String date_nais,
			String nationalite, String addresse, int age) {
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.date_nais = date_nais;
		this.nationalite = nationalite;
		this.addresse = addresse;
		this.age = age;
	}
	
	
}
