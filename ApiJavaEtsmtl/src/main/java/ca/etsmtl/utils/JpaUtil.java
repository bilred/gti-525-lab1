package ca.etsmtl.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*
 * Class pour créer EM , EMF utlisée pour executer les requetes JPA sur
 * une classe Main. (100% que java pas de Conteneur web)
 * 
 * Entre autre utilisé pour les batchs.
 * 
 * @creator Dalil
 */

public final class JpaUtil {

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    private static EntityManagerFactory emf;

    

    public static EntityManager getEntityManager(String persistUnitString) {
        emf = Persistence.createEntityManagerFactory(persistUnitString);
        return emf.createEntityManager();
    }
}
