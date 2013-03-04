package ca.etsmtl.gti525.entity.vente;

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

@Entity
@Table(name = "VENTE_CLIENT")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NOM")
    private String nom;  
    @Column(name="PRENOM")
    private String prenom;
    @Column(name="NOM_CIVIQUE")
    private String nomCivique;
    @Column(name="MAIL")
    private String mail;
    @Column(name="PHONE")
    private String phone;
    
    @OneToOne
    private Adresse adresseClient;
    @OneToOne
    private CarteCredit carteCredit;
    

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

    public Adresse getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(Adresse adresseClient) {
        this.adresseClient = adresseClient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
