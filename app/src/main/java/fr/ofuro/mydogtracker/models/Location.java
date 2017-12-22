package fr.ofuro.mydogtracker.models;


public class Location {

    private int idLoc;
    private double latitude;
    private double longitude;
    private int idDog;

    public Location (int idLoc, double latitude, double longitude, int idDog){
        this.idLoc = idLoc;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idDog = idDog;
    }

    public int getIdLoc(){
        return idLoc;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return  longitude;
    }

    public int getIdDog(){
        return idDog;
    }
}
