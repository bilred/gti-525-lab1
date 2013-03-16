package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
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
      //this.getCacheSessionPresentation().setSpectacleSelected( new Spectacle()); //au garbege collectore de faire la suite
      log.info("Nettoyage du cacheSessionPresentation"); // Après avoir récupéré les représentations sélectionner
    }    
    
    public void doVelidete() {
        this.cacheSessionPresentation.setDisablePanier(Boolean.FALSE);
    }
    
    
    private List<Representation> representationsFiltrees;

    
    
    
    
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
    
    public List<Representation> getRepresentationsFiltrees() {
        return representationsFiltrees;
    }

    public void setRepresentationsFiltrees(List<Representation> representationsFiltrees) {
        this.representationsFiltrees = representationsFiltrees;
    }    
    
}
