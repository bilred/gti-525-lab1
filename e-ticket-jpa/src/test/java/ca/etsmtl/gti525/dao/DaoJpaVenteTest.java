package ca.etsmtl.gti525.dao;

import ca.etsmtl.gti525.dao.vente.IDaoVente;
import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import java.util.ArrayList;
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
public class DaoJpaVenteTest extends AbstractDaoJpaTest {

    public DaoJpaVenteTest() { }
    // couche [dao] testée
    private static IDaoVente dao;


    @BeforeClass
    public static void init() {
        // instanciation couche [dao]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        dao = (IDaoVente) ctx.getBean("customerServiceProxy2");
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() { // affichage clients
//        Client cli = new Client();
//        cli.setAdresse( new Adresse());
//        cli.setBillets( new ArrayList<Billet>());
//        cli.setCarteCredit(new CarteCredit());
//        cli.setNom("Moi");
//        dao.createClient(new Client());
        
        List<Client> client = dao.findAllClient();
        display("Liste des Client :", client); 
        Assert.assertTrue("si table null alors True :", this.equals(client) );
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
