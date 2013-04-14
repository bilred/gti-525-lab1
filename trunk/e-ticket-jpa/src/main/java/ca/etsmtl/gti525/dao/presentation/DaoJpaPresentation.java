package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
//import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DaoJpaPresentation implements IDaoPresentation, Serializable {
    private static final long serialVersionUID = 1L;
    
    //l'ingection du "e-ticket-jpa-hibernate-PU"
    @PersistenceContext
    private EntityManager em;

    // liste des clients
    @Override
    public List<Artiste> getAllArtistes() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artiste.class));
            return em.createQuery(cq).getResultList();

        } catch (Exception ex) {
            //getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAll {0} : ", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Spectacle> getAllSpectacle() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Spectacle.class));
            return em.createQuery(cq).getResultList();

        } catch (Exception ex) {
            //getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAll {0} : ", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Representation> getAllRepresentation() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Representation.class));
            
            return em.createQuery(cq).getResultList();

        } catch (Exception ex) {
            //getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAll {0} : ", ex.getMessage());
            return null;
        }
    }

    @Override
    public void createBillet(Billet billet) {
        try {
            em.persist(billet);
        } catch (Exception ex) {
            Logger.getLogger(DaoJpaPresentation.class.toString()).log(Level.SEVERE, ex.toString());
        }
    }

    @Override
    public Representation findRepresentation(Long id) {
        try {
            Query query;
            query = (Query) em.createQuery("SELECT a FROM Representation a  where a.id=:id");
            query.setParameter("id", id);

            return ((Representation) query.getSingleResult());
        } catch (Exception ex) {
            Logger.getLogger(DaoJpaPresentation.class.toString()).log(Level.SEVERE, ex.toString());
            return null;
        }
    }

    @Override
    public Salle findSalle(Long id) {
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
    public Representation findRepresentationByID(Long id) {
        try {
            System.out.println(em+"|||||||||||||||||"+id+"\\\\\\\\\\\\");
            return em.find(Representation.class, id);
        } catch (Exception ex) {
            //getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.find {0} : ", ex.getMessage());
            System.out.print("Erreure ici au DAO");
            return null;
        }
    }
}
