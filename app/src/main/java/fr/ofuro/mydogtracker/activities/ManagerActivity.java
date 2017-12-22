package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.adapter.RecyclerViewAdapter;
import fr.ofuro.mydogtracker.models.Dog;
import fr.ofuro.mydogtracker.models.Location;


/**
 * Created by ofuro on 27/10/2017.
 */

public class ManagerActivity extends Activity {

    public static List<Dog> dogs = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_manager);

        //création de la liste de dog
        addDogs();

        RecyclerView recyclerView = findViewById(R.id.rv_dog_main);
        Button btnAdd = findViewById(R.id.btn_ajouter_main);
        Button btnDisplayAll = findViewById(R.id.btn_main_displayall);

        //définit l'agencement des items,
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //puis créer un RecyclerViewAdapter, lui fournir notre liste de dogs.
        //cet adapter servira à remplir notre recyclerview
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, dogs);

        //TODO : intégrer les données du/des chien dans l'intent des listeners
        // clic sur un item
        myAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        // clic pour ajouter un nouveau chien (espion)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, AddActivity.class);
                //TODO : créer la vue de l'activity Ajouter
                startActivity(intent);
            }
        });

        // clic pour afficher tous les dogs sur un map
        btnDisplayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(myAdapter);
    }

    // update de la liste des chiens enregistrés
    public void addDogs(){
        boolean listeVideDog = false;
        boolean listeVideLoc = false;

        // vide les listes
        listeVideDog = dogs.removeAll(dogs);
        listeVideLoc = locations.removeAll(locations);


        // bouchon de données pour test sans web service
        Dog dog1 = new Dog(1, "rex", 1);
        Dog dog2 = new Dog(2, "medor", 1);
        Dog dog3 = new Dog(3, "rox", 1);
        Dog dog4 = new Dog(4, "rookie", 1);
        Dog dog5 = new Dog(5, "choupette", 1);

        // exemple d'historique sur dog1
        Location loc1 = new Location(1, 48.00729242667558, -3.6947858333587646, 1);
        Location loc2 = new Location(2, 48.014065, -3.69735, 1);
        Location loc3 = new Location(3, 48.022275,  -3.704731, 1);
        Location loc4 = new Location(4, 48.017197, -3.699378, 1);
        Location loc5 = new Location(5, 48.019462, -3.687994, 1);

        // 1 position pour chaque dog
        Location loc6 = new Location(1, 48.00729242667558, -3.6947858333587646, 2);
        Location loc7 = new Location(1, 48.00729242667558, -3.6947858333587646, 3);
        Location loc8 = new Location(1, 48.00729242667558, -3.6947858333587646, 4);
        Location loc9 = new Location(1, 48.00729242667558, -3.6947858333587646, 5);

        // ajout aux listes
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);

        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        locations.add(loc5);
        locations.add(loc6);
        locations.add(loc7);
        locations.add(loc8);
        locations.add(loc9);
    }
}
