package ca.etsmtl.gti525.dao.presentation;


import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
//import ca.etsmtl.gti525.entity.vente.Reservation;
import java.util.List;


public interface IDaoPresentation {

  public List<Artiste> getAllArtistes();
  public List<Spectacle> getAllSpectacle();
  public List<Representation> getAllRepresentation();

  public Representation findRepresentation(Long id);
  public Salle findSalle(Long id);
//  public Reservation findReservation(Long id);
  public void createBillet(Billet billet);
  public void createRepresentation(Representation representation);
  public void createSalle(Salle salle);
  public void createSpectacle(Spectacle spectacle);
  public void createArtist(Artiste artist);
  
  
  public Representation findRepresentationByID(Long id);
  
}
