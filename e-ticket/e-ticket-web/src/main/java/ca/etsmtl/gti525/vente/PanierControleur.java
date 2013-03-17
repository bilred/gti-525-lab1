package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.commun.CommunService;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.presentation.CacheSessionPresentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
public class PanierControleur extends AbstractControleur implements Serializable {

    private static final Logger log = Logger.getLogger(PanierControleur.class);
    //pour recuprér les represantation selectionner (et remplire le paniers)
    @ManagedProperty(value = "#{cacheSessionPresentationCtrl}")
    private CacheSessionPresentation cacheSessionPresentation;
    
    private List<PanierBeans> paniers; //passer au proccese de paiment
    
    
    private int count;
    public void increment() {
        try { //si temps doit faire une exception personalisé pour ce cas.
            PanierBeans panier = null;
            Spectacle specSelec= this.getCacheSessionPresentation().getSpectacleSelected();
            List<Representation> repSelect = this.getCacheSessionPresentation().getRepresentationSelected();
            if (repSelect.size()==0) throw new Exception();
                  
            for (int i=0 ; i < repSelect.size() ; i++) {
                panier = new PanierBeans();
                panier.setNomSpectacle(specSelec.getNomSpectacle());
                panier.setPrix(repSelect.get(i).getPrix());
                panier.setQuantity(repSelect.get(i).getQTE());
                panier.setVille(repSelect.get(i).getSalle().getAdresse());
                //+ nombre de biller dispo
                
                this.getPaniers().add(panier);
            }
                
                count = qteBilletsPanier (); //selon le nombre de biller (Attantion ! une N place pour une même représantation et compté 1)
                this.cacheSessionPresentation.setDisablePanier(Boolean.TRUE); //Désactiver le panier (le réactivé si d'autre selection)
                this.cacheSessionPresentation.setDisablePaiement(Boolean.FALSE); //Activer le le paiement
                log.info("Panier increment(), valeur initial: " + count);
            
        } catch (Exception ex) {
            log.warn("Vous devez avoir séléctionné des représentations pour faire des ajouté dans le panier.");
            CommunService.addWarn("ATTENTION !", "Vous devais avoir sélectionnais des représentations");
        }
    }

    //private Representation representationDetail;
    public void onDetailsEnregistrement(Representation item) {   }  
    //méthode supprimant une rep/billets
    public void supprimerRep (Representation item){
       //Representation rechRep = InitDao.stubsDaoPresentation.findRepresentationByID(item.getId());
       
      //int index = item.getId().intValue()-1;
     // System.out.print(index);
    //this.cacheSessionPresentation.getRepresentationSelected().remove(index);
        this.cacheSessionPresentation.getRepresentationSelected().remove(item);
    }
    
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
    public int qteBilletsPanier (){
        int somme=0;
        for (int i =0; i<this.paniers.size();i++) {
            
            somme = somme + this.paniers.get(i).getQuantity();
            
        }
        return somme;
    }
}
