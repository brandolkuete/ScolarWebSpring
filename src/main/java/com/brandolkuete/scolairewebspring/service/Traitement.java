package com.brandolkuete.scolairewebspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brandolkuete.scolairewebspring.entities.Eleve;
import com.brandolkuete.scolairewebspring.entities.Enseignant;
import com.brandolkuete.scolairewebspring.repository.EleveRepository;
import com.brandolkuete.scolairewebspring.repository.EnseignantRepository;

/**
 * @author Brandol
 *Cette classe contient tous les savoir-faire du programme
 */
@Service
public class Traitement implements ITraitements {
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired 
	private EnseignantRepository enseignantRepository;
	
	/**
	 * @param enseig
	 * Cette methode permet d'enregistrer un enseignant dans la base de donn�es
	 */
	public Enseignant enregistrerEnseignant(Enseignant enseig) {
		
		return enseignantRepository.save(enseig);
		}
	
	/**
	 * @param eleve
	 * Cette m�thode permet d'enregistrer un eleve dans la base de donn�es
	 */
	public Eleve enregistrerEleve(Eleve eleve) {
		
		return eleveRepository.save(eleve);
	}
	

	@Override
	public List<Eleve> listerElevesService() {
		return eleveRepository.findAll();
	}

	@Override
	public List<Enseignant> listerEnseignantsService() {
		
		return enseignantRepository.findAll();
	}

}
