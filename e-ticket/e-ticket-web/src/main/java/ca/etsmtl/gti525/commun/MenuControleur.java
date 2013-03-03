package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.dao.IDao;
import ca.etsmtl.gti525.entity.presentation.Artiste;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Spectacle;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "menuCtrl")
@ApplicationScoped
public class MenuControleur implements Serializable {
    private static final Logger log = Logger.getLogger(ApplicationControleur.class);
    
    //@Ingection couche model et métier
    private IDao dao;
    // cache
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private List<Artiste> artistes;

    @PostConstruct
    public void init() {
        // instanciation couche [métier]
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-dao.xml");
        dao = (IDao) ctx.getBean("dao");

        this.spectacles = dao.getAllSpectacle();
        this.representations = dao.getAllRepresentation();
        this.artistes = dao.getAllArtistes(); 
        
        log.info("sonar source Spectacle : " + this.spectacles);
        log.info("sonar source Representation : " + this.representations);
        log.info("sonar source Artiste : " + this.artistes);
    }    
    
    
    public String doHomme(){
        return "eticket.index";
    }
    
    public String doCart(){
        return "eticket.pageCart";
    }

    public String doShow(){
        return "eticket.pageShows";
    }
    
    /**
     * Creates a new instance of MenuControleur
     */
    public MenuControleur() {  }

    public List<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
    }    
    
}