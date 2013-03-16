package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHOW_SALLE")
public class Salle implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long code;
    @Column(name = "NAME")
    private String nom;
    @Column(name = "NB_Place")
    private Integer nbPlace;
    @Column(name = "ADRESSE_SALLE")
    private String adresseSalle; //pas besoin d'etre d�composer.
       

    
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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

    public String getAdresseSalle() {
        return adresseSalle;
    }

    public void setAdresseSalle(String adresseSalle) {
        this.adresseSalle = adresseSalle;
    }
}
