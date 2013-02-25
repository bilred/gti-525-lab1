package ca.etsmtl.gti525.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author REDOUANE
 */
@Stateless
public class ArtisteFacade extends AbstractFacade<Artiste> implements ArtisteFacadeLocal {
    @PersistenceContext(unitName = "eticket_JTA")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtisteFacade() {
        super(Artiste.class);
    }
    
}
