package ca.etsmtl.gti525.batch.presentation;

import au.com.bytecode.opencsv.CSVReader;
import ca.etsmtl.gti525.commun.InitDao;
import ca.etsmtl.gti525.entity.presentation.Representation;
import ca.etsmtl.utils.DateUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RepresentationBatch extends InitDao {
 static String currentDir =System.getProperty("user.dir");   
 private static final String REPRESENTATION_FILE = currentDir + "\\src\\main\\java\\ca\\etsmtl\\gti525\\batch\\csv\\presentation\\DataRepresentation.csv";

  private static final int ID = 0;
  private static final int DATE_DEBUT = 1;  
  private static final int DATE_FIN = 2;
  private static final int IS_ANNULATION = 3;
  private static final int NB_BILLETS_DISPO = 4;
  private static final int PRIX = 5;  
  
  /**
     * @param args the command line arguments
     */
  
  public static void batch(String path) {
        try {
            
            CSVReader reader = null;        
            reader = new CSVReader(new FileReader(path), ';');
            String[] nextLine;
            new RepresentationBatch().initStubsPresentation();
  
            int first = 0;
            while ((nextLine = reader.readNext()) != null ) {
                if (first > 0) {
                     
                      Representation representation = new Representation();
                      
                      representation.setId( Long.valueOf(nextLine[ID]) ); //pour les listes ne mes pas ID (même pour la BD deja)
                      representation.setDateDebut( DateUtils.formateStringToDate(nextLine[DATE_DEBUT], "dd/mm/yyyy") );
                      representation.setDateFin( DateUtils.formateStringToDate(nextLine[DATE_FIN], "dd/mm/yyyy") );
                      representation.setIsAnnulation(Boolean.FALSE);
                      representation.setNbBilletsDispo( Integer.valueOf(nextLine[NB_BILLETS_DISPO]) );
                      representation.setPrix( Float.valueOf(nextLine[PRIX]) );

                      //Cree l'Adreese.
                      InitDao.stubsDaoPresentation.createRepresentation(representation);                    
                }
                first++;
            }

          } catch (FileNotFoundException ex) {
              Logger.getLogger(RepresentationBatch.class.getName()).log(Level.SEVERE, null, ex);
         }
            catch (IOException ex) {
                Logger.getLogger(RepresentationBatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
  
    public static void main(String[] args) {        
          RepresentationBatch.batch(REPRESENTATION_FILE);
    }  
    
}