package ca.etsmtl.gti525.gclient;

import java.util.Date;

import ca.etsmtl.gti525.factory.vente.DomaineVente;

public class Reservation extends DomaineVente {
	
	private Boolean isReservation;
	private Date dateReservation;
	private Boolean isConfirmationAchat;
	
	
	@Override
	public void afficherVenteCree() {
		// TODO Auto-generated method stub
		
	}	
	

	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Boolean getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(Boolean isReservation) {
		this.isReservation = isReservation;
	}
	public Boolean getIsConfirmationAchat() {
		return isConfirmationAchat;
	}
	public void setIsConfirmationAchat(Boolean isConfirmationAchat) {
		this.isConfirmationAchat = isConfirmationAchat;
	}
	
	

}
