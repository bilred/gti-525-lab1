package ca.etsmtl.gti525.batch.presentation;

import ca.etsmtl.gti525.batch.presentation.*;
import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.presentation.Billet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BilletBatch extends InitDao {
 static String currentDir = System.getProperty("user.dir");   
 private static final String BILLET_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\presentation\\DataBillet.csv";
 

  private static final int ID = 0;
  private static final int IS_VENDU = 1;
  private static final int IS_LIVRAISON = 2;
  private static final int ID_REPRESENTATION = 3; 
  private static final int ID_SALLE = 4; 
  private static final int ID_RESERVATION = 5; 
  
  /**
     * @param args the command line arguments
     */
  
  public static void batch(String path) {
        try {
            
            CSVReader reader = null;        
            reader = new CSVReader(new FileReader(path), ';');
            //"C:\\Users\\ak12420\\Documents\\NetBeansProjects\\trunk\\e-ticket-jpa\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\presentation\\DataBillet.csv"
            String[] nextLine;
  
            int first = 0;
            while ((nextLine = reader.readNext()) != null ) {

                if (first > 0) {
                     
                      Billet billet = new Billet();
                      billet.setIdBillet(Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)
                      billet.setIsVendu(Boolean.valueOf(nextLine[IS_VENDU]) );
                      billet.setIsLivraison(Boolean.valueOf(nextLine[IS_LIVRAISON]));
                      
                      new BilletBatch().initStubsPresentation();
                      //billet.setRepresentation(stubsDaoPresentation.findRepresentation(ID_REPRESENTATION));
//                      billet.setSalle(stubsDaoPresentation.findSalle(ID_SALLE));
//                      billet.setReservation(stubsDaoPresentation.findReservation(ID_RESERVATION));
                      
                      //System.out.println("----");
                      //Crée le billet.
                      // new BilletBatch().initStubsVante(); //init stubsDaoVente
                      //stubsDaoPresentation.createAdresse(billet); 
                      System.out.print( billet.getIdBillet()+";"+ billet.getIsVendu()+";"+ billet.getIsLivraison()+";");
                      System.out.println();
                      //System.out.println( billet.getRepresentation()+";"+ billet.getSalle()+";"+ billet.getReservation());
            }                  
                first++;
            }
                
                

          } catch (FileNotFoundException ex) {
              Logger.getLogger(BilletBatch.class.getName()).log(Level.SEVERE, null, ex);
         }
            catch (IOException ex) {
                Logger.getLogger(BilletBatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
    public static void main(String[] args) {        
          BilletBatch.batch(BILLET_FILE);
    }  
    
}