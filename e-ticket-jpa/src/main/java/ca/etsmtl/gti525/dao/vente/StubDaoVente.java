package ca.etsmtl.gti525.dao.vente;

import ca.etsmtl.gti525.entity.vente.Adresse;
import ca.etsmtl.gti525.entity.vente.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author REDOUANE
 */
public class StubDaoVente implements IDaoVente {

    public List<Adresse> Adresses = new ArrayList<Adresse>();
    
    
    @Override
    public void createAdresse(Adresse adresse) {
        Adresses.add(adresse);
        //System.out.println("Mon adresse"+adresse.getVille());
    }

    @Override
    public void createClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
