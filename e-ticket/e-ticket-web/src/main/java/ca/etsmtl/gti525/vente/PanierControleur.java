package ca.etsmtl.gti525.vente;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.commun.AbstractControleur;
import ca.etsmtl.gti525.commun.CommunService;
import ca.etsmtl.gti525.commun.MenuControleur;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import ca.etsmtl.gti525.presentation.CacheSessionPresentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * @author B.REDOUANE
 */
@ManagedBean(name = "panierCtrl")
@SessionScoped
public class PanierControleur extends AbstractControleur implements Serializable {
    private static final Logger log = Logger.getLogger(PanierControleur.class);
    
    //pour recuprér les represantation selectionner (et remplire le paniers)
    @ManagedProperty(value = "#{cacheSessionPresentationCtrl}")
    private CacheSessionPresentation cacheSessionPresentation;
    
    @ManagedProperty(value="#{menuCtrl}")
    private MenuControleur menuCtrl;
    private Float total = 0F;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    public MenuControleur getMenuCtrl() {
        return menuCtrl;
    }

    public void setMenuCtrl(MenuControleur menuCtrl) {
        this.menuCtrl = menuCtrl;
    }
    private List<PanierBeans> paniers; //passer au proccese de paiment
    private int count;

    private static HttpSession session;  //session a invalidé (aprés inistalisation avec la session courant)
    
    public synchronized void increment() {
        try { //si temps doit faire une exception personalisé pour ce cas.
            PanierBeans panier = null;
            Spectacle specSelec = this.getCacheSessionPresentation().getSpectacleSelected();
            List<Representation> repSelect = this.getCacheSessionPresentation().getRepresentationSelected();
            
            if (repSelect.size()==0) throw new Exception();
                  
            for (int i=0 ; i < repSelect.size() ; i++) {
                if(repSelect.get(i).getNbBilletsDispo()>=repSelect.get(i).getQTE()){
                    repSelect.get(i).setNbBilletsDispo(repSelect.get(i).getNbBilletsDispo()-repSelect.get(i).getQTE());
                this.menuCtrl.changerQte(repSelect.get(i));

                panier = new PanierBeans();
                panier.setId(repSelect.get(i).getId().intValue());
                panier.setNomSpectacle(specSelec.getNomSpectacle());
                panier.setPrix(repSelect.get(i).getPrix()*repSelect.get(i).getQTE());
                panier.setQuantity(repSelect.get(i).getQTE());
                panier.setVille(repSelect.get(i).getSalle().getAdresse());
                panier.setIdRep(repSelect.get(i).getId());
                //+ nombre de biller dispo
                this.total=total+panier.getPrix();
                this.getPaniers().add(panier);
                    
                }else{
                    CommunService.addWarn("ATTENTION !", "Le nombre de billets disponible est insuffisant");
                }
                
            }

            count = qteBilletsPanier(); //selon le nombre de biller (Attantion ! une N place pour une même représantation et compté 1)
            this.cacheSessionPresentation.setDisablePanier(Boolean.TRUE); //Désactiver le panier (le réactivé si d'autre selection)
            this.cacheSessionPresentation.setDisablePaiement(Boolean.FALSE); //Activer le le paiement
            
            //Appel au timeur :
            FacesContext context = FacesContext.getCurrentInstance();
            session = (HttpSession) context.getExternalContext().getSession(false);
            this.initTimeur(); //600 *(1000 de la méthode) = 2minut
            log.info("Panier increment(), valeur initial: " + count);
        } catch (Exception ex) {
            log.warn("Vous devez avoir séléctionné des représentations pour faire des ajouté dans le panier.");
            CommunService.addWarn("ATTENTION !", "Vous devais avoir sélectionnais des représentations");
        }
    }

    //private Representation representationDetail;
    public void onDetailsEnregistrement(Representation item) { }
    
    /**
     * méthode supprimant une rep/billets
     * @param item 
     */
    public void supprimerRep(Representation item) {
        //Representation rechRep = InitDao.stubsDaoPresentation.findRepresentationByID(item.getId());
        this.cacheSessionPresentation.getRepresentationSelected().remove(item);
    }
    
    public void supprimerBillet (PanierBeans pan){
        
        List<Representation> repSelect = this.getCacheSessionPresentation().getRepresentationSelected();
        for(int i = 0; i<repSelect.size();i++){
            
          if (repSelect.get(i).getId()== pan.getId()) {
              repSelect.get(i).setNbBilletsDispo(repSelect.get(i).getNbBilletsDispo()+ pan.getQuantity());
              this.menuCtrl.changerQte(repSelect.get(i));
              this.getCacheSessionPresentation().getRepresentationSelected().remove( repSelect.get(i) ); 
              this.count = this.count - pan.getQuantity();
              this.total=total-pan.getPrix();
          }
              
        }
        this.paniers.remove(pan);   
    }   
    

    /**
     * Creates a new instance of PanierControleur
     */
    public PanierControleur() { }
    
//    @Async
    public int getCount() {
        return count;
    }
//    @Async
    public void setCount(int count) {
        this.count = count;
    }

    public CacheSessionPresentation getCacheSessionPresentation() {
        return cacheSessionPresentation;
    }

    public void setCacheSessionPresentation(CacheSessionPresentation cacheSessionPresentation) {
        this.cacheSessionPresentation = cacheSessionPresentation;
    }

    @Async
    public List<PanierBeans> getPaniers() {
        if (paniers == null) {
            paniers = new ArrayList<PanierBeans>();
        }
        return paniers;
    }

    //@Async
    public void setPaniers(List<PanierBeans> paniers) {
        if (paniers == null) {
            paniers = new ArrayList<PanierBeans>();
        }
        this.paniers = paniers;
    }

    public int qteBilletsPanier() {
        int somme = 0;
        for (int i = 0; i < this.paniers.size(); i++) {
            somme = somme + this.paniers.get(i).getQuantity();
        }
        return somme;
    }
    public void majTotal(){
        total=0F;
        for (int i =0; i<paniers.size();i++)
            total = total+paniers.get(i).getPrix();
    }

    @Async
    public HttpSession getSession() {
        return session;
    }

    @Async
    public void setSession(HttpSession session) {
        this.session = session;
    }
   
    
    
    @Async
    public void destroy(){
//      this.setPaniers( new ArrayList<PanierBeans>() );
//      this.setCount(0);       
      //this.getCacheSessionPresentation().destroy();
       //this.session.invalidate();        
      log.info("Nettoyage du PanierControleur"); // Après avoir récupéré les représentations sélectionner
    }
    
     
    public synchronized void asyncWorker() {
        System.out.println("Run asyncWorker ~");
        //synchronized (this.session) {}
        //Session invalidet
//       FacesContext context = FacesContext.getCurrentInstance();
//       HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        //CommunService.addWarn("Attention !", "Session invalidate !.");
         log.info("session.invalidate(), Session ID: "+session.getId()+" (aprés passage du timeur)");
         session.invalidate(); //this.destroy(); 
    }    

}
