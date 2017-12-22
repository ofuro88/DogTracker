package fr.ofuro.mydogtracker.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.models.Dog;
import fr.ofuro.mydogtracker.models.Location;
import fr.ofuro.mydogtracker.tools.MyTools;


public class MyViewHolderHistorique extends RecyclerView.ViewHolder{

    public TextView tvLat;
    public TextView tvLong;
    public TextView tvDate;

    //itemView est la vue correspondante à 1a carte
    public MyViewHolderHistorique(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        tvLat = itemView.findViewById(R.id.tv_latitude);
        tvLat = itemView.findViewById(R.id.tv_longitude);
        tvDate = itemView.findViewById(R.id.tv_date);
    }

    //puis ajouter une fonction pour remplir la carte en fonction d'un PokemonCard
    public void bind(Location myLoc){

        tvLat.setText((int) myLoc.getLatitude());
        tvLong.setText((int) myLoc.getLongitude());
        tvDate.setText(MyTools.convertDateToString(myLoc.getDate()));
    }
}