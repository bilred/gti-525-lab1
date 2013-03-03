package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.commun.ApplicationControleur;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "spectacleCtrl")
@ViewScoped
public class SpectacleControleur implements Serializable {
    private static final Logger log = Logger.getLogger(SpectacleControleur.class);
    
    @ManagedProperty(value = "#{appliCtrl}")
    private ApplicationControleur applicationControleur;
    
//    public List<Spectacle> getSpectacles(){
//        log.info("sonar source : "+applicationControleur.getSpectacles());
//        return (applicationControleur.getSpectacles());   
//    }
    
    /**
     * Creates a new instance of SpectacleControleur
     */
    public SpectacleControleur() {
    }

    public ApplicationControleur getApplicationControleur() {
        return applicationControleur;
    }

    public void setApplicationControleur(ApplicationControleur applicationControleur) {
        this.applicationControleur = applicationControleur;
    }
       
}
