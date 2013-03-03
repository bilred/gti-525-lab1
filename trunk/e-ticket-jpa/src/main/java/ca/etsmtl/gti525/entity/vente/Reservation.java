package ca.etsmtl.gti525.entity.vente;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity()
@Table(name="SHOW_RESERVATION")
public class Reservation  {
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private String idReservation;
           
        @Column(name = "IS_RESERVATION")
	private Boolean isReservation;
        
	@Column(name = "DATE_RESERVATION")
    @Temporal(javax.persistence.TemporalType.DATE)
        private Date dateReservation;
        
        @Column(name = "IS_CONFIRMATION_ACHAT")
	private Boolean isConfirmationAchat;	
	
        public String getIdReservation() {
        return idReservation;
        }

        public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
        }
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Boolean getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(Boolean isReservation) {
		this.isReservation = isReservation;
	}
	public Boolean getIsConfirmationAchat() {
		return isConfirmationAchat;
	}
	public void setIsConfirmationAchat(Boolean isConfirmationAchat) {
		this.isConfirmationAchat = isConfirmationAchat;
	}
	
	

}
