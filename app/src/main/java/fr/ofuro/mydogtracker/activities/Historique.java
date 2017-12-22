package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.adapter.RecyclerViewAdapter;
import fr.ofuro.mydogtracker.adapter.RecyclerViewAdapterHistorique;
import fr.ofuro.mydogtracker.models.Location;

import static fr.ofuro.mydogtracker.activities.ManagerActivity.*;

/**
 * Created by ofuro on 22/12/2017.
 */

public class Historique extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_historique);

        //génère la liste des positions gps à lister
        final List<Location> locationList = locToDisplayed();

        final RecyclerView recyclerView = findViewById(R.id.rv_historique);

        //définit l'agencement des items,
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //puis créer un RecyclerViewAdapter, lui fournir notre liste de dogs.
        //cet adapter servira à remplir notre recyclerview
        final RecyclerViewAdapterHistorique myAdapter = new RecyclerViewAdapterHistorique(this, locationList);

        // clic sur un item
        myAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idItem;
                int position = recyclerView.getChildLayoutPosition(v);
                idItem = locationList.get(position).getIdLoc();

                Intent intent = new Intent(Historique.this, MapsActivity.class);
                intent.putExtra("idItem", idItem);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(myAdapter);
    }

    // génère une liste des positions qui sont à afficher
    public List<Location> locToDisplayed(){
        List<Location> locs = new ArrayList<>();

        for (Location loc: locations ) {
            if(loc.getIdDog() == getIntent().getExtras().getInt("idItem")){
                locs.add(loc);
            }
        }

        return locs;
    }
}
