package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.commun.taglib.TableCrud;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.presentation.CacheSessionPresentation;
import ca.etsmtl.gti525.vente.crud.PanierBeans;
import ca.etsmtl.gti525.vente.crud.TableCrudPanier;
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
       
    private TableCrud tableCrudPanier;
    private List<PanierBeans> paniers; //passer au proccese de paiment
    
    //private Representation representationDetail;
    public void onDetailsEnregistrement(Representation item){
        
    }
    
    private int count;
    public void increment() {
        PanierBeans panier = null;
        List<Representation> repSelect = getCacheSessionPresentation().getRepresentationSelected();
        
        for(Representation rep: repSelect) {  
         panier = new PanierBeans();   
         panier.setNomSpectacle( rep.getNom() );
         panier.setPrix( rep.getPrix() );
         panier.setQuantity( repSelect.size() );
         panier.setVille( rep.getAdresse() );
         
         this.getPanier().add(panier);
        }
        
        log.info("Appel de la méthode increment(), valeur initial: "+count);
        count++; //selon le nombre de biller  
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

    public TableCrud getTableCrudPanier() {
        if(tableCrudPanier==null) {
        this.tableCrudPanier = new TableCrudPanier(this); this.tableCrudPanier.doGetAllEnregistrement();
        }
        return tableCrudPanier;
    }

    public void setTableCrudPanier(TableCrud tableCrudPanier) {
        if(tableCrudPanier==null) this.tableCrudPanier = new TableCrudPanier(this);
        this.tableCrudPanier = tableCrudPanier;
    }

    
    
    public CacheSessionPresentation getCacheSessionPresentation() {
        return cacheSessionPresentation;
    }

    public void setCacheSessionPresentation(CacheSessionPresentation cacheSessionPresentation) {
        this.cacheSessionPresentation = cacheSessionPresentation;
    }

    public List<PanierBeans> getPanier() {
        if(paniers==null) paniers = new ArrayList<PanierBeans>();
        return paniers;
    }

    public void setPanier(List<PanierBeans> panier) {
        if(paniers==null) paniers = new ArrayList<PanierBeans>();
        this.paniers = panier;
    }
    
    
        
}
