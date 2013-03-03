package ca.etsmtl.gti525.vente;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
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
    
}
