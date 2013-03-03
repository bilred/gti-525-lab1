package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHOW_SALLE")
public class Salle implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")	
	private Double idSalle;
        @Column(name="NAME")
	private String nom;
        @Column(name="NB_Place")
	private Integer nbPlace;
        @Column(name="ADRESSE_SALLE")
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
