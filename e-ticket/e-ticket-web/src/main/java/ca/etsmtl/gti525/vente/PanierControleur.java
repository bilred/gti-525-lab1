package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.vente.crud.TableCrudPanier;
import ca.etsmtl.gti525.commun.taglib.TableCrud;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
    private int count;
    
    private TableCrud tableCrudPanier;
    

    public void increment() {
        log.info("Appel de la méthode increment(), valeur initial: "+count);
        count++;  
    }  
    
 
    
    
    

    // cache
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private List<Artiste> artistes;

    
    @PostConstruct
    public void init() {
        // instanciation couche [métier]
        super.initPresentation();

//        this.spectacles = dao.getAllSpectacle();
        this.representations = this.daoPresentation.getAllRepresentation();
//        this.artistes = dao.getAllArtistes(); 
        
//        log.info("sonar source Spectacle (panier) : " + this.spectacles);
        log.info("sonar source Representation (panier) : " + this.representations);
//        log.info("sonar source Artiste (panier) : " + this.artistes);
    }    

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public List<Representation> getRepresentations() {
        return representations;
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
        this.tableCrudPanier = new TableCrudPanier(this);
        this.tableCrudPanier.doGetAllEnregistrement();}
        return tableCrudPanier;
    }
    
}
