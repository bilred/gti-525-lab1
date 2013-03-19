package ca.etsmtl.gti525.dao;

import java.util.List;

/**
 *
 * @author REDOUANE
 */
public abstract class AbstractDaoJpaTest {
    
    @Override
    public boolean equals(Object obj){
        boolean test=false;
        if(obj !=null) test=true; else test=false;
        return (test);
    }    
    
    // méthode utilitaire - affiche les éléments d'une collection
    protected static void display(String message, List elements) {
        System.out.println(message);
        for (Object element : elements) {
            System.out.println(element);
        }
    }    
    
}
