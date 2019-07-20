package com.brandolkuete.scolairewebspring.dto;


public class EnseignantDTO extends PersonneDTO {
	
	private String situationMat;
	private String specialite;
	private String grade;
	private String email;
	private String telephone;
	private double salaire;
	
	public EnseignantDTO() {
		super();
	}
	
	public EnseignantDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite,
			String addresse, int age) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age);
	}
	
	public EnseignantDTO(String matricule, String nom, String prenom, String sexe, String date_nais, String nationalite,
			String addresse, int age, String situationMat, String specialite, String grade, String email,
			String telephone, double salaire) {
		super(matricule, nom, prenom, sexe, date_nais, nationalite, addresse, age);
		this.situationMat = situationMat;
		this.specialite = specialite;
		this.grade = grade;
		this.email = email;
		this.telephone = telephone;
		this.salaire = salaire;
	}

	public String getSituationMat() {
		return situationMat;
	}

	public void setSituationMat(String situationMat) {
		this.situationMat = situationMat;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

}
