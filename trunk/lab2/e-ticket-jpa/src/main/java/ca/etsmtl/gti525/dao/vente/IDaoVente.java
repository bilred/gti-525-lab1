package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.gti525.entity.vente.Reservation;


public interface IDaoVente {

  public void createClient(Client client);
  public Adresse findAdresse(Long id);
  public void createAdresse(Adresse adresse);
  public void createCarteCredit(CarteCredit carteCredit);
  public void createReservation(Reservation reservation);
  
}
