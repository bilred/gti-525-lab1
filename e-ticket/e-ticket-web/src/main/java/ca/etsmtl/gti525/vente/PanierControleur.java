package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.presentation.CacheSessionPresentation;
import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.CommunService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author B.REDOUANE
 */
@ManagedBean(name = "panierCtrl")
@SessionScoped
public class PanierControleur implements Serializable {

    private static final Logger log = Logger.getLogger(PanierControleur.class);
    //pour recuprér les represantation selectionner (et remplire le paniers)
    @ManagedProperty(value = "#{cacheSessionPresentationCtrl}")
    private CacheSessionPresentation cacheSessionPresentation;
    
    private List<PanierBeans> paniers; //passer au proccese de paiment
    
    
    private int count;
    public void increment() {
        try { //si temps doit faire une exception personalisé pour ce cas.
            PanierBeans panier = null;
            List<Representation> repSelect = this.getCacheSessionPresentation().getRepresentationSelected();

            for (Representation rep : repSelect) {
                panier = new PanierBeans();
                panier.setNomSpectacle(rep.getNom());
                panier.setPrix(rep.getPrix());
                panier.setQuantity(repSelect.size());
                panier.setVille(rep.getAdresse());

                this.getPaniers().add(panier);
            }

                count = count + repSelect.size(); //selon le nombre de biller (Attantion ! une N place pour une même représantation et compté 1)
                this.cacheSessionPresentation.setDisablePanier(Boolean.TRUE);
                log.info("Panier increment(), valeur initial: " + count);
            
        } catch (Exception ex) {
            log.warn("Vous devais avoir sélectionnais des représentations pour faire des ajout dans le panier.");
            CommunService.addWarn("ATTENTION !", "Vous devais avoir sélectionnais des représentations");
        }
    }

    //private Representation representationDetail;
    public void onDetailsEnregistrement(Representation item) {   }    
    
    /**
     * Creates a new instance of PanierControleur
     */
    public PanierControleur() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CacheSessionPresentation getCacheSessionPresentation() {
        return cacheSessionPresentation;
    }

    public void setCacheSessionPresentation(CacheSessionPresentation cacheSessionPresentation) {
        this.cacheSessionPresentation = cacheSessionPresentation;
    }

    public List<PanierBeans> getPaniers() {
        if (paniers == null) {
            paniers = new ArrayList<PanierBeans>();
        }
        return paniers;
    }

    public void setPaniers(List<PanierBeans> paniers) {
        if (paniers == null) {
            paniers = new ArrayList<PanierBeans>();
        }
        this.paniers = paniers;
    }
}
