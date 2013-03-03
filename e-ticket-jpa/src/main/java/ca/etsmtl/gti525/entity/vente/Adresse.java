package ca.etsmtl.gti525.entity.vente;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHOW_ADRESSE")
public class Adresse implements Serializable{
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private String idAdresse;
    
        @Column(name = "RUE")
	private String rue;
        
        @Column(name = "APPARTEMENT")
	private String appartement;
        
        @Column(name = "VILLE")
	private String ville;
        
        @Column(name = "REGION")
	private String region;
        
        @Column(name = "CODE_POSTAL")
	private String codePostal;
	
	
	public String getIdAdresse() {
        return idAdresse;
        }

        public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
        }
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getAppartement() {
		return appartement;
	}
	public void setAppartement(String appartement) {
		this.appartement = appartement;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	

}
