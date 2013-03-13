package ca.etsmtl.gti525.vente.crud;

import ca.etsmtl.gti525.commun.taglib.ColonneTableModel;
import java.util.Date;

/**
 * Tous les représantation selectionné.
 * et Interface entre les deux module (en utilisant le beansPanier)
 * @author REDOUANE
 */
public class PanierBeans implements ColonneTableModel  {
	
    private String iconArtiste;
    private Integer quantity; //nbBiller
    private String nomSpectacle;
    private String ville;
    private Date dateRepresentation;
    private String heurRepresantation; 

    
    
    public String getIconArtiste() {
        return iconArtiste;
    }

    public void setIconArtiste(String iconArtiste) {
        this.iconArtiste = iconArtiste;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateRepresentation() {
        return dateRepresentation;
    }

    public void setDateRepresentation(Date dateRepresentation) {
        this.dateRepresentation = dateRepresentation;
    }

    public String getHeurRepresantation() {
        return heurRepresantation;
    }

    public void setHeurRepresantation(String heurRepresantation) {
        this.heurRepresantation = heurRepresantation;
    }
    
    public void setNomSpectacle(String nomSpectacle) {
        if(nomSpectacle==null) nomSpectacle = new String();
        this.nomSpectacle = nomSpectacle;
    }
    
    public String getNomSpectacle() {
        if(nomSpectacle==null) nomSpectacle = new String();
        return nomSpectacle;
    }
    

}
