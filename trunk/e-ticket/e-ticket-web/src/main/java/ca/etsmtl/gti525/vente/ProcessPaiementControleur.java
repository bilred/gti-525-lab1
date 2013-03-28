package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.commun.CommunService;
import ca.etsmtl.gti525.dao.paiement.PaiementDAO;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.utils.DateUtils;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private static final String API_KEY = "38f33d8449386908efd4";
    private static final long CARD_NUMBER = 8675309000000000l;
    private static final int STORE_ID = 55; 
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
       logger.info("onSelectionerOfEditer A modifier la quantite de : "+row.getNomSpectacle());
       CommunService.addInfo("Succes", "Modification de la quantite du «"+row.getNomSpectacle()+"» avec la valeur de «"+row.getQuantity()+"»");
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
        InformationsPaiementTO informationsPaiementTO =  new InformationsPaiementTO();
        PaiementDAO pay = new PaiementDAO();
        ReponseSystemePaiementTO preReponse = new ReponseSystemePaiementTO();
        informationsPaiementTO.setApi_key("38f33d8449386908efd4");
        informationsPaiementTO.setOrder_id(50);
        informationsPaiementTO.setStore_id(50);
        informationsPaiementTO.setMonth(10);
        informationsPaiementTO.setYear(2016);
        
        informationsPaiementTO.setSecurity_code(333);
        if(event.getNewStep().equals("client")) { //step creditCard

            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if(event.getNewStep().equals("creditCard")) { //step creditCard
            informationsPaiementTO.setFirst_name( "tata");
            informationsPaiementTO.setLast_name("zaza");
            informationsPaiementTO.setAmount(BigDecimal.TEN);
            
            
           
            
            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if (event.getNewStep().equals("confirm")) { //step client 
           informationsPaiementTO.setCard_number(8675309000000000l);
           
           //informationsPaiementTO.setMonth(DateUtils.getMonth(this.carteCredit.getDateExpiration()));
           //informationsPaiementTO.setYear(DateUtils.getYear(this.carteCredit.getDateExpiration()));
           
           preReponse=pay.effectuerPreauthorisation(informationsPaiementTO);
           String statut = preReponse.getStatus();
           
           System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+preReponse.getStatus()+"ZZZZZZZZZZZZZZZZZZZZ");
           //...
           //ReponseSystemePaiementTO reponseSystemePaiementTO = InitDao.stubsDaoJpaPaiement.effectuerPreauthorisation(infoPaiement);
           //reponseSystemePaiementTO
           //if (statut.equals("Accepted")){
               CommunService.addInfo(statut, "Méthode «effectuerPreauthorisation();»");
           //}
           
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
