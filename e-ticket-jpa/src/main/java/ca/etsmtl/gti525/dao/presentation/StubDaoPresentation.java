package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.commun.StubDataBase;
import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author REDOUANE
 */
public class StubDaoPresentation implements IDaoPresentation, Serializable {

    private StubDataBase stubDataBase = StubDataBase.getInstance();
    private StubPresentation sp = new StubPresentation(); //a la dure
    

    @Override
    public List<Artiste> getAllArtistes() {
        return sp.getArtistes();
    }

    @Override
    public List<Spectacle> getAllSpectacle() {
        return sp.getSpectacles();
    }

    @Override
    public List<Representation> getAllRepresentation() {
        return sp.getRepresentations();
    }

    @Override
    public void createBillet(Billet billet) {
        stubDataBase.billets.add(billet);
    }
    
    @Override
    public Representation findRepresentation(Long id) {
        int index = id.intValue() - 1;
        return stubDataBase.representations.get(index);
    }

    @Override
    public Salle findSalle(Long id) {
        int index = id.intValue() - 1;
        return stubDataBase.salles.get(index);
    }

    @Override
    public Reservation findReservation(Long id) {
        int index = id.intValue() - 1;
        return stubDataBase.reservations.get(index);
    }

    @Override
    public void createRepresentation(Representation representation) {
        stubDataBase.representations.add(representation);
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

}
