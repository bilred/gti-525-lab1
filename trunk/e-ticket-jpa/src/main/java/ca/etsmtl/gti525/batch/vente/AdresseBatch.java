package ca.etsmtl.gti525.batch.vente;

import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.vente.Adresse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benabid.aichouche
 */
public class AdresseBatch extends InitDao {
 static String currentDir =System.getProperty("user.dir");   
 private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";
 

  private static final int ID = 0;
  private static final int RUE = 1;
  private static final int APPARTEMENT = 2;  
  private static final int VILLE = 3;
  private static final int REGION = 4;
  private static final int CODE_POSTAL = 5;
  
  /**
     * @param args the command line arguments
     */
  
  public static void batch(String path) {
        try {
            
            CSVReader reader = null;        
            reader = new CSVReader(new FileReader(path), ';');
            String[] nextLine;
  
            int first = 0;
            while ((nextLine = reader.readNext()) != null ) {
                if (first > 0) {
                     
                      Adresse adresse = new Adresse();
                      
                      adresse.setId( Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)
                      adresse.setRue(nextLine[RUE]);
                      adresse.setAppartement(nextLine[APPARTEMENT]);
                      adresse.setVille(nextLine[VILLE]);
                      adresse.setRegion(nextLine[REGION]);
                      adresse.setCodePostal(nextLine[CODE_POSTAL]);

                      //Cree l'Adreese.
                      new AdresseBatch().initStubsVante(); //init stubsDaoVente
                      stubsDaoVente.createAdresse(adresse);                    
                }
                first++;
            }

          } catch (FileNotFoundException ex) {
              Logger.getLogger(AdresseBatch.class.getName()).log(Level.SEVERE, null, ex);
         }
            catch (IOException ex) {
                Logger.getLogger(AdresseBatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
    public static void main(String[] args) {        
          AdresseBatch.batch(ADRESSE_FILE);
    }  
    
}