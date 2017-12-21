package fr.ofuro.mydogtracker.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import fr.ofuro.mydogtracker.R;

/**
 * Created by ofuro on 27/10/2017.
 */

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ll_activity_register);

    }
}
