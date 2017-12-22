package fr.ofuro.mydogtracker.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.models.Location;
import fr.ofuro.mydogtracker.tools.MyTools;

import static fr.ofuro.mydogtracker.activities.ManagerActivity.dogs;
import static fr.ofuro.mydogtracker.activities.ManagerActivity.locations;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ll_activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<Location> locationList = getLocsList();
        LatLng dogMarker = null;

        // seulement 5 marqueur pour les tests
        // ajoute le/les marqueurs et centre la vue de la map
        for(int i = 0; i<locationList.size(); i++) {

            // création des objets "gps"
            dogMarker = new LatLng(locationList.get(i).getLatitude(), locationList.get(i).getLongitude());

            // récupère certaines infos
            String dogName = dogs.get(locationList.get(i).getIdDog()-1).getName();
            String date = MyTools.convertDateToString(locationList.get(i).getDate());

            //ajout des marqueurs
            mMap.addMarker(new MarkerOptions().position(dogMarker).title(dogName + " : " + date));
        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(dogMarker));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(12));
    }

    //methode pour reccueillir toutes les dernière positions de chaque chien
    public List<Location> getLocsList(){

        //ATTENTION: methode uniquement applicable pour les tests sans webservice
        List<Location> locationList = new ArrayList<>();

        int nbDogs = dogs.size();
        int idLocation;
        boolean trouver;

        for (int idDog = 1; idDog<=nbDogs; idDog++){

            // on repars du début de la liste
            idLocation = 0;
            trouver = false;

            while(idLocation!=locations.size() && trouver == false){
                if(locations.get(idLocation).getIdDog() == idDog){
                    locationList.add(locations.get(idLocation));
                    trouver = true;
                }
                idLocation++;
            }
        }

        return locationList;
    }
}
