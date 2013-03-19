package ca.etsmtl.gti525.batch.vente;

import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.vente.Reservation;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReservationBatch extends InitDao {
 static String currentDir =System.getProperty("user.dir");   
 private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";
 

  private static final int ID = 0;
  private static final int IS_RESERVATION = 1;
  private static final int DATE_RESERVATION = 2;  
  private static final int IS_CONFIRMATION_ACHAT = 3;
  
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
                     
                      Reservation reservation = new Reservation();
                      
                      //reservation.setId( Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)


                      //Cree l'Adreese.
                      stubsDaoVente.createReservation(reservation);                    
                }
                first++;
            }

          } catch (FileNotFoundException ex) {
              Logger.getLogger(ReservationBatch.class.getName()).log(Level.SEVERE, null, ex);
         }
            catch (IOException ex) {
                Logger.getLogger(ReservationBatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
    public static void main(String[] args) {        
          AdresseBatch.batch(ADRESSE_FILE);
    }  
    
}