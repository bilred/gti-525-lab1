package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.dao.vente.IDaoVente;
import gti525.paiement.IPaiementDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author REDOUANE
 */
public abstract class InitDao {

    //@Ingection couche model et métier
    protected IDaoPresentation daoPresentation;
    protected IDaoVente daoVente;
    
    protected static IDaoPresentation stubsDaoPresentation;
    protected static IDaoVente stubsDaoVente;
    protected static IPaiementDAO stubsDaoJpaPaiement;

        
    public void initPresentation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        daoPresentation = (IDaoPresentation) ctx.getBean("customerServiceProxy"); //daoPresentation
    }

    public void initVante() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        daoVente = (IDaoVente) ctx.getBean("customerServiceProxy2");
    }

    public void initStubsPresentation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-data.xml"});
        stubsDaoPresentation = (IDaoPresentation) ctx.getBean("stubsDaoPresentation");
    }

    public void initStubsVante() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-data.xml");
        stubsDaoVente = (IDaoVente) ctx.getBean("stubsDaoVente");
    }
    
    public void initStubsPaiement() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-data.xml"});
        stubsDaoJpaPaiement = (IPaiementDAO) ctx.getBean("stubsDaoJpaPaiement");
    }
    
    
    public void initTimeur() {
         ApplicationContext context = new ClassPathXmlApplicationContext("spring-scheduler.xml");
    }
    
}
