package ca.etsmtl.gti525.entity.presentation;

import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Un Billet repr�sant un acc�s a une salle. (avec une date D�but et Fin == Date a la quel la repr�sentation passe) OK. 
 * @author REDOUANE
 *
 */

@Entity()
@Table(name="SHOW_BILLET")

public class Billet implements Serializable{
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Double idBillet;
        
        @Column(name = "IS_VENDU")
	private Boolean isVendu;  //enVente; ou vendu.

        @Column(name = "IS_LIVRAISON")
	private Boolean isLivraison; //avec ou sans livraison.
	
	private Salle salle; //pour avoir des information comme Num�ro de Siege.
	private Representation representation; //en les recup�re d'ici : private Date dateDebut; private Date dateFin;
	private Reservation reservation;  //-les 10 ou 20 1er minut de la connexion Client -s'il est vendu il est reserv� a vie
	//Reservation == c'est la seul interface avec le module Vente de l'Application	
	
	public Double getIdBillet() {
        return idBillet;
        }

        public void setIdBillet(Double idBillet) {
        this.idBillet = idBillet;
        }
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Boolean getIsVendu() {
		return isVendu;
	}
	public void setIsVendu(Boolean isVendu) {
		this.isVendu = isVendu;
	}
	public Boolean getIsLivraison() {
		return isLivraison;
	}
	public void setIsLivraison(Boolean isLivraison) {
		this.isLivraison = isLivraison;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
	
}
