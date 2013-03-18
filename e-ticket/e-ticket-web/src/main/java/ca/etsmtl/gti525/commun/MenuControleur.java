package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 * Représant le controleur de notre Application (il a 2 rôle Initialisé les Caches + Géstion des menu)
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur extends AbstractControleur implements Serializable {
    private static final Logger log = Logger.getLogger(MenuControleur.class);
    
    // cache
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private List<Artiste> artistes;
    
    
    @PostConstruct
    public void init() {
        // instanciation couche [métier]
        super.initStubsPresentation();

        this.spectacles = InitDao.stubsDaoPresentation.getAllSpectacle();
        this.representations = InitDao.stubsDaoPresentation.getAllRepresentation();
        this.artistes = InitDao.stubsDaoPresentation.getAllArtistes(); 
        
        log.info("sonar source Spectacle 1: " + this.spectacles);
        log.info("sonar source Representation 1: " + this.representations);
        log.info("sonar source Artiste 1: " + this.artistes);
    }    
   
    
    public String doHomme(){
        return "eticket.index";
    }
    
    public String doCart(){
        return "eticket.pageCart";
    }

    public String doShow(){
        return "eticket.pageShows";
    }
    
    
    
    
    /**
     * Creates a new instance of MenuControleur
     */
    public MenuControleur() {  }

    public List<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
    }
    public void changerQte(Representation repCached ){
     for (int i=0;i<this.representations.size();i++){
         if (this.representations.get(i).getId()==repCached.getId()){
             this.representations.get(i).setQTE(repCached.getQTE());
         }
     }   
    }
    
}
