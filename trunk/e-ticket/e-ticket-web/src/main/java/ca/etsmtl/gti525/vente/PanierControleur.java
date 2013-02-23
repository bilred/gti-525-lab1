package ca.etsmtl.gti525.vente;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author B.REDOUANE
 */
@ManagedBean(name = "panierCtrl")
@SessionScoped
public class PanierControleur implements Serializable {

    private int count; 
    

    public void increment() {  
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
