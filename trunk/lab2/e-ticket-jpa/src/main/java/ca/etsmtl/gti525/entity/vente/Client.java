package ca.etsmtl.gti525.entity.vente;

import ca.etsmtl.gti525.commun.Email;
import ca.etsmtl.gti525.entity.audit.EntityBaseLogs;
import ca.etsmtl.gti525.entity.presentation.Billet;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VENTE_CLIENT")
public class Client extends EntityBaseLogs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
    @Size(min=3, max=32, message="La taille du Nom doit etre entre 3 et 32.")
    @NotNull(message="Champ Nom ne doit pas etre Vide")
    @Column(name="NOM")
    private String nom = new String();
    
    @Size(min=3, max=32, message="La taille du Prenom doit etre entre 3 et 32.")
    @NotNull(message="Champ Prenom ne doit pas etre Vide")
    @Column(name="PRENOM")
    private String prenom = new String();
    @Column(name="NOM_CIVIQUE")
    private String nomCivique = new String();
    
    @Size(min=3, max=32, message="La taille du Mail doit etre entre 3 et 32.")
    @Email(message="Votre mail est invalide")
    @Column(name="MAIL")
    private String mail = new String();
    @Column(name="PHONE")
    private String phone = new String();
    
    @OneToOne
    private Adresse adresse = new Adresse();
    @OneToOne
    private CarteCredit carteCredit = new CarteCredit();
    

    @OneToMany
    private List<Billet> billets;   //c'est la seul interface avec le module Presentation de l'Application

    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CarteCredit getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        this.carteCredit = carteCredit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomCivique() {
        return nomCivique;
    }

    public void setNomCivique(String nomCivique) {
        this.nomCivique = nomCivique;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        if(id==null) id= new Long(0);
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
