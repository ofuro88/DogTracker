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


/**
 * Created by ofuro on 27/10/2017.
 */

public class ManagerActivity extends Activity {

    public static List<Dog> dogs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_manager);

        //création de la liste de dog
        addDogs();

        final RecyclerView recyclerView = findViewById(R.id.rv_dog_main);
        final Button btnAjouter = findViewById(R.id.btn_ajouter_main);

        //définit l'agencement des items,
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //puis créer un RecyclerViewAdapter, lui fournir notre liste de dogs.
        //cet adapter servira à remplir notre recyclerview
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, dogs);

        myAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, MenuActivity.class);
                //TODO : intégrer les données du chien dans l'intent
                startActivity(intent);
            }
        });

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, UpdateActivity.class);
                //TODO : créer la vue de l'activity Ajouter
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(myAdapter);
    }

    // update de la liste des chiens enregistrés
    public void addDogs(){
        boolean listeVide = false;

        // vide la liste
        listeVide = dogs.removeAll(dogs);


        // bouchon de données pour test sans web service
        Dog dog1 = new Dog(1, "rex", 1, 48.00729242667558, -3.6947858333587646);
        Dog dog2 = new Dog(2, "medor", 1, 48.014065, -3.69735);
        Dog dog3 = new Dog(3, "rox", 1, 48.022275,  -3.704731);
        Dog dog4 = new Dog(4, "rookie", 1, 48.017197, -3.699378);
        Dog dog5 = new Dog(5, "choupette", 1, 48.019462, -3.687994);

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
    }
}
