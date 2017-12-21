package fr.ofuro.mydogtracker.models;

import java.io.Serializable;

/**
 * Created by ofuro on 23/11/2017.
 */

public class Dog implements Serializable{
    private int id;
    private String name;
    private int idMaster;
    private double latitude;
    private double longitude;


    // constructeur
//    public Dog(String name){
//        this.name = name;
//    }

    public Dog(int id, String name, int idMaster, double lat, double longit){
        this.id = id;
        this.name = name;
        this.idMaster = idMaster;
        this.latitude = lat;
        this.longitude = longit;
    }

    // getteur setteur
    public int getId () {return id;}

    public void setId (int id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdMaster () {return idMaster;}

    public void setIdMaster (int idMaster){this.idMaster = idMaster;}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '-' +
                "name='" + name +
                ", idMaster='" + idMaster + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
