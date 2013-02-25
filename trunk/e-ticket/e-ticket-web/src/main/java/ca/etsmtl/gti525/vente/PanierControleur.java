package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.entity.ArtisteFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author B.REDOUANE
 */
@ManagedBean(name = "panierCtrl")
@SessionScoped
public class PanierControleur implements Serializable {
    
    @EJB private ArtisteFacadeLocal ArtisteFacade;
    private int count; 
    

    public void increment() {
        if(ArtisteFacade==null) System.out.println("Conteneur d'EJB tés là == null Ooops!!!");
        else System.out.println("Conteneur d'EJB tés là != null Magnico o_O");
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
