package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.dao.vente.IDaoVente;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author REDOUANE
 */
public class AbstractControleur {
    
    //@Ingection couche model et métier
    protected IDaoPresentation daoPresentation;
    //@Ingection couche model et métier
    protected IDaoVente daoVente;    
    
    public void initPresentation() {
        // instanciation couche [métier]
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        daoPresentation = (IDaoPresentation) ctx.getBean("daoPresentation"); 
        
    }
    
    public void initVante() {
        // instanciation couche [métier]
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        daoVente = (IDaoVente) ctx.getBean("daoVente");      
    }    
    
}
