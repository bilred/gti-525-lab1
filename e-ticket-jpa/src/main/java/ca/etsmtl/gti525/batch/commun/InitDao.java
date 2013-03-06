package ca.etsmtl.gti525.batch.commun;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.dao.vente.IDaoVente;
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

    
    public void initPresentation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        daoPresentation = (IDaoPresentation) ctx.getBean("daoPresentation");
    }

    public void initVante() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        daoVente = (IDaoVente) ctx.getBean("daoVente");
    }

    public void initStubsPresentation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-data.xml");
        stubsDaoPresentation = (IDaoPresentation) ctx.getBean("daoPresentation");
    }

    public void initStubsVante() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-data.xml");
        stubsDaoVente = (IDaoVente) ctx.getBean("stubsDaoVente");
    }
}
