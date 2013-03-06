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
 *
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur extends AbstractControleur implements Serializable {
    private static final Logger log = Logger.getLogger(ApplicationControleur.class);
    
    // cache
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private List<Artiste> artistes;
    private List<Representation> representationsFiltrees;

    

    @PostConstruct
    public void init() {
        // instanciation couche [métier]
        super.initPresentation();

        this.spectacles = this.daoPresentation.getAllSpectacle();
        this.representations = this.daoPresentation.getAllRepresentation();
        this.artistes = this.daoPresentation.getAllArtistes(); 
        
        log.info("sonar source Spectacle : " + this.spectacles);
        log.info("sonar source Representation : " + this.representations);
        log.info("sonar source Artiste : " + this.artistes);
    }    
    
    public List<Representation> getRepresentationsFiltrees() {
        return representationsFiltrees;
    }

    public void setRepresentationsFiltrees(List<Representation> representationsFiltrees) {
        this.representationsFiltrees = representationsFiltrees;
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
    
}
