package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.vente.CarteCredit;
import ca.etsmtl.gti525.beans.vente.Client;
import ca.etsmtl.gti525.commun.CommunService;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "processPaiementCtrl")
@ViewScoped
public class ProcessPaiementControleur implements Serializable {    
    
    private Client client = new Client();
    private CarteCredit carteCredit = new CarteCredit();
 
   
    public void save(ActionEvent actionEvent) {  
        //TODO Persist Billet + Client + VENTE  
        CommunService.addInfo("Successful", "Je vous remercie Mr. :"+ client.getNom()+", pour votre payement"); 
    }  
      
    public boolean isSkip() {  
        return skip;  
    }  
  
    public void setSkip(boolean skip) {  
        this.skip = skip;  
    }  

    private static Logger logger = Logger.getLogger(ProcessPaiementControleur.class.getName());
    private boolean skip; 
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }
    }
    
    
    /**
     * Creates a new instance of ProcessPaiementControleur
     */
    public ProcessPaiementControleur() { }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    } 

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }
    
}
