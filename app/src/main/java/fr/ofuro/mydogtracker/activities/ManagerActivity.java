package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.adapter.RecyclerViewAdapter;
import fr.ofuro.mydogtracker.models.Dog;
import fr.ofuro.mydogtracker.models.Location;
import fr.ofuro.mydogtracker.tools.MyTools;

import static fr.ofuro.mydogtracker.activities.LoginActivity.initOk;


/**
 * Created by ofuro on 27/10/2017.
 */

public class ManagerActivity extends Activity {
//TODO: initialisation à vérifier, probleme de listing des dogs

    public static List<Dog> dogs = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();
    private static final int MANAGER_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_manager);

        //création de la liste de dog (si elle et vide, seulement au lancement de l'appli)
        if(initOk == false) {
            initData();
            initOk = true;
        }

        final RecyclerView recyclerView = findViewById(R.id.rv_main_dog);
        Button btnAdd = findViewById(R.id.btn_main_add);
        Button btnDisplayAll = findViewById(R.id.btn_main_displayall);

        //définit l'agencement des items,
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //puis créer un RecyclerViewAdapter, lui fournir notre liste de dogs.
        //cet adapter servira à remplir notre recyclerview
        final RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, dogs);

        // clic sur un item
        myAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idItem;
                int position = recyclerView.getChildLayoutPosition(v);
                idItem = dogs.get(position).getId();

                Intent intent = new Intent(ManagerActivity.this, MenuActivity.class);
                intent.putExtra("idItem", idItem);
                startActivityForResult(intent, MANAGER_ACTIVITY_CODE);
            }
        });

        // clic pour ajouter un nouveau chien (espion)
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, AddActivity.class);
                startActivityForResult(intent, MANAGER_ACTIVITY_CODE);
            }
        });

        // clic pour afficher tous les dogs sur un map
        btnDisplayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerActivity.this, MapsActivity.class);
                intent.putExtra("idItem", 0);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            Toast.makeText(this, "Votre chien est ajouté", Toast.LENGTH_SHORT).show();
        }
    }

    // update de la liste des chiens enregistrés
    public static void initData(){
//        boolean listeVideDog = false;
//        boolean listeVideLoc = false;

        // vide les listes
//        listeVideDog = dogs.removeAll(dogs);
//        listeVideLoc = locations.removeAll(locations);

        Date date = MyTools.convertStringToDate("19:00:00 01-12-2017");

        // bouchon de données pour test sans web service
        Dog dog1 = new Dog(1, "rex", 1);
        Dog dog2 = new Dog(2, "medor", 1);
        Dog dog3 = new Dog(3, "rox", 1);
        Dog dog4 = new Dog(4, "rookie", 1);
        Dog dog5 = new Dog(5, "choupette", 1);

        // exemple d'historique sur dog1
        Location loc1 = new Location(1, 48.00729242667558, -3.6947858333587646, date, 1);
        Location loc2 = new Location(2, 48.014065, -3.69735, date,1);
        Location loc3 = new Location(3, 48.022275,  -3.704731, date,1);
        Location loc4 = new Location(4, 48.017197, -3.699378, date,1);
        Location loc5 = new Location(5, 48.019462, -3.687994, date,1);

        // 1 position pour chaque dog
        Location loc6 = new Location(1, 48.00729242667558, -3.6947858333587646, date,2);
        Location loc7 = new Location(1, 48.00729242667558, -3.6947858333587646, date,3);
        Location loc8 = new Location(1, 48.00729242667558, -3.6947858333587646, date,4);
        Location loc9 = new Location(1, 48.00729242667558, -3.6947858333587646, date,5);

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
