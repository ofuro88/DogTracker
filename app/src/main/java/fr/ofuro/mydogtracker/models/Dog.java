package fr.ofuro.mydogtracker.models;

import java.io.Serializable;

/**
 * Created by ofuro on 23/11/2017.
 */

public class Dog implements Serializable{
    private int id;
    private String name;
    private int idMaster;


    // constructeur
//    public Dog(String name){
//        this.name = name;
//    }

    public Dog(int id, String name, int idMaster){
        this.id = id;
        this.name = name;
        this.idMaster = idMaster;
    }

    // getteur setteur
    public int getId () {return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdMaster () {return idMaster;}

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '-' +
                "name='" + name +
                ", idMaster='" + idMaster +
                '}';
    }
}
