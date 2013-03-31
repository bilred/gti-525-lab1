package ca.etsmtl.gti525.entity.vente;

import ca.etsmtl.gti525.entity.audit.EntityBaseLogs;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VENTE_RESERVATION")
public class Reservation extends EntityBaseLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idReservation;
    @Column(name = "DATE_RESERVATION")
    @Temporal(TemporalType.DATE)
    private Date dateReservation;
//    @Column(name = "IS_RESERVATION")
//    private Boolean isReservation;    
//    @Column(name = "IS_CONFIRMATION_ACHAT")
//    private Boolean isConfirmationAchat;

    
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

//    public Boolean getIsReservation() {
//        return isReservation;
//    }
//
//    public void setIsReservation(Boolean isReservation) {
//        this.isReservation = isReservation;
//    }
//
//    public Boolean getIsConfirmationAchat() {
//        return isConfirmationAchat;
//    }
//
//    public void setIsConfirmationAchat(Boolean isConfirmationAchat) {
//        this.isConfirmationAchat = isConfirmationAchat;
//    }
}
