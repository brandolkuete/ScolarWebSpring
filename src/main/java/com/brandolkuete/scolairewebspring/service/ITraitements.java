package com.brandolkuete.scolairewebspring.service;

import java.util.List;

import com.brandolkuete.scolairewebspring.entities.Eleve;
import com.brandolkuete.scolairewebspring.entities.Enseignant;

public interface ITraitements {
	
	public Enseignant enregistrerEnseignant(Enseignant enseig);
	public Eleve enregistrerEleve(Eleve eleve);
	/*public Eleve rechercherEleveService(String nom);
	public Enseignant rechercherEnseignantService(String nom);*/
	public List<Eleve> listerElevesService();
	public List<Enseignant> listerEnseignantsService();
	/*public Eleve rechercherElevService(String matricule);
	public Enseignant rechercherEnseigService(String matricule);*/

}
