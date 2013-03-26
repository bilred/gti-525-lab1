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
public class DaoJpaVenteTest extends AbstractDaoJpaTest {

    public DaoJpaVenteTest() { }
    // couche [dao] testée
    private static IDaoPresentation dao;


    @BeforeClass
    public static void init() throws NamingException {
        // instanciation couche [dao]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        dao = (IDaoPresentation) ctx.getBean("customerServiceProxy");
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() {
        // affichage clients
        List<Spectacle> spectacle = dao.getAllSpectacle();
        display("Liste des Spectacle :", spectacle); 
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
