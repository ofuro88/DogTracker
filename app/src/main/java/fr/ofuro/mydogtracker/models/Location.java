package fr.ofuro.mydogtracker.models;


import java.util.Date;

public class Location {

    private int idLoc;
    private double latitude;
    private double longitude;
    private Date date;
    private int idDog;

    public Location (int idLoc, double latitude, double longitude, Date date, int idDog){
        this.idLoc = idLoc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.idDog = idDog;
    }

    public int getIdLoc(){
        return this.idLoc;
    }

    public double getLatitude(){ return this.latitude; }

    public double getLongitude(){
        return  this.longitude;
    }

    public Date getDate(){ return this.date; }

    public int getIdDog(){
        return this.idDog;
    }
}
