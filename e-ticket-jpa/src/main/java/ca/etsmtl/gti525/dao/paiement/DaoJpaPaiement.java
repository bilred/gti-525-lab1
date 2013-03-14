package ca.etsmtl.gti525.dao.paiement;

import gti525.paiement.IPaiementDAO;
import gti525.paiement.InformationsPaiementTO;
import gti525.paiement.ReponseSystemePaiementTO;
import gti525.paiement.RequeteAuthorisationTO;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author REDOUANE
 */
public class DaoJpaPaiement implements IPaiementDAO, Serializable {
    private static final Logger LOG = Logger.getLogger(DaoJpaPaiement.class.getName());

    @Override
    public ReponseSystemePaiementTO effectuerPreauthorisation(InformationsPaiementTO ipto) {
        LOG.info("La méthode de -effectuerPreauthorisation- a ete appelé de son DAO");
        return new ReponseSystemePaiementTO();
    }

    @Override
    public ReponseSystemePaiementTO approuverTransaction(RequeteAuthorisationTO rato) {
        LOG.info("La méthode de -approuverTransaction- a ete appelé de son DAO");
        return new ReponseSystemePaiementTO();
    }
    
}
