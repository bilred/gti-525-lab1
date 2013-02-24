package ca.etsmtl.gti525.show;

import ca.etsmtl.gti525.factory.presentation.DomainePresentation;
import ca.etsmtl.gti525.gclient.Reservation;

/**
 * Un Billet représant un accés a une salle. (avec une date Début et Fin == Date a la quel la représentation passe) OK. 
 * @author REDOUANE
 *
 */
public class Billet extends DomainePresentation {
	
	private Boolean isVendu;  //enVente; ou vendu.
	private Boolean isLivraison; //avec ou sans livraison.
	
	private Salle salle; //pour avoir des information comme Numéro de Siege.
	private Representation representation; //en les recupére d'ici : private Date dateDebut; private Date dateFin;
	private Reservation reservation;  //-les 10 ou 20 1er minut de la connexion Client -s'il est vendu il est reservé a vie
		
	
	@Override
	public void afficherPresontationCree() {
		// TODO Auto-generated method stub
		
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
