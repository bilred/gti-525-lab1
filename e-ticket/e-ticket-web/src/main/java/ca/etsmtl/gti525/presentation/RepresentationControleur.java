package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.commun.MenuControleur;
import java.io.Serializable;
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

    //pour recuprér les données du cache
    @ManagedProperty(value = "#{menuCtrl}")
    private MenuControleur appCtrl;    
    
    
    /**
     * Creates a new instance of RepresentationControleur
     */
    public RepresentationControleur() {
    }

    public MenuControleur getAppCtrl() {
        return appCtrl;
    }
    
    
}
