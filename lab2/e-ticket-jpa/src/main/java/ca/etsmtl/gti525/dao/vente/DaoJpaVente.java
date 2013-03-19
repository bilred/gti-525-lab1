package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class DaoJpaVente implements IDaoVente, Serializable {

  private static final long serialVersionUID = 1L;
  @PersistenceContext
  private EntityManager em;
  
  
    @Override
    public void createClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Adresse findAdresse(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createAdresse(Adresse adresse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createCarteCredit(CarteCredit carteCredit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createReservation(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }  

//  // liste des clients
//  @Override
//  public List<Artiste> getAllArtistes() {
//    try {
//      return em.createQuery("select rc from Artiste rc").getResultList();
//    } catch (Throwable th) {
//      //throw new RdvMedecinsException(th, 1);
//        return null;
//    }
//  }
//
// 
//  public List<Spectacle> getAllSpectacle() {
//    try {
//      return em.createQuery("select rm from Spectacle rm").getResultList();
//    } catch (Throwable th) {
//      //throw new RdvMedecinsException(th, 2);
//        return null;
//    }
//  }
//  
// 
//  public List<Representation> getAllRepresentation() {
//    try {
//      return em.createQuery("select rm from Representation rm").getResultList();
//    } catch (Throwable th) {
//      //throw new RdvMedecinsException(th, 2);
//        return null;
//    }
//  }
  

  // liste des créneaux horaires d'un médecin donné
  // medecin : le médecin
//  public List<Creneau> getAllCreneaux(Medecin medecin) {
//    try {
//      return em.createQuery("select rc from Creneau rc join rc.medecin m where m.id=:idMedecin").setParameter("idMedecin", medecin.getId()).getResultList();
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 3);
//    }
//  }

//  // liste des Rv d'un médecin donné, un jour donné
//  // medecin : le médecin
//  // jour : le jour
//  public List<Rv> getRvMedecinJour(Medecin medecin, Date jour) {
//    try {
//      return em.createQuery("select rv from Rv rv join rv.creneau c join c.medecin m where m.id=:idMedecin and rv.jour=:jour").setParameter("idMedecin", medecin.getId()).setParameter("jour", jour).getResultList();
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 3);
//    }
//  }
//
//  // ajout d'un Rv
//  // jour : jour du Rv
//  // creneau : créneau horaire du Rv
//  // client : client pour lequel est pris le Rv
//  public Rv ajouterRv(Date jour, Creneau creneau, Client client) {
//    try {
//      Rv rv = new Rv(null, jour);
//      rv.setClient(client);
//      rv.setCreneau(creneau);
//      System.out.println(String.format("avant persist : %s",rv));
//      em.persist(rv);
//      System.out.println(String.format("après persist : %s",rv));
//      return rv;
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 4);
//    }
//  }
//
//  // suppression d'un Rv
//  // rv : le Rv supprimé
//  public void supprimerRv(Rv rv) {
//    try {
//      em.remove(em.merge(rv));
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 5);
//    }
//  }
//
//  // récupérer un client donné
//  public Client getClientById(Long id) {
//    try {
//      return (Client) em.find(Client.class, id);
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 6);
//    }
//  }
//
//  // récupérer un médecin donné
//  public Medecin getMedecinById(Long id) {
//    try {
//      return (Medecin) em.find(Medecin.class, id);
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 6);
//    }
//  }
//
//  // récupérer un Rv donné
//  public Rv getRvById(Long id) {
//    try {
//      return (Rv) em.find(Rv.class, id);
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 6);
//    }
//  }
//
//  // récupérer un créneau donné
//  public Creneau getCreneauById(Long id) {
//    try {
//      return (Creneau) em.find(Creneau.class, id);
//    } catch (Throwable th) {
//      throw new RdvMedecinsException(th, 6);
//    }
//  }

}
