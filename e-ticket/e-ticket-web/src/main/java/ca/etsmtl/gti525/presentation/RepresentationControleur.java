package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.entity.presentation.Representation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "representationCtrl")
@ViewScoped
public class RepresentationControleur implements Serializable {
    
    //pour recuprér le spectacle selectionner
    @ManagedProperty(value = "#{spectacleCtrl}")
    private SpectacleControleur spectacleCtrl;     
  
    private Representation[] selectedRep;
    private List<Representation> representationsFiltrees;

    
    
    
    
    public List<Representation> getRepresentationsFiltrees() {
        return representationsFiltrees;
    }

    public void setRepresentationsFiltrees(List<Representation> representationsFiltrees) {
        this.representationsFiltrees = representationsFiltrees;
    }

    public Representation[] getSelectedRep() {
        return selectedRep;
    }

    public void setSelectedRep(Representation[] selectedRep) {
        this.selectedRep = selectedRep;
    }
    
    
    /**
     * Creates a new instance of RepresentationControleur
     */
    public RepresentationControleur() { }
    

    public SpectacleControleur getSpectacleCtrl() {
        return spectacleCtrl;
    }

    public void setSpectacleCtrl(SpectacleControleur spectacleCtrl) {
        this.spectacleCtrl = spectacleCtrl;
    }
    
    
}
