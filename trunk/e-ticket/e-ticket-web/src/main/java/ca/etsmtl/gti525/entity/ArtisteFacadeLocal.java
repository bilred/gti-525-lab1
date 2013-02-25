/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author REDOUANE
 */
@Local
public interface ArtisteFacadeLocal {

    void create(Artiste artiste);

    void edit(Artiste artiste);

    void remove(Artiste artiste);

    Artiste find(Object id);

    List<Artiste> findAll();

    List<Artiste> findRange(int[] range);

    int count();
    
}
