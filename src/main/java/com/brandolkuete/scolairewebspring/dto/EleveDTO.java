package com.brandolkuete.scolairewebspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EleveDTO extends PersonneDTO{
	
	private String niveau;
	private String filiere;
	
	public EleveDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite,
			String addresse, int age, String niveau, String filiere) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age);
		this.niveau = niveau;
		this.filiere = filiere;
	}
	

}
