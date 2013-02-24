package ca.etsmtl.gti525.transaction;

import java.util.Date;

import ca.etsmtl.gti525.gclient.Client;

public class Vente {
	
	//@Id
	private Double id;  //Correspond au numéro de facture du client
	private Date dateVente;
	private Float prixTransaction; //prix par transaction (somme de billets)
	
	private Client client;  //tout information client pertinante (pas forcément tout)
//	private List<Billet> billets; 	
//	private List<Representation> representations; //les reprisantations choisies et infos spectacle (simple)
	
	
	public FactureBeans généréFacture(){
		return null;
	}
	
	
	
	public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public Date getDateVente() {
		return dateVente;
	}
	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}
	public Float getPrixTransaction() {
		return prixTransaction;
	}
	public void setPrixTransaction(Float prixTransaction) {
		this.prixTransaction = prixTransaction;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
//	public List<Billet> getBillets() {
//		return billets;
//	}
//	public void setBillets(List<Billet> billets) {
//		this.billets = billets;
//	}
//	public List<Representation> getRepresentations() {
//		return representations;
//	}
//	public void setRepresentations(List<Representation> representations) {
//		this.representations = representations;
//	}
	
}
