package ca.etsmtl.gti525.entity.presentation;

import ca.etsmtl.gti525.commun.CommunService;
import java.io.Serializable;
import java.util.Date;
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
//    @Column(name = "HEURE_DEBUT")
//    @Temporal(TemporalType.TIME)
//    private Calendar heureDebut;

    
    /*@Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;*/
    /*@Column(name = "IS_ANNULATION")
    private Boolean isAnnulation;*/
    @Column(name = "NB_BILLETS_DISPO")
    private Integer nbBilletsDispo;
    @Column(name = "QTE_SELECTED")
    private Integer QTE;
    @Column(name = "PRIX")
    private Float prix;
//    private Map <Integer, Integer> optionsQte = new HashMap<Integer, Integer>();
  /*  private List<Integer> optionsQte2 = new ArrayList<Integer>();

    public List<Integer> getOptionsQte2() {
        return optionsQte2;
    }

    public void setOptionsQte2(List<Integer> optionsQte2) {
        this.optionsQte2 = optionsQte2;
    }*/
//
//    public Calendar getHeureDebut() {
//        return heureDebut;
//    }
//
//    public void setHeureDebut(Calendar heureDebut) {
//        this.heureDebut = heureDebut;
//    }

 
    
    

   
    
   
    
    @OneToOne
    private Salle salle;

    @ManyToOne
    private Spectacle spectacle;

    @OneToOne(mappedBy = "representation")
    private Billet billet;
    
    public Representation(){
        
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
        
        //int min_ticket_allowed = nbBilletsDispo;
       // if (nbBilletsDispo >= 6)
        //{
        //min_ticket_allowed = 6;
       // }
       // optionsQte2.clear();
       //         for (int i=0; i< min_ticket_allowed +1; i++) {
        //    optionsQte2.add(i);
       // }

                
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

    /*public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }*/

    /*public Boolean getIsAnnulation() {
        return isAnnulation;
    }

    public void setIsAnnulation(Boolean isAnnulation) {
        this.isAnnulation = isAnnulation;
    }*/

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    public void verfierDispo(){
        
        if(this.nbBilletsDispo<this.QTE){
            
        }
            CommunService.addWarn("ATTENTION !", "Le nombre de billets disponible est insuffisant");
    }
}
