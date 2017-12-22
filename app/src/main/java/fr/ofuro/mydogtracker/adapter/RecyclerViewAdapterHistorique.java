package fr.ofuro.mydogtracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.models.Dog;
import fr.ofuro.mydogtracker.models.Location;
import fr.ofuro.mydogtracker.viewholder.MyViewHolderDog;
import fr.ofuro.mydogtracker.viewholder.MyViewHolderHistorique;

/**
 * Created by ofuro on 20/10/2017.
 */
public class RecyclerViewAdapterHistorique<T> extends RecyclerView.Adapter<MyViewHolderHistorique> {
    private List<Location> list;
    private Context context;
    private View.OnClickListener onClickListener;


    public RecyclerViewAdapterHistorique(Context context, List<Location> items) {
        this.context = context;
        this.list = items;
    }

    @Override
    public void onBindViewHolder(MyViewHolderHistorique viewHolder, int position) {
        Location myLoc = list.get(position);
        viewHolder.bind(myLoc);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolderHistorique onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolderHistorique myViewHolderHistorique;
        myViewHolderHistorique = new MyViewHolderHistorique(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_historique,viewGroup,false));

        myViewHolderHistorique.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        return myViewHolderHistorique;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}