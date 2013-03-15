package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.commun.MenuControleur;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
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
    
    //pour recuprér les données du cache
    @ManagedProperty(value = "#{menuCtrl}")
    private MenuControleur appCtrl;
    
    //pour recuprér 
    @ManagedProperty(value = "#{cacheSessionPresentationCtrl}")
    private CacheSessionPresentation cacheSessionPresentation;
    

    public void onSelectionerOfEditer(Spectacle ss) {
        this.getCacheSessionPresentation().setSpectacleSelected(ss); //Mettre dans le CacheSessionPresentation
        log.info("Le spectacle "+ss.getNomSpectacle()+" a été sélectionner");
    }

    
    /**
     * Creates a new instance of SpectacleControleur
     */
    public SpectacleControleur() {
    }
    
    public MenuControleur getAppCtrl() {
        return appCtrl;
    }

    public void setAppCtrl(MenuControleur appCtrl) {
        this.appCtrl = appCtrl;
    }

    public CacheSessionPresentation getCacheSessionPresentation() {
        return cacheSessionPresentation;
    }

    public void setCacheSessionPresentation(CacheSessionPresentation cacheSessionPresentation) {
        this.cacheSessionPresentation = cacheSessionPresentation;
    }
    
}
