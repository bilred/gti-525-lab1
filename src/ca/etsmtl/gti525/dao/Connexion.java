package ca.etsmtl.gti525.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

/**
 * <pre>
 * Singletton nous produit la source de connexion.<br/><br/>
 * 
 * Remarque : 
 * Dans ce cas vous n'avait plus besoin de gérais les "DbUtils.close(conn); => a cause du singleton 0_o".
 * Erreur que j'ai eux o_O ==> Après chaque requête je feusé "DbUtils.closeQuietly(conn)" et je me demandé pour quoi les autre requête ne marcher pas puisque le 1er Marche. (1 jour de ma vie perdu)
 * </pre>
 * 
 * @author billel.redouane
 * 
 */
public class Connexion extends ParamConnexion {

	private static Connection conn;

	
	private Connexion(){ }
	
	public final static Connection getConnection() {
		if(Connexion.conn == null){
			DbUtils.loadDriver(ParamConnexion.driver);
			try {
				  Connexion.conn = DriverManager.getConnection(ParamConnexion.url, ParamConnexion.user, ParamConnexion.passwd);
			    } catch (SQLException e) {
			      //BisnesseLogs.logger.logp(Level.INFO, Connexion.class.getName(), "Méthode: getConnection", "Base de donné inaccessible !!");
			      System.out.println("Méthode: getConnection, Base de donné inaccessible !!");	
			    }
		}
		return Connexion.conn;
	}
}
