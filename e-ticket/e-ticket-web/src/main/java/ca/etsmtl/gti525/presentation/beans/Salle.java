package ca.etsmtl.gti525.presentation.beans;


public class Salle {
	
	private Double idSalle;
	private String nom;
	private Integer nbPlace;
	private String adresseSalle; //pas besoin d'etre d�composer.	
	
	private Representation representation;
	
	
	
	
	public Double getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Double idSalle) {
		this.idSalle = idSalle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public String getAdresseSalle() {
		return adresseSalle;
	}
	public void setAdresseSalle(String adresseSalle) {
		this.adresseSalle = adresseSalle;
	}	
	

}
