package ca.etsmtl.gti525.commun.taglib;

import org.primefaces.event.SelectEvent;

/**
 * philosofie de cette classe:<br/>
 * - pédagoguique et séparation des thechgnology<br/>
 * - elle peut étre utiliser comme des action a la façon des ActionListner<br/> 
 * ( tout les composant et framework utilise cette façon de faire plus simple )<br/><br/> 
 * hayla (bouste le travail de group)
 * 
 * @param <Type> 
 * @author redouane.billel
 */
public interface ItableCrud<Type, TypeColonne> {  //<Type, TypeColonne> pas forcement bon de l'utiliser avec le concepte que l'on veux premouvoir
  
   
    /**
     * Ecoute le bouton Actueliser
     */
    public abstract void doGetAllEnregistrement();
    /**
     * Ecoute le bouton Ajouter
     */
    public abstract void doInsert();    
    /**
     * Ecoute l'evenement onEditeListner (bouton modifier dans la pageCrud), pageModif?faces-redirect=true 
     * @param row
     */
    public abstract void onSelectionerOfEditer(TypeColonne row);
    /**
     * Ecoute bouton validé la modification dans la pageModif
     */    
    public abstract void doModif();  
    /**
     * Ecoute le bouton Supprimer
     */
    public abstract void onRemouveEnregistrement();
    /**
     * Ecoute l'evenement onSelectListner (choix d'une ligne sur la DataTable)
     * @param event
     */    
    public abstract void onSelectionerEnregistrement(SelectEvent event);
    /**
     * @param row 
     */
    public abstract void onDetailsEnregistrement(TypeColonne row);    
     
    
}