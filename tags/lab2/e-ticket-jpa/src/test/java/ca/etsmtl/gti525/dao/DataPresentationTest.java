package ca.etsmtl.gti525.dao;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.util.List;
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
public class DataPresentationTest extends AbstractDaoJpaTest {

    public DataPresentationTest() { }
    // couche [dao] testée
    protected static IDaoPresentation stubsDaoPresentation;
    //protected static IDaoVente stubsDaoVente;


    @BeforeClass
    public static void init() {
        // instanciation couche [dao]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-data.xml"});
        stubsDaoPresentation = (IDaoPresentation) ctx.getBean("stubsCustomerServiceProxy");
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() { // affichage Data
        List<Spectacle> spectacle = stubsDaoPresentation.getAllSpectacle();
        display("Liste des Artiste :", spectacle); 
        Assert.assertTrue("si table null alors True :", this.equals(spectacle) );
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
