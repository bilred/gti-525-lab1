package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Remarque : peu importe la date et l'heur une représantation ce fait que dans une seul salle a la fois. (pour un même spectacle)
 * @author REDOUANE
 *
 */
@Entity
@Table(name = "SHOW_REPRESENTATION")
public class Representation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "IS_ANNULATION")
    private Boolean isAnnulation;
    @Column(name = "NB_BILLETS_DISPO")
    private Integer nbBilletsDispo;
    @Column(name = "QTE_SELECTED")
    private Integer QTE;
    @Column(name = "PRIX")
    private Float prix;
//    private Map <Integer, Integer> optionsQte = new HashMap<Integer, Integer>();
    private List<Integer> optionsQte2 = new ArrayList<Integer>();

    public List<Integer> getOptionsQte2() {
        return optionsQte2;
    }

    public void setOptionsQte2(List<Integer> optionsQte2) {
        this.optionsQte2 = optionsQte2;
    }
 
    
    

   
    
    @OneToOne
    private Salle salle;

    @ManyToOne
    private Spectacle spectacle;

    @OneToOne(mappedBy = "representation")
    private Billet billet;
    
    public Representation(){
//        optionsQte.put(1, 1);
//        optionsQte.put(2, 2);
//        optionsQte.put(3, 3);
//        optionsQte.put(4, 4);
//        optionsQte.put(5, 5);
//        optionsQte.put(6, 6);
        optionsQte2.add(1);
        optionsQte2.add(2);
        optionsQte2.add(3);
        optionsQte2.add(4);
        optionsQte2.add(5);
        optionsQte2.add(6);
    }
    public Integer getQTE() {
        return QTE;
    }

    public void setQTE(Integer QTE) {
        this.QTE = QTE;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public Integer getNbBilletsDispo() {
        return nbBilletsDispo;
    }

    public void setNbBilletsDispo(Integer nbBilletsDispo) {
        this.nbBilletsDispo = nbBilletsDispo;
    }

    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getIsAnnulation() {
        return isAnnulation;
    }

    public void setIsAnnulation(Boolean isAnnulation) {
        this.isAnnulation = isAnnulation;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    
}
