package ca.etsmtl.gti525.entity.vente;

import ca.etsmtl.gti525.entity.audit.EntityBaseLogs;
import ca.etsmtl.gti525.entity.presentation.Billet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name = "VENTE_CLIENT")
public class Client extends EntityBaseLogs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
//    @Size(min=3, max=32, message="La taille du Nom doit etre entre 3 et 32.")
//    @NotNull(message="Champ Nom ne doit pas etre Vide")
    @Column(name="NOM")
    private String nom;
    
//    @Size(min=3, max=32, message="La taille du Prenom doit etre entre 3 et 32.")
//    @NotNull(message="Champ Prenom ne doit pas etre Vide")
    @Column(name="PRENOM")
    private String prenom;
    @Column(name="NOM_CIVIQUE")
    private String nomCivique;
    
//    @Size(min=3, max=32, message="La taille du Mail doit etre entre 3 et 32.")
//    @Email(message="Votre mail est invalide")
    @Column(name="MAIL")
    private String mail;
    @Column(name="PHONE")
    private String phone;
    
    @OneToOne(cascade= CascadeType.PERSIST)
    private Adresse adresse;
    
    @OneToOne(cascade= CascadeType.PERSIST) // => transfomer en beans
    private CarteCredit carteCredit;
    

    @OneToMany(cascade= CascadeType.PERSIST)
    private List<Billet> billets;   //c'est la seul interface avec le module Presentation de l'Application

    
    public String getMail() {
        if(mail == null) mail = new String();
        return mail;
    }

    public void setMail(String mail) {
        if(mail == null) mail = new String();
        this.mail = mail;
    }

    public String getPhone() {
        if(phone == null) phone = new String();
        return phone;
    }

    public void setPhone(String phone) {
        if(phone == null) phone = new String();
        this.phone = phone;
    }

    public CarteCredit getCarteCredit() {
        if(carteCredit == null) carteCredit = new CarteCredit();
        return carteCredit;
    }

    public void setCarteCredit(CarteCredit carteCredit) {
        if(carteCredit == null) carteCredit = new CarteCredit();
        this.carteCredit = carteCredit;
    }

    public String getNom() {
        if(nom == null) nom = new String();
        return nom;
    }

    public void setNom(String nom) {
        if(nom == null) nom = new String();
        this.nom = nom;
    }

    public List<Billet> getBillets() {
        if(billets == null) billets = new ArrayList<Billet>();
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        if(billets == null) billets = new ArrayList<Billet>();
        this.billets = billets;
    }

    public String getPrenom() {
        if(prenom == null) prenom = new String();
        return prenom;
    }

    public void setPrenom(String prenom) {
        if(prenom == null) prenom = new String();
        this.prenom = prenom;
    }

    public String getNomCivique() {
        if(nomCivique == null) nomCivique = new String();
        return nomCivique;
    }

    public void setNomCivique(String nomCivique) {
        if(nomCivique == null) nomCivique = new String();
        this.nomCivique = nomCivique;
    }

    public Adresse getAdresse() {
        if(adresse == null) adresse = new Adresse();
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        if(adresse == null) adresse = new Adresse();
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
