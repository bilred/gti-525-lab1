package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class DaoJpaPresentation implements IDaoPresentation, Serializable {

  private static final long serialVersionUID = 1L;
  @PersistenceContext
  private EntityManager em;

  // liste des clients
    @Override
  public List<Artiste> getAllArtistes() {
    try {
      return em.createQuery("select rc from Artiste rc").getResultList();
    } catch (Throwable th) {
      //throw new RdvMedecinsException(th, 1);
        return null;
    }
  }

 
    @Override
  public List<Spectacle> getAllSpectacle() {
    try {
      return em.createQuery("select rm from Spectacle rm").getResultList();
    } catch (Throwable th) {
      //throw new RdvMedecinsException(th, 2);
        return null;
    }
  }
  
 
    @Override
  public List<Representation> getAllRepresentation() {
    try {
      return em.createQuery("select rm from Representation rm").getResultList();
    } catch (Throwable th) {
      //throw new RdvMedecinsException(th, 2);
        return null;
    }
  }

    @Override
    public void createBillet(Billet billet) {
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Representation findRepresentation(Long id) {
        return null;
    }

    @Override
    public Salle findSalle(Long id) {
        return null;
    }

    @Override
    public Reservation findReservation(Long id) {
        return null;
    }

    @Override
    public void createRepresentation(Representation representation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createSalle(Salle salle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createSpectacle(Spectacle spectacle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createArtist(Artiste artist) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Representation findRepresentationByID(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}