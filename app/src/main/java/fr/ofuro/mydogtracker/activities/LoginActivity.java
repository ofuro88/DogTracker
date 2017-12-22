package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import fr.ofuro.mydogtracker.R;

/**
 * Created by ofuro on 27/10/2017.
 */

public class LoginActivity extends Activity implements View.OnClickListener{

    private Button btn_sign_in;
    private Button btn_register;
    public static boolean initOk = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ll_activity_login);

        // récupération des btn
        btn_sign_in = findViewById(R.id.btn_login_signin);
        btn_register = findViewById(R.id.btn_login_register);

        // assignation des listeners aux btn
        btn_sign_in.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        //choix de la page a afficher
        if(v == findViewById(R.id.btn_login_signin)){
            intent = new Intent(this, ManagerActivity.class);
        }
        else
        {
            intent = new Intent(this, RegisterActivity.class);
        }

        startActivity(intent);
    }
}
