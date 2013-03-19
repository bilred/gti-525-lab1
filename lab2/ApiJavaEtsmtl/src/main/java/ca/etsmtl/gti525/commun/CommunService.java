package ca.etsmtl.gti525.commun;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * @author B.REDOUANE
 */
public class CommunService {
    

    static public String getLoginCurrentUser() { //getCurrentUserId
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext().getRemoteUser();
    }
    
    

    /**
     * Pour affichés des messages "d'information" applicative compréhensible par l'utilisateur.
     * 
     * @param titre
     * @param message 
     */
    static public void addInfo(String titre, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titre, message));
    }

    /**
     * Pour affichés des messages "Prudence" applicative compréhensible par l'utilisateur.
     * 
     * @param titre
     * @param message 
     */
    static public void addWarn(String titre, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titre, message));
    }

    /**
     * Pour affichés des messages "Erreur" applicative compréhensible par l'utilisateur.
     * 
     * @param titre
     * @param message 
     */
    static public void addError(String titre, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titre, message));
    }

    /**
     * Pour affichés des messages "Erreur Fatal" applicative compréhensible par l'utilisateur.
     * @param titre
     * @param message 
     */
    static public void addFatal(String titre, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titre, message));
    }


    
    /**
     * Accer au valeur du "parametrage.properties".<br/>
     * @return 
     */
    static public ResourceBundle getParamBundle(){
     return ResourceBundle.getBundle("/parameters");
    }
   
    
}
