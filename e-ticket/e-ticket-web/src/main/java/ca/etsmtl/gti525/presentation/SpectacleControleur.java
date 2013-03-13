package ca.etsmtl.gti525.presentation;

import ca.etsmtl.gti525.commun.MenuControleur;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "spectacleCtrl")
@SessionScoped
public class SpectacleControleur implements Serializable {

    private static final Logger log = Logger.getLogger(SpectacleControleur.class);
    //pour recuprér les données du cache
    @ManagedProperty(value = "#{menuCtrl}")
    private MenuControleur appCtrl;
    
    
    private Spectacle specSelec = new Spectacle();
    private List lignesSelec;

    

    public String allerPageRep(List<Representation> rep) {
        return "pageRepresentation?faces-redirect=true";
    }

    public void onSelectionerOfEditer(Spectacle ss) {
        this.setSpecSelec(ss);
    }

    public List getLignesSelec() {
        return lignesSelec;
    }

    public void setLignesSelec(List lignesSelec) {
        this.lignesSelec = lignesSelec;
    }

    /**
     * Creates a new instance of SpectacleControleur
     */
    public SpectacleControleur() {
    }

    public Spectacle getSpecSelec() {
        return specSelec;
    }

    public void setSpecSelec(Spectacle specSelec) {
        this.specSelec = specSelec;
    }
    
    public MenuControleur getAppCtrl() {
        return appCtrl;
    }

    public void setAppCtrl(MenuControleur appCtrl) {
        this.appCtrl = appCtrl;
    }
    
}
