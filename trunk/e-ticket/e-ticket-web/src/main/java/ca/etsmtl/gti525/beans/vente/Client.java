package ca.etsmtl.gti525.beans.vente;

import ca.etsmtl.gti525.beans.presentation.Billet;
import java.util.List;

public class Client {

    private String nom;
    private String prenom;
    private String nomCivique;
    private String mail;
    private String phone;
    private Adresse adresse;
    private CarteCredit carteCredit;
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
}