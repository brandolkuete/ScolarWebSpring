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
public class Enseignant extends Personne {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String situationMat;
	private String specialite;
	private String grade;
	private String email;
	private String telephone;
	private double salaire;

}
