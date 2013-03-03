package ca.etsmtl.gti525.entity.vente;

import java.util.Date;


public class Reservation  {
	
	private Boolean isReservation;
	private Date dateReservation;
	private Boolean isConfirmationAchat;	
	

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
