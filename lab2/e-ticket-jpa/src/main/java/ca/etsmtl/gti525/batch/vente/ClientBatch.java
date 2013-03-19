package ca.etsmtl.gti525.batch.vente;

import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.vente.Client;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientBatch extends InitDao {
 static String currentDir =System.getProperty("user.dir");   
 private static final String CLIENT_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataClient.csv";
 

  private static final int ID = 0;
  private static final int NOM = 1;
  private static final int PRENOM = 2;  
  private static final int NOM_CIVIQUE = 3;
  private static final int MAIL = 4;
  private static final int PHONE = 5;
  private static final int ID_ADRESSE = 6;
  private static final int ID_CARTE_CREDIT = 7;  
  
  /**
     * @param args the command line arguments
     */
  
  public static void batch(String path) {
        try {
            
            CSVReader reader = null;        
            reader = new CSVReader(new FileReader(path), ';');
            String[] nextLine;
            new AdresseBatch().initStubsVante(); //init stubsDaoVente
  
            int first = 0;
            while ((nextLine = reader.readNext()) != null ) {
                if (first > 0) {
                     
                      Client client = new Client();
                      
                      client.setId( Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)
                      client.setNom(nextLine[NOM]);
                      client.setPrenom(nextLine[PRENOM]);
                      client.setNomCivique(nextLine[NOM_CIVIQUE]);
                      client.setMail(nextLine[MAIL]);
                      client.setPhone(nextLine[PHONE]);
                      
                      //Cree l'Adreese. 
                      client.setAdresse(  stubsDaoVente.findAdresse(Long.valueOf(nextLine[ID_ADRESSE])) );  
                              
                      //Cree l'Adreese.
                      stubsDaoVente.createClient(client);                    
                }
                first++;
            }

          } catch (FileNotFoundException ex) {
              Logger.getLogger(ClientBatch.class.getName()).log(Level.SEVERE, null, ex);
         }
            catch (IOException ex) {
                Logger.getLogger(ClientBatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
    public static void main(String[] args) {        
          ClientBatch.batch(CLIENT_FILE);
    }  
    
}