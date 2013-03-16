package ca.etsmtl.gti525.dao.presentation;


import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.util.List;


public interface IDaoPresentation {

  // liste des clients
  public List<Artiste> getAllArtistes();
  // liste des Médecins
  public List<Spectacle> getAllSpectacle();
  public List<Representation> getAllRepresentation();
  //mohamed
  public Representation findRepresentation(int id);
  public Salle findSalle(int id);
  public Reservation findReservation(int id);
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
