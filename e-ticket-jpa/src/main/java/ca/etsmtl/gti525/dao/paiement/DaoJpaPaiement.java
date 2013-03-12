package ca.etsmtl.gti525.dao.paiement;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;

/**
 *
 * @author REDOUANE
 */
public class DaoJpaPaiement implements IPaiementDAO {

    @Override
    public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO ipto) {
        return new ReponseSystemePaiementTO();
    }

    @Override
    public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO rato) {
        return new ReponseSystemePaiementTO();
    }
    
}
