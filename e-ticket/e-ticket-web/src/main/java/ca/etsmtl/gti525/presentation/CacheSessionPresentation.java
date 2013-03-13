package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Utilisé : 
 * 1- pour passer le Spectacle selectionner à la page représantation 
 * 2- pour passer les représantation selectionner au Panier.
 * A la fait de chaque etape faire set(null)
 * @author REDOUANE
 */
@ManagedBean(name = "cacheSessionPresentationCtrl")
@SessionScoped
public class CacheSessionPresentation implements Serializable {

    private Spectacle spectacleSelected;
    private List<Representation> representationSelected;

    /**
     * Creates a new instance of CacheSessionPresentation
     */
    public CacheSessionPresentation() { }
    
    public Spectacle getSpectacleSelected() {
        return spectacleSelected;
    }

    public void setSpectacleSelected(Spectacle spectacleSelected) {
        this.spectacleSelected = spectacleSelected;
    }

    public List<Representation> getRepresentationSelected() {
        return representationSelected;
    }

    public void setRepresentationSelected(List<Representation> representationSelected) {
        this.representationSelected = representationSelected;
    }
  
    
}
