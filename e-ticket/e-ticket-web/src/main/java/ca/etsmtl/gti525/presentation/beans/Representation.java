package ca.etsmtl.gti525.presentation.beans;

import java.util.Date;


/**
 * @author REDOUANE
 *
 */
public class Representation {

	private Integer nbBilletsDispo;
	private Float prix;
	private String nom;
	private String adresse;	
	private Date dateDebut;
	private Date dateFin;
	private Boolean isAnnulation;  
	
	private Spectacle spectacle;

		
	
	
	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public Integer getNbBilletsDispo() {
		return nbBilletsDispo;
	}

	public void setNbBilletsDispo(Integer nbBilletsDispo) {
		this.nbBilletsDispo = nbBilletsDispo;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getIsAnnulation() {
		return isAnnulation;
	}

	public void setIsAnnulation(Boolean isAnnulation) {
		this.isAnnulation = isAnnulation;
	}


	

	
}
