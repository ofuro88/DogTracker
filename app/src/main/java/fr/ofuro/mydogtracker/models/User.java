package fr.ofuro.mydogtracker.models;

public class User {

    public int id;
    public String nom;
    public String prenom;
    public String login;
    public String mdp;

    public User(int id, String nom, String prenom, String login, String mdp){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }

    public User(String nom, String prenom, String login, String mdp){
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
    }


    public int getId(){
        return this.id;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.prenom;
    }

    public void setMdp(String mdp){
        this.mdp = mdp;
    }

    public String getMdp(){
        return this.mdp;
    }
}
