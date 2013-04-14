package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.commun.CommunService;
import ca.etsmtl.gti525.dao.paiement.PaiementDAO;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.utils.DateUtils;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Level;
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
    
    private InformationsPaiementTO informationsPaiementTO =  new InformationsPaiementTO();
    private PaiementDAO pay = new PaiementDAO();
    private ReponseSystemePaiementTO preReponse = new ReponseSystemePaiementTO();
    private ReponseSystemePaiementTO finalReponse = new ReponseSystemePaiementTO();
    private RequeteAuthorisationTO finalInfos = new RequeteAuthorisationTO();
    
    @ManagedProperty(value = "#{panierCtrl}")
    private PanierControleur panierCtrl;    
      
    private Boolean disableInfoPaiment = Boolean.FALSE;
    
    private Client client = new Client();
    private CarteCredit carteCredit = new CarteCredit();
 
    
   @PostConstruct
    public void init() {
        // instanciation couche [métier de payment]
        super.initVante(); //InitDao.stubsDaoJpaPaiement est inistalisé
        super.initPresentation();
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
       row.setPrix(row.getQuantity()*25F);
       panierCtrl.majTotal();
    }
    
    public void save(ActionEvent actionEvent) {  
        //TODO Persist Billet + Client + VENTE
        this.panierCtrl.getCacheSessionPresentation().setDisablePaiement( Boolean.TRUE );
        this.finalInfos.setTransaction_id(this.preReponse.getTransactionId());
        this.finalInfos.setApi_key("38f33d8449386908efd4");
        this.finalInfos.setStore_id(50);
        finalReponse=this.pay.approuverTransaction(finalInfos);
        String statut = this.finalReponse.getStatus();
        if(statut.equals("Completed")){
            this.disableInfoPaiment = Boolean.TRUE;
            
                try {
                //Creeation du client et des billet aprés payement
                List<Billet> bis = new ArrayList<Billet>();
                    for (PanierBeans panier : this.panierCtrl.getPaniers()) {
                        for (int i = 0; i < panier.getQuantity();i++)
                        {
                            Billet bil = new Billet();
                            bil.setAdresse(panier.getVille());
                            bil.setDateRepresentation(panier.getDateRepresentation());
                            bil.setNomSpec(panier.getNomSpectacle());
                            Long idRep = panier.getIdRep();
                            Representation rep = this.daoPresentation.findRepresentationByID(idRep);
                            bil.setRepresentation(rep);
                            bil.setSalle(rep.getSalle());
                            bis.add(bil);
                        }
                        
                    }
                client.setBillets(bis);
                
                this.daoVente.createClient(client);
                } catch (Exception e) {
                    logger.log(Level.ERROR, "Message: "+e.getMessage(), e);
                }    
                    
            CommunService.addInfo("Succes", "Méthode «approuverTransaction();»");        
            CommunService.addInfo("Successful", "Merci Mr. :"+ client.getNom()+", pour votre payement");
            this.destroy();
        }else{
            CommunService.addInfo(this.finalReponse.getMessage(), " sur Méthode «approuverTransaction();»");
        }
       
    }  
      
  
    private boolean skip = false; 
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
        
        //informationsPaiementTO.setMonth(10);
        //informationsPaiementTO.setYear(2016);
        
        if(event.getNewStep().equals("client")) { //step creditCard

            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if(event.getNewStep().equals("creditCard")) { //step creditCard
            informationsPaiementTO.setFirst_name( this.client.getNom());
            informationsPaiementTO.setLast_name(this.client.getPrenom());
            informationsPaiementTO.setAmount(new BigDecimal(this.panierCtrl.getTotal()));
            CommunService.addInfo("Successful", "Merci Mr. :"+ client.getNom());
  
            CommunService.addInfo("Succes", "Next step: " + event.getNewStep() );
        }
        if (event.getNewStep().equals("confirm")) { //step client 
           informationsPaiementTO.setApi_key("38f33d8449386908efd4");
           informationsPaiementTO.setOrder_id(50);
           informationsPaiementTO.setStore_id(50);
           informationsPaiementTO.setCard_number(8675309000000000l); 
           informationsPaiementTO.setSecurity_code(this.client.getCarteCredit().getNumSecurite());
           informationsPaiementTO.setMonth(DateUtils.getMonth(this.client.getCarteCredit().getDateExpiration()));
           informationsPaiementTO.setYear(DateUtils.getYear(this.client.getCarteCredit().getDateExpiration()));
           
           preReponse=pay.effectuerPreauthorisation(informationsPaiementTO);
           String statut = preReponse.getStatus();
           //CommunService.addInfo("Successful", ""+DateUtils.getMonth(this.carteCredit.getDateExpiration()));
           //if (statut.equals("Accepted")){
               CommunService.addInfo(statut, "Méthode «effectuerPreauthorisation();»");
               if ( statut.isEmpty()) // || !statut.equals("Accepted")
                   return "tickets";
           //}
        }

        if("undefined".equals(event.getNewStep())) return "tickets";
        
        if(skip) {skip = false; return "tickets";}  //reset in case user goes back
         else return event.getNewStep();
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
