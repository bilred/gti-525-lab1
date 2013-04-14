package ca.etsmtl.gti525.beans.paiement;

import ca.etsmtl.gti525.commun.taglib.ColonneTableModel;
import java.io.Serializable;
import java.util.Date;

/**
 * Tous les représantation selectionné.
 * et Interface entre les deux module (en utilisant le beansPanier)
 * @author REDOUANE
 */
public class PanierBeans implements ColonneTableModel, Serializable  {
    private int id;

   
    private String iconArtiste;
    private Integer quantity; //nbBiller
    private String nomSpectacle;
    private String ville;
    private Date dateRepresentation;
//    private String heurRepresantation;
    private Float prix;
    private Long idRep;

   
    public PanierBeans() { 
    super();
    }

    
    
    public String getIconArtiste() {
        if(iconArtiste==null) iconArtiste = new String();
        return iconArtiste;
    }

    public void setIconArtiste(String iconArtiste) {
        if(iconArtiste==null) iconArtiste = new String();
        this.iconArtiste = iconArtiste;
    }

    public Integer getQuantity() {
        if(quantity==null) quantity = new Integer(0);
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if(quantity==null) quantity = new Integer(0);
        
        this.quantity = quantity;
    }

    public String getVille() {
        if(ville==null) ville = new String();
        return ville;
    }

    public void setVille(String ville) {
        if(ville==null) ville = new String();
        this.ville = ville;
    }

    public Date getDateRepresentation() {
        if(dateRepresentation==null) dateRepresentation = new Date();
        return dateRepresentation;
    }

    public void setDateRepresentation(Date dateRepresentation) {
        if(dateRepresentation==null) dateRepresentation = new Date();
        this.dateRepresentation = dateRepresentation;
    }

    public Float getPrix() {
        if(prix==null) prix = new Float(0.0);
        return prix;
    }

    public void setPrix(Float prix) {
        if(prix==null) prix = new Float(0.0);
        this.prix = prix;
    }

    
    public void setNomSpectacle(String nomSpectacle) {
        if(nomSpectacle==null) nomSpectacle = new String();
        this.nomSpectacle = nomSpectacle;
    }
    
    public String getNomSpectacle() {
        if(nomSpectacle==null) nomSpectacle = new String();
        return nomSpectacle;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public Long getIdRep() {
        return idRep;
    }

    public void setIdRep(Long idRep) {
        this.idRep = idRep;
    }


}
