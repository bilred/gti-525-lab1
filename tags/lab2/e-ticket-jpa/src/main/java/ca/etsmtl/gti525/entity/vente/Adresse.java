package ca.etsmtl.gti525.entity.vente;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VENTE_ADRESSE")
public class Adresse implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "RUE")
    private String rue = new String();
    @Column(name = "APPARTEMENT")
    private String appartement = new String();;
    @Column(name = "VILLE")
    private String ville = new String();;
    @Column(name = "REGION")
    private String region = new String();;
    @Column(name = "CODE_POSTAL")
    private String codePostal = new String();;

    
    public Long getId() {
        if(id==null) id= new Long(0);
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
