package ca.etsmtl.gti525.dao;

import gti525.paiement.IPaiementDAO;
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
public class DataPaiementTest extends AbstractDaoJpaTest {

    public DataPaiementTest() { }
    // couche [dao] testée
    protected static IPaiementDAO stubsDaoJpaPaiement;
    //protected static IDaoVente stubsDaoVente;


    @BeforeClass
    public static void init() {
        // instanciation couche [dao]
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-data.xml"});
//        stubsDaoJpaPaiement = (IPaiementDAO) ctx.getBean("stubsDaoJpaPaiement");        
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() { // affichage Data
//        List<Client> client = stubsDaoVente.getAllCleint();
//        display("Liste des client :", client); 
//        Assert.assertTrue("si table null alors True :", this.equals(client) );
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
