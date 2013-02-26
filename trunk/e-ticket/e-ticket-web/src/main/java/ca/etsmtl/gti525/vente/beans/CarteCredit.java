package ca.etsmtl.gti525.vente.beans;

import java.util.Date;


public class CarteCredit {
	
	private String detenteurCarte;
	private String typeCarteCredit;
	private String numCarteCredit;
	private Date dateExpiration;
	private String numSecurite; //G�n�ralement les 5 d�rnier chifre de la carte.
	private Date dateTransaction;	
	
	
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getDetenteurCarte() {
		return detenteurCarte;
	}
	public void setDetenteurCarte(String detenteurCarte) {
		this.detenteurCarte = detenteurCarte;
	}
	public String getTypeCarteCredit() {
		return typeCarteCredit;
	}
	public void setTypeCarteCredit(String typeCarteCredit) {
		this.typeCarteCredit = typeCarteCredit;
	}
	public String getNumCarteCredit() {
		return numCarteCredit;
	}
	public void setNumCarteCredit(String numCarteCredit) {
		this.numCarteCredit = numCarteCredit;
	}
	public Date getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	public String getNumSecurite() {
		return numSecurite;
	}
	public void setNumSecurite(String numSecurite) {
		this.numSecurite = numSecurite;
	}

	

}
