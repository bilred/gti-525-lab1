package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.entity.presentation.Billet;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 * il faut que ce soit un Singleton
 * 
 * @author REDOUANE
 */
public class StubDataBase {
    
    private static StubDataBase stubDataBase;
    
    //DataBase Presentation
    public List<Representation> representations = new ArrayList<Representation>();
    public List<Salle> salles = new ArrayList<Salle>();
    public List<Reservation> reservations = new ArrayList<Reservation>();
    public List<Billet> billets = new ArrayList<Billet>();
   
    //DataBase Presentation vente
    public List<Adresse> adresses = new ArrayList<Adresse>();
    public List<Client> clients = new ArrayList<Client>();    

    private StubDataBase() {
     //lancement des données
       // InitApplicationBatchs.main(null);
    }
    
    public static StubDataBase getInstance() {
        if(StubDataBase.stubDataBase == null) StubDataBase.stubDataBase = new StubDataBase();
        return StubDataBase.stubDataBase;
    }
    
    
    
}
