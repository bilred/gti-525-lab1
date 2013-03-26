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
@Table(name="VENTE_CARTE_CREDIT")
public class CarteCredit extends EntityBaseLogs  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NOM_DETENTEUR_CARTE")
    private String nomDetenteurCarte; //Nom du deteneur de la cart (pas besoin de mettre type Client => relation Unit drectionnel)
    @Column(name="TYPE_CARTE_CREDIT")
    private String typeCarteCredit;
    
//    @Size(max=10, message="La taille du NUM_CARTE_CREDIT doit etre entre au max de 10.")
//    @NotNull(message="Champ NUM_CARTE_CREDIT ne doit pas etre Vide")
    @Column(name="NUM_CARTE_CREDIT")
    private String numCarteCredit;
    
//    @Past(message="Votre date supérieur a la date Actuelle")
//    @NotNull(message="Champ DATE_EXPIRATION ne doit pas etre Vide")
    @Column(name="DATE_EXPIRATION")
    @Temporal(TemporalType.DATE)
    private Date dateExpiration;
    
//    @Size(max=4, message="La taille du NUM_SECURITE doit etre entre au max de 4.")
//    @NotNull(message="Champ NUM_SECURITE ne doit pas etre Vide")    
    @Column(name="NUM_SECURITE")
    private String numSecurite; //G�n�ralement les 5 d�rnier chifre de la carte.
    
    @Column(name="DATE_TRANSACTION")
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
    
    
    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getNomDetenteurCarte() {
        return nomDetenteurCarte;
    }

    public void setNomDetenteurCarte(String nomDetenteurCarte) {
        this.nomDetenteurCarte = nomDetenteurCarte;
    }



    public String getTypeCarteCredit() {
        return typeCarteCredit;
    }

    public void setTypeCarteCredit(String typeCarteCredit) {
        this.typeCarteCredit = typeCarteCredit;
    }

    public String getNumCarteCredit() {
        return numCarteCredit;
    }

    public void setNumCarteCredit(String numCarteCredit) {
        this.numCarteCredit = numCarteCredit;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getNumSecurite() {
        return numSecurite;
    }

    public void setNumSecurite(String numSecurite) {
        this.numSecurite = numSecurite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
