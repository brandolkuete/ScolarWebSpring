package com.brandolkuete.scolairewebspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDTO {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String date_nais;
	private String nationalite;
	private String addresse;
	private int age;

}
