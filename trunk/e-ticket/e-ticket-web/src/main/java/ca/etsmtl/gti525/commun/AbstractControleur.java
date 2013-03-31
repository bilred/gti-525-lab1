package ca.etsmtl.gti525.commun;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  On peut faire du Polymorphisme (injecter du code en plus de l'existant)
 * @author REDOUANE
 */
public abstract class AbstractControleur extends InitDao{
    
    //@Ingection couche model et métier
      //Fait dans InitDAO
    

    
    @Override
    public void initPresentation() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractControleur.class.getName()).log(Level.SEVERE, "!! SEVERE : dans le cas ou vous utilisé Derby", ex);
        }
        super.initPresentation();
        //this.daoPresentation;
    }

    @Override
    public void initVante() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractControleur.class.getName()).log(Level.SEVERE, "!! SEVERE : dans le cas ou vous utilisé Derby.", ex);
        }
        super.initVante();
    }

    @Override
    public void initStubsPresentation() {
        super.initStubsPresentation();
        //InitDao.stubsDaoPresentation
    }

    @Override
    public void initStubsVante() {
        super.initStubsVante();
    }  
    
    @Override
    public void initStubsPaiement() {
        super.initStubsPaiement();
    } 
    
    
    
    @Override
    public void initTimeur() {
         super.initTimeur();
    }    
    
}
