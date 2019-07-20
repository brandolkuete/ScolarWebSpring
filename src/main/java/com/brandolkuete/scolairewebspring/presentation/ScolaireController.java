package com.brandolkuete.scolairewebspring.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.brandolkuete.scolairewebspring.dto.EleveDTO;
import com.brandolkuete.scolairewebspring.dto.EnseignantDTO;
import com.brandolkuete.scolairewebspring.entities.Eleve;
import com.brandolkuete.scolairewebspring.entities.Enseignant;
import com.brandolkuete.scolairewebspring.entities.User;
import com.brandolkuete.scolairewebspring.service.ITraitements;
import com.brandolkuete.scolairewebspring.service.UserService;
import com.google.common.collect.Lists;

@Controller
public class ScolaireController {
	
	@Autowired
	private ITraitements traitement;
	
	@Autowired
	UserService userService;

		
	@GetMapping("/listeEleve")
	public String listeEleves(Model model) {
		
		//recuperation de la liste des eleves
		final List<Eleve> listeEleves= traitement.listerElevesService();
		
		//convertion des Eleve en EleveDTO (les objets avec leurs ID ne doivent circuler dans le reseau)
		final List<EleveDTO> listeElevesDto= Lists.transform(listeEleves, 
				(Eleve elev) -> new EleveDTO(elev.getMatricule(), elev.getNom(), elev.getPrenom(), elev.getSexe(), elev.getDate_nais(), elev.getNationalite(), elev.getAddresse(), elev.getAge(), elev.getNiveau(), elev.getFiliere()) );
		
		//Enregistrement dans le modèle
		model.addAttribute("listeEleve",listeElevesDto);
		
		return "listerEleves";
	}
	
	@GetMapping("/listeEnseignant")
	public String listeEnseignants(Model model) {
		
		//recuperation de la liste des enseignants de la BD
		final List<Enseignant> listeEnseignants= traitement.listerEnseignantsService();
		
		final List<EnseignantDTO> listeEnseignantsDto= Lists.transform(listeEnseignants, 
				(Enseignant enseig) -> new EnseignantDTO(enseig.getMatricule(), enseig.getNom(), enseig.getPrenom(), enseig.getSexe(), enseig.getDate_nais(), enseig.getNationalite(), enseig.getAddresse(), enseig.getAge(), enseig.getSituationMat(), enseig.getSpecialite(), enseig.getGrade(), enseig.getEmail(), enseig.getTelephone(), enseig.getSalaire()));
		model.addAttribute("listeEnseignants",listeEnseignantsDto);
		
		return "listeEnseignants";
	}
	
	//controlleur qui nous redirigera vers la page contenant le formulaire d'enregistrement d'un eleve
	@GetMapping("/enregistrerEleve")
	public String pageEnregistrementEleve(Model model) {   
		
		
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = userService.findUserByEmail(auth.getName());
		
		model.addAttribute("userName", user.getName());
		model.addAttribute("eleveDto", new EleveDTO());
		
		return "enregistrerEleve";
	}
	
	//controlleur qui nous redirigera vers la page contenant le formulaire d'enregistrement d'un enseignant
		@GetMapping("/enregistrerEnseignant")
		public String pageEnregistrementEnseignant(Model model) {   
			
			
			final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			final User user = userService.findUserByEmail(auth.getName());
			
			model.addAttribute("userName", user.getName());
			model.addAttribute("eleveDto", new EleveDTO());
			
			return "enregistrerEnseignant";
		}
		
		//Traitement des informations entrées dans le formulaire d'enregistrement de l'enseignant
		@PostMapping("/enregistrerEnseignantForm")
		public String enregistrerEnseignant(@ModelAttribute EnseignantDTO enseignantDto, Model model) {
			
			Enseignant enseig= new Enseignant();
			
			enseig.setMatricule(enseignantDto.getMatricule());
			enseig.setNom(enseignantDto.getNom());
			enseig.setPrenom(enseignantDto.getPrenom());
			enseig.setSexe(enseignantDto.getSexe());
			enseig.setDate_nais(enseignantDto.getDate_nais());
			enseig.setNationalite(enseignantDto.getNationalite());
			enseig.setAddresse(enseignantDto.getAddresse());
			enseig.setAge(enseignantDto.getAge());
			enseig.setSituationMat(enseignantDto.getSituationMat());
			enseig.setEmail(enseignantDto.getEmail());
			enseig.setSpecialite(enseignantDto.getSpecialite());
			enseig.setGrade(enseignantDto.getGrade());
			enseig.setTelephone(enseignantDto.getTelephone());
			enseig.setSalaire(enseignantDto.getSalaire());
			
			traitement.enregistrerEnseignant(enseig);
			
			return "redirect:listeEnseignant";
		}
	
	
	// Traitement des valeurs saisies dans le formulaire
	@PostMapping("/enregistrerEleveForm")
	public String enregistrerEleve(@ModelAttribute EleveDTO eleveDto, Model model) {
		
		Eleve eleve= new Eleve();
		
		eleve.setMatricule(eleveDto.getMatricule());
		eleve.setNom(eleveDto.getNom());
		eleve.setPrenom(eleveDto.getPrenom());
		eleve.setSexe(eleveDto.getSexe());
		eleve.setDate_nais(eleveDto.getDate_nais());
		eleve.setNationalite(eleveDto.getNationalite());
		eleve.setAddresse(eleveDto.getAddresse());
		eleve.setAge(eleveDto.getAge());
		eleve.setNiveau(eleveDto.getNiveau());
		eleve.setFiliere(eleveDto.getFiliere());
		
		traitement.enregistrerEleve(eleve);
		
		return "redirect:listeEleve";
	}
	
}
