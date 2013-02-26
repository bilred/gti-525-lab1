package ca.etsmtl.gti525.commun;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur implements Serializable {


    public String doHomme(){
        return "eticket.index";
    }
    
    public String doCart(){
        return "eticket.pageCart";
    }

    public String doShow(){
        return "eticket.pageShows";
    }
    
    /**
     * Creates a new instance of MenuControleur
     */
    public MenuControleur() {
    }
    
}
