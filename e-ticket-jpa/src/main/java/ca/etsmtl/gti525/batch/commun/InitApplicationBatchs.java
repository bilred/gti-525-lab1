package ca.etsmtl.gti525.batch.commun;

import ca.etsmtl.gti525.batch.vente.AdresseBatch;

/**
 *
 * @author SAM.Bilel
 */
public class InitApplicationBatchs {

    static String currentDir = System.getProperty("user.dir");
    private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";

    public static void main(String[] args) {//throws PreexistingEntityException, RollbackFailureException, Exception {

        //Partie Vente
        AdresseBatch.batch(ADRESSE_FILE);
        //tous les autre Batche
    }
}
