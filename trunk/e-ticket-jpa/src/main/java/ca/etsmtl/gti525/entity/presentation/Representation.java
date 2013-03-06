package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Remarque : peu importe la date et l'heur une représantation ce fait que dans une seul salle a la fois. (pour un même spectacle)
 * @author REDOUANE
 *
 */
@Entity
@Table(name = "SHOW_REPRESENTATION")
public class Representation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NB_BILLETS_DISPO")
    private Integer nbBilletsDispo;
    @Column(name = "PRIX")
    private Float prix;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "IS_ANNULATION")
    private Boolean isAnnulation;

    @OneToOne(mappedBy = "representation")
    private Salle salle;

    
    @ManyToOne
    private Spectacle spectacle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
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

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    
}
