package ca.etsmtl.gti525.batch.presentation;

import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.batch.vente.*;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.gti525.entity.presentation.Salle;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalleBatch extends InitDao {
 static String currentDir =System.getProperty("user.dir");   
 private static final String ADRESSE_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\vente\\DataAdresse.csv";
 

  private static final int ID = 0;
  private static final int NAME = 1;
  private static final int NB_PLACE = 2;  
  private static final int ADRESSE_SALLE = 3;
  
  /**
     * @param args the command line arguments
     */
  
  public static void batch(String path) {
        try {
            
            CSVReader reader = null;        
            reader = new CSVReader(new FileReader(path), ';');
            String[] nextLine;
            new SalleBatch().initStubsPresentation(); //init
  
            int first = 0;
            while ((nextLine = reader.readNext()) != null ) {
                if (first > 0) {
                     
                      Salle salle = new Salle();
                      
                      //salle.setId( Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)


                      //Cree l'Adreese.
                      stubsDaoPresentation.createSalle(salle);                    
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