package ca.etsmtl.gti525.batch.commun;

import ca.etsmtl.gti525.batch.vente.AdresseBatch;
import ca.etsmtl.gti525.batch.vente.ClientBatch;

/**
 * Attention ! L'ordre d'insertion est important
 * @author REDOUANE
 */
public class InitApplicationBatchs {

    static String currentDir = System.getProperty("user.dir");
    private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";
    private static final String CLIENT_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataClient.csv";
    
    public static void main(String[] args) {//throws PreexistingEntityException, RollbackFailureException, Exception {

        //Partie Vente
        AdresseBatch.batch(ADRESSE_FILE);
        ClientBatch.batch(CLIENT_FILE);
        //tous les autre Batche
    }
}
