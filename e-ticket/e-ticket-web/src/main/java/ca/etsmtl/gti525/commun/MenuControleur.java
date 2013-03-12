package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.vente.crud.PanierBeans;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur extends AbstractControleur implements Serializable {
    private static final Logger log = Logger.getLogger(ApplicationControleur.class);
    
    private PanierBeans[] selectedRep;

    public PanierBeans[] getSelectedRep() {
        return selectedRep;
    }

    public void setSelectedRep(PanierBeans[] selectedRep) {
        this.selectedRep = selectedRep;
    }
    
    // cache
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private Spectacle specSelec = new Spectacle();

    
    private List<Artiste> artistes;
    private List<Representation> representationsFiltrees;
    private List lignesSelec;

    public List getLignesSelec() {
        return lignesSelec;
    }

    public void setLignesSelec(List lignesSelec) {
        this.lignesSelec = lignesSelec;
    }

    
    @PostConstruct
    public void init() {
        // instanciation couche [métier]
        super.initStubsPresentation();

        this.spectacles = this.stubsDaoPresentation.getAllSpectacle();
        this.representations = this.stubsDaoPresentation.getAllRepresentation();
        this.artistes = this.stubsDaoPresentation.getAllArtistes(); 
        
        log.info("sonar source Spectacle 1: " + this.spectacles);
        log.info("sonar source Representation 1: " + this.representations);
        log.info("sonar source Artiste 1: " + this.artistes);
    }    
    
    public List<Representation> getRepresentationsFiltrees() {
        return representationsFiltrees;
    }

    public void setRepresentationsFiltrees(List<Representation> representationsFiltrees) {
        this.representationsFiltrees = representationsFiltrees;
    }
    
  
    public String allerPageRep(List<Representation> rep){
        
                        
        return "pageRepresentation?faces-redirect=true";
    }
    
    
    public void onSelectionerOfEditer(Spectacle ss){
        this.setSpecSelec(ss);
        
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
    public Spectacle getSpecSelec() {
        return specSelec;
    }

    public void setSpecSelec(Spectacle specSelec) {
        this.specSelec = specSelec;
    }
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
