package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.commun.StubDataBase;
import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.CarteCredit;
import ca.etsmtl.gti525.entity.vente.Client;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REDOUANE
 */
public class StubDaoVente implements IDaoVente, Serializable {
    
    private StubDataBase stubDataBase = StubDataBase.getInstance();
    

    @Override
    public void createAdresse(Adresse adresse) {
        stubDataBase.adresses.add(adresse);
        Logger.getLogger(StubDaoVente.class.getName()).log(Level.INFO, null , "Creation des adresses.");
    }

    @Override
    public void createClient(Client client) {
        stubDataBase.clients.add(client);
        Logger.getLogger(StubDaoVente.class.getName()).log(Level.INFO, null , "Creation des clients.");
    }

    @Override
    public Adresse findAdresse(Long id) {
        int index = id.intValue() - 1;
        return stubDataBase.adresses.get(index);
    }

    @Override
    public void createCarteCredit(CarteCredit carteCredit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createReservation(Reservation reservation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
