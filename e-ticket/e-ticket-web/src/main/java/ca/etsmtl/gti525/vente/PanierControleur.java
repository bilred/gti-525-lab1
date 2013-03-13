package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.commun.taglib.TableCrud;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.presentation.RepresentationControleur;
import ca.etsmtl.gti525.vente.crud.TableCrudPanier;
import java.io.Serializable;
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

    //pour recuprér les represantation selectionner (et remplire le panier)
    @ManagedProperty(value = "#{representationCtrl}")
    private RepresentationControleur representationCtrl;    
       
    private TableCrud tableCrudPanier;
    
    
    
    
    
    private int count;
    public void increment() {
        log.info("Appel de la méthode increment(), valeur initial: "+count);
        count++;  
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
        this.tableCrudPanier = new TableCrudPanier(this); //this.tableCrudPanier.doGetAllEnregistrement();
        }
        return tableCrudPanier;
    }

    public RepresentationControleur getRepresentationCtrl() {
        return representationCtrl;
    }

    public void setRepresentationCtrl(RepresentationControleur representationCtrl) {
        this.representationCtrl = representationCtrl;
    }
        
}
