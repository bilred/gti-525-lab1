package ca.etsmtl.gti525.dao;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author REDOUANE
 */
public class DaoJpaPresentationTest extends AbstractDaoJpaTest {

    public DaoJpaPresentationTest() {
    }
    // couche [dao] testée
    private static IDaoPresentation dao;
    // date du jour
    Date jour = new Date();

    @BeforeClass
    public static void init() throws NamingException {
        // instanciation couche [dao]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        dao = (IDaoPresentation) ctx.getBean("customerServiceProxy");         
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
//        dao = (IDaoPresentation) ctx.getBean("daoPresentation");
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() {
        // affichage clients
        List<Spectacle> spectacle = dao.getAllSpectacle();
        display("Liste des Artiste :", spectacle); 
        Assert.assertTrue("si table null alors True :", this.equals(spectacle) );
    }

    @Override
    public boolean equals(Object obj){
        boolean test=false;
        if(obj !=null) test=true; else test=false;
        return (test);
    }
    
    // méthode utilitaire - affiche les éléments d'une collection
    private static void display(String message, List elements) {
        System.out.println(message);
        for (Object element : elements) {
            System.out.println(element);
        }
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
}
