package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author REDOUANE
 */
public class StubDaoVente implements IDaoVente {
    
    public List<Adresse> adresses = new ArrayList<Adresse>();
    public List<Client> clients = new ArrayList<Client>();

    @Override
    public void createAdresse(Adresse adresse) {
        adresses.add(adresse);
        Logger.getLogger(StubDaoVente.class.getName()).log(Level.INFO, null , "Creation des adresses.");
    }

    @Override
    public void createClient(Client client) {
        clients.add(client);
        Logger.getLogger(StubDaoVente.class.getName()).log(Level.INFO, null , "Creation des clients.");
    }

    @Override
    public Adresse findAdresse(Long id) {
        int index = id.intValue() - 1;
        return adresses.get(index);
    }
}
