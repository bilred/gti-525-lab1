package ca.etsmtl.gti525.commun;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur {


    public String doHomme(){
        return "index";
    }
    
    public String doCart(){
        return "cart";
    }

    public String doShow(){
        return "show";
    }
    
    /**
     * Creates a new instance of MenuControleur
     */
    public MenuControleur() {
    }
    
}
