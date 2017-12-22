package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.models.Dog;

public class AddActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_add);

        Button btnAdd = findViewById(R.id.btn_add_add);
        final EditText edName = findViewById(R.id.ed_add_name);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ajout du nouveau dog dans la liste
                int id;
                String name;

                id = ManagerActivity.dogs.size() +1;
                name = edName.getText().toString();

                // pour l'instant idMaster reste à 1 (pas de webservice)
                ManagerActivity.dogs.add(new Dog(id, name, 1));

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
