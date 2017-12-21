package fr.ofuro.mydogtracker.models;

import java.io.Serializable;

/**
 * Created by ofuro on 23/11/2017.
 */

public class Dog implements Serializable{
    private String name;
    private double latitude;
    private double longitude;


    // constructeur
    public Dog(String name){
        this.name = name;
    }

    public Dog(String name, double lat, double longit){
        this.name = name;
        this.latitude = lat;
        this.longitude = longit;
    }

    // getteur setteur
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
