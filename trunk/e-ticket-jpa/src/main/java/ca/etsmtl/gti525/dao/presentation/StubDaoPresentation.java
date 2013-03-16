package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author REDOUANE
 */
public class StubDaoPresentation implements IDaoPresentation{
    
        public List<Representation> representation = new ArrayList<Representation>();
        public List<Salle> salle = new ArrayList<Salle>();
        public List<Reservation> reservation = new ArrayList<Reservation>();
        
private StubPresentation sp = new StubPresentation();
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
    public Representation findRepresentation(int id) {
        System.out.println("id= " +id);
         int index = id - 1;
         System.out.println(representation.get(index));
        return representation.get(index);
    }

    @Override
    public Salle findSalle(int id) {
         int index = id - 1;
        return salle.get(index);
    }

    @Override
    public Reservation findReservation(int id) {
        int index = id - 1;
        return reservation.get(index);
    }

    
}
