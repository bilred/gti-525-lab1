package ca.etsmtl.gti525.entity.presentation;

import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Un Billet représant un accés a une salle. (avec une date Debut et Fin == Date
 * a la quel la représentation passe) OK.
 * 
 * Contenu de cette entity : les billets disponnibles.
 *
 * @author REDOUANE
 *
 */
@Entity
@Table(name = "SHOW_BILLET")
public class Billet implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idBillet;
    @Column(name="ADRESSE")
    private String adresse;
    @Column(name="DATE_REPRESENTATION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRepresentation;
    @Column(name="SPECTACLE")
    private String nomSpec;
    
//    @Column(name = "IS_VENDU")
//    private Boolean isVendu;  //enVente; ou vendu.
//    @Column(name = "IS_LIVRAISON")
//    private Boolean isLivraison; //avec ou sans livraison.
    
    @OneToOne
    private Salle salle; //pour avoir des information comme Num�ro de Siege.   
    @OneToOne
    private Representation representation; //en les recup�re d'ici : private Date dateDebut; private Date dateFin;
   // @OneToOne
   // private Reservation reservation;  //-les 10 ou 20 1er minut de la connexion Client -s'il est vendu il est reserv� a vie
                                      //Reservation == c'est la seul interface avec le module Vente de l'Application	

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateRepresentation() {
        return dateRepresentation;
    }

    public void setDateRepresentation(Date dateRepresentation) {
        this.dateRepresentation = dateRepresentation;
    }

    public String getNomSpec() {
        return nomSpec;
    }

    public void setNomSpec(String nomSpec) {
        this.nomSpec = nomSpec;
    }

    
    public Long getIdBillet() {
        return idBillet;
    }

    public void setIdBillet(Long idBillet) {
        this.idBillet = idBillet;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

   /* public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }*/

//    public Boolean getIsVendu() {
//        return isVendu;
//    }
//
//    public void setIsVendu(Boolean isVendu) {
//        this.isVendu = isVendu;
//    }
//
//    public Boolean getIsLivraison() {
//        return isLivraison;
//    }
//
//    public void setIsLivraison(Boolean isLivraison) {
//        this.isLivraison = isLivraison;
//    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
