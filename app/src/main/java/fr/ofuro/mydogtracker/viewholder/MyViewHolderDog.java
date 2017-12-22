package fr.ofuro.mydogtracker.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.ofuro.mydogtracker.models.Dog;
import fr.ofuro.mydogtracker.R;


public class MyViewHolderDog extends RecyclerView.ViewHolder{

    public TextView tvDog;

    //itemView est la vue correspondante à 1a carte
    public MyViewHolderDog(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        tvDog = itemView.findViewById(R.id.tv_dog_manager);
    }

    //puis ajouter une fonction pour remplir la carte en fonction d'un PokemonCard
    public void bind(Dog myDog){
        tvDog.setText(myDog.getName());
    }
}