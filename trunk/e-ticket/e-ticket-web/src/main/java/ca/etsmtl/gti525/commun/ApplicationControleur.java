package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.dao.IDao;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author REDOUANE
 */
@ManagedBean(name = "applicationCtrl")
@ApplicationScoped
public class ApplicationControleur implements Serializable {
    private static final Logger log = Logger.getLogger(ApplicationControleur.class);
    
    //@Ingection couche model et métier
    private IDao dao;
    // cache

}
