package ca.etsmtl.gti525.beans.presentation;

import ca.etsmtl.gti525.beans.vente.Reservation;

/**
 * Un Billet repr�sant un acc�s a une salle. (avec une date D�but et Fin == Date a la quel la repr�sentation passe) OK. 
 * @author REDOUANE
 *
 */
public class Billet {
	
	private Boolean isVendu;  //enVente; ou vendu.
	private Boolean isLivraison; //avec ou sans livraison.
	
	private Salle salle; //pour avoir des information comme Num�ro de Siege.
	private Representation representation; //en les recup�re d'ici : private Date dateDebut; private Date dateFin;
	private Reservation reservation;  //-les 10 ou 20 1er minut de la connexion Client -s'il est vendu il est reserv� a vie
	//Reservation == c'est la seul interface avec le module Vente de l'Application	
	
	
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
