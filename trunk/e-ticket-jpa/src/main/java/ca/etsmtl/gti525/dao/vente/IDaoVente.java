package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.Client;


public interface IDaoVente {

  // Cree Client 
  public void createClient(Client client);
  public Adresse findAdresse(Long id);
  // Cree des Adresse
  public void createAdresse(Adresse adresse);
//  // liste des Médecins
//  public List<Spectacle> getAllSpectacle();
//  public List<Representation> getAllRepresentation();
//  // liste des créneaux horaires d'un médecin
//  public List<Creneau> getAllCreneaux(Medecin medecin);
//  // liste des Rv d'un médecin, un jour donné
//  public List<Rv> getRvMedecinJour(Medecin medecin, Date jour);
//  // trouver un client identifié par son id
//  public Client getClientById(Long id);
//  // trouver un client idenbtifié par son id
//  public Medecin getMedecinById(Long id);
//  // trouver un Rv identifié par son id
//  public Rv getRvById(Long id);
//  // trouver un créneau horaire identifié par son id
//  public Creneau getCreneauById(Long id);
//  // ajouter un RV
//  public Rv ajouterRv(Date jour, Creneau creneau, Client client);
//  // supprimer un RV
//  public void supprimerRv(Rv rv);
}
