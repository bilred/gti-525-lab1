package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.util.List;

/**
 *
 * @author REDOUANE
 */
public class StubDaoPresentation implements IDaoPresentation{
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
    
}
