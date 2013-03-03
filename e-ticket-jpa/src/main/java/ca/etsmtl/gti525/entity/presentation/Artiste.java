package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHOW_ARTISTE")
public class Artiste implements Serializable {
        private static final long serialVersionUID = 1L;
    
        @Id
        @Column(name="NOM")
	private String nom;
        @Column(name="PHOTO")
	private String lienPhoto;
        @Column(name="DESCRIPTION")
	private String Description;
	
		
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLienPhoto() {
		return lienPhoto;
	}
	public void setLienPhoto(String lienPhoto) {
		this.lienPhoto = lienPhoto;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
