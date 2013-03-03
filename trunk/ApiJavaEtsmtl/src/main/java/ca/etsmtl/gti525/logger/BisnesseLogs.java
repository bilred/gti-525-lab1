package ca.etsmtl.gti525.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Syst�me de log Basique. <br/><br/>
 * 
 * Besoin est n� su fait : que les message son pas claire et insuffisant dans la Console Apache voir pas visible. (avec sa la vue vous r�viez) 
 * @author billel.redouane
 *
 */
public class BisnesseLogs {
	
	public static Logger logger = Logger.getLogger( BisnesseLogs.class.getName() );
	public static final Level LEVEL_LOGS = Level.INFO; //l'option D�sactiver les logs par Niveaux
	
	/**
	 * Les noms des fichiers sont : logs_0.txt, logs_1.txt et logs_2.txt.
	 * La taille de fichiers est fix�e � 200 octets.
	 * %g donne automatiquement un num�ro aux fichiers de 0 � 3.
	 * FileHandler("C:\\logs_%g.xml", 200, 3, Boolean.TRUE);
	 */
	public BisnesseLogs(){	
		try {
			FileHandler fh = new FileHandler("C:\\logs.xml", Boolean.TRUE); //True => pour ecrire dans un seul ficher sans �cras� le contenu
			logger.setLevel(LEVEL_LOGS); fh.setLevel(LEVEL_LOGS); 
			logger.addHandler(fh);
			
			logger.logp(Level.INFO, "Source Classe => BisnesseLogs", "Source M�thode => BisnesseLogs", "Message => Insialisation des Config de logs");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
