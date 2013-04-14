package ca.etsmtl.gti525.dao;

import ca.etsmtl.gti525.dao.presentation.IDaoPresentation;
import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
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
public class DaoJpaPresentationTest extends AbstractDaoJpaTest {

    public DaoJpaPresentationTest() { }
    // couche [dao] testée
    private static IDaoPresentation dao;

    @BeforeClass
    public static void init() {
        // instanciation couche [dao]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-config-dao.xml"});
        dao = (IDaoPresentation) ctx.getBean("customerServiceProxy"); //stubsCustomerServiceProxy
    }

    /**
     * Test of getAllArtistes method, of class DaoJpa.
     */
    @Test
    public void testGetAllArtistes() {
        // affichage clients
//        List<Artiste> spectacle = dao.getAllArtistes();
//        display("Liste des Artiste :", spectacle); 
//        Assert.assertTrue("si table null alors True :", this.equals(spectacle) );
        List<Artiste> artiste = dao.getAllArtistes();
        display("Liste des Artiste :", artiste); 
        Assert.assertTrue("si table null alors True :", this.equals(artiste) );        
    }
    
       @Test
    public void testFindRepresentationByID() {
        // affichage clients
//        List<Artiste> spectacle = dao.getAllArtistes();
//        display("Liste des Artiste :", spectacle); 
//        Assert.assertTrue("si table null alors True :", this.equals(spectacle) );
        Representation rep = dao.findRepresentationByID(1L);
        System.out.println(rep);
           ; 
        Assert.assertTrue("si table null alors True :", this.equals(rep) );        
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
