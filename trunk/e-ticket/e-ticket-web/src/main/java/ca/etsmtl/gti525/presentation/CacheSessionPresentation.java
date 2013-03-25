package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Utilisé : 1- pour passer le Spectacle selectionner à la page représantation
 * 2- pour passer les représantation selectionner au Panier. A la fait de chaque
 * etape faire set(null)
 *
 * @author REDOUANE
 */
@ManagedBean(name = "cacheSessionPresentationCtrl")
@SessionScoped
public class CacheSessionPresentation implements Serializable {
    private static final Logger LOG = Logger.getLogger(CacheSessionPresentation.class.getName());

    private Spectacle spectacleSelected;
    private List<Representation> representationSelected;
    private List<Integer> optionsQte2 = new ArrayList<Integer>();
    
    private Boolean disablePanier = Boolean.FALSE;
    private Boolean disablePaiement = Boolean.FALSE;

    public List<Integer> getOptionsQte2() {
        return optionsQte2;
    }

    public void setOptionsQte2(List<Integer> optionsQte2) {
        this.optionsQte2 = optionsQte2;
    }
    

    //@PreDestroy
    public void destroy(){
      this.setRepresentationSelected( new ArrayList<Representation>() );
      this.setSpectacleSelected( new Spectacle() );
      LOG.info("Nettoyage du cacheSessionPresentation"); // Après avoir récupéré les représentations sélectionner
    }
    /**
     * Creates a new instance of CacheSessionPresentation
     */
    public CacheSessionPresentation() {
        optionsQte2.add(1);
        optionsQte2.add(2);
        optionsQte2.add(3);
        optionsQte2.add(4);
        optionsQte2.add(5);
        optionsQte2.add(6);
    }

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

    public Boolean getDisablePanier() {
        return disablePanier;
    }

    public void setDisablePanier(Boolean disablePanier) {
        this.disablePanier = disablePanier;
    }
    
    public Boolean getDisablePaiement() {
        return disablePaiement;
    }

    public void setDisablePaiement(Boolean disablePaiement) {
        this.disablePaiement = disablePaiement;
    }
    
}
