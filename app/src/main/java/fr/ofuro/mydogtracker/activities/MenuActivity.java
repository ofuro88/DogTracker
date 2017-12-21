package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import fr.ofuro.mydogtracker.R;

/**
 * Created by ofuro on 20/12/2017.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_menu);

        final Button btnModifier = findViewById(R.id.btn_menu_modifier);
        final Button btnAfficher = findViewById(R.id.btn_menu_afficher);
        final Button btnSupp = findViewById(R.id.btn_menu_supp);


        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MapsActivity.class);
                //TODO : intégrer les données du chien dans l'intent pour le marqueur
                startActivity(intent);
            }
        });

        btnModifier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MenuActivity.this, UpdateActivity.class);
                //TODO: gérer la vue Update pour les ajouts ou les modifications avec un TAG
                startActivity(intent);
            }
        });

        btnSupp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //TODO : gérer la suppression d'un chien
            }
        });

    }
}
