package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.entity.presentation.Representation;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "representationCtrl")
@ViewScoped
public class RepresentationControleur implements Serializable {
     private static final Logger log = Logger.getLogger(RepresentationControleur.class);
    
    //pour recuprér le spectacle selectionner
    @ManagedProperty(value = "#{cacheSessionPresentationCtrl}")
    private CacheSessionPresentation cacheSessionPresentation;
    
    
    @PreDestroy
    public void destroy(){
//        this.getCacheSessionPresentation().setSpectacleSelected(null); //au garbege collectore de faire la suite
//        log.info("cacheSessionPresentation.Spectacle, a été remis a Zéro, info nb represantation selected: "+this.getCacheSessionPresentation().getRepresentationSelected().size()); // Après avoir récupéré les représentations sélectionner
    }
    
    private Representation selectedRep;



    public Representation getSelectedRep() {
        return selectedRep;
    }

    public void setSelectedRep(Representation selectedRep) {
        this.selectedRep = selectedRep;
    }

    
    private List<Representation> representationsFiltrees;

    
    
    
    
    public List<Representation> getRepresentationsFiltrees() {
        return representationsFiltrees;
    }

    public void setRepresentationsFiltrees(List<Representation> representationsFiltrees) {
        this.representationsFiltrees = representationsFiltrees;
    }
    
    
    /**
     * Creates a new instance of RepresentationControleur
     */
    public RepresentationControleur() { }

    public CacheSessionPresentation getCacheSessionPresentation() {
        return cacheSessionPresentation;
    }

    public void setCacheSessionPresentation(CacheSessionPresentation cacheSessionPresentation) {
        this.cacheSessionPresentation = cacheSessionPresentation;
    }
    
}
