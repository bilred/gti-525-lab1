package ca.etsmtl.gti525.commun;

import ca.etsmtl.gti525.batch.presentation.BilletBatch;
import ca.etsmtl.gti525.batch.presentation.RepresentationBatch;

/**
 * Attention ! L'ordre d'insertion est important
 * @author REDOUANE
 */
public class InitApplicationBatchs {

    static String currentDir = System.getProperty("user.dir");
    private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";
    private static final String CLIENT_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataClient.csv";
    private static final String BILLET_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\presentation\\DataBillet.csv";
    private static final String REPRESENTATION_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\presentation\\DataRepresentation.csv";
    
    public static void main(String[] args) {//throws PreexistingEntityException, RollbackFailureException, Exception {

        //Partie Presentation
        RepresentationBatch.batch(REPRESENTATION_FILE);
        BilletBatch.batch(BILLET_FILE);
        
        //Partie Vente
//        AdresseBatch.batch(ADRESSE_FILE);
//        ClientBatch.batch(CLIENT_FILE);
        //tous les autre Batche
    }
}
