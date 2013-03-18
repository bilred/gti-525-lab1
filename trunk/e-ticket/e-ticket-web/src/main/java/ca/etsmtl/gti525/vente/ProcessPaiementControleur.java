package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.commun.CommunService;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.RequeteAuthorisationTO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "processPaiementCtrl")
@ViewScoped
public class ProcessPaiementControleur extends AbstractControleur implements Serializable {    
    private static Logger logger = Logger.getLogger(ProcessPaiementControleur.class.getName());
    
    //pour recuprér les represantation selectionner (et remplire le panier)
    @ManagedProperty(value = "#{panierCtrl}")
    private PanierControleur panierCtrl;    
      
    private Boolean disableInfoPaiment = Boolean.FALSE;
    
    private Client client = new Client();
    private CarteCredit carteCredit = new CarteCredit();
 
    
   @PostConstruct
    public void init() {
        // instanciation couche [métier de payment]
        super.initStubsPresentation(); //InitDao.stubsDaoJpaPaiement est inistalisé
   }
    @PreDestroy
    public void destroy(){
      this.setCarteCredit(new CarteCredit());
      //this.setClient( new Client());
      this.panierCtrl.getCacheSessionPresentation().setRepresentationSelected( null );
      this.panierCtrl.setPaniers( null );
      this.getPanierCtrl().getCacheSessionPresentation().setDisablePanier(Boolean.FALSE);
      this.panierCtrl.setCount(0);
      logger.info("@PreDestroy : Information Client et Paiement utiliser dans le processus son détruite.");
    }   
   
    public void onSelectionerOfEditer(PanierBeans row){
           System.out.println("A modifier : "+row.getNomSpectacle()); 
    }
    
    public void save(ActionEvent actionEvent) {  
        //TODO Persist Billet + Client + VENTE
        this.panierCtrl.getCacheSessionPresentation().setDisablePaiement( Boolean.TRUE );
        
        RequeteAuthorisationTO requeteAuth = new RequeteAuthorisationTO(); requeteAuth.setApi_key("myKeys"); //...
        //ReponseSystemePaiementTO reponseSystemePaiementTO = InitDao.stubsDaoJpaPaiement.approuverTransaction(requeteAuth);
        //reponseSystemePaiementTO
        
        this.disableInfoPaiment = Boolean.TRUE;
        CommunService.addInfo("Succes", "Méthode «approuverTransaction();»");        
        CommunService.addInfo("Successful", "Merci Mr. :"+ client.getNom()+", pour votre payement");
        this.destroy();
    }  
      
  
    private boolean skip = false; 
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(event.getNewStep().equals("client")) { //step creditCard
            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if(event.getNewStep().equals("creditCard")) { //step creditCard
            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if (event.getNewStep().equals("confirm")) { //step client 
           InformationsPaiementTO infoPaiement = new InformationsPaiementTO(); infoPaiement.setCard_number(202215848911L); //...
           //ReponseSystemePaiementTO reponseSystemePaiementTO = InitDao.stubsDaoJpaPaiement.effectuerPreauthorisation(infoPaiement);
           //reponseSystemePaiementTO
           CommunService.addInfo("Succes", "Méthode «effectuerPreauthorisation();»");
        }

        if("undefined".equals(event.getNewStep())) return "tickets";
        
        if(skip) {  
            skip = false; return "tickets";  //reset in case user goes back
        }
        else {  
            return event.getNewStep();  
        }
    }
    
    
    /**
     * Creates a new instance of ProcessPaiementControleur
     */
    public ProcessPaiementControleur() { }

    
    public PanierControleur getPanierCtrl() {
        return panierCtrl;
    }

    public void setPanierCtrl(PanierControleur panierCtrl) {
        this.panierCtrl = panierCtrl;
    }

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

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Boolean getDisableInfoPaiment() {
        return disableInfoPaiment;
    }
        
    
}
