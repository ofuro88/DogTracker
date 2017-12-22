package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.models.Location;

import static fr.ofuro.mydogtracker.activities.ManagerActivity.dogs;
import static fr.ofuro.mydogtracker.activities.ManagerActivity.locations;

/**
 * Created by ofuro on 20/12/2017.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_menu);

        final Button btnHistorique = findViewById(R.id.btn_menu_historique);
        final Button btnAfficher = findViewById(R.id.btn_menu_afficher);
        final Button btnSupp = findViewById(R.id.btn_menu_supp);

        //récupère l'id de l'item cliqué
        final int idItem = getIntent().getExtras().getInt("idItem");

        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MapsActivity.class);
                intent.putExtra("idItem", idItem);
                startActivity(intent);
            }
        });

        btnHistorique.setOnClickListener(new View.OnClickListener(){
            //TODO: crash, n'affiche pas l'activity
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MenuActivity.this, Historique.class);
                intent.putExtra("idItem", idItem);
                startActivity(intent);
            }
        });

        btnSupp.setOnClickListener(new View.OnClickListener(){
            //TODO: crash, probleme de suppression à régler
            @Override
            public void onClick(View v){
                // supprimer historique
                for (Location loc:locations) {
                    if (loc.getIdDog()==idItem){
                        locations.remove(loc);
                    }
                }

                // supprime le chien de la liste
                dogs.remove(dogs.get(idItem));

                setResult(RESULT_OK);
                finish();
            }
        });

    }
}
