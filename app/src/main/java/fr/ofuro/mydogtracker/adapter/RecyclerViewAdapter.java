package fr.ofuro.mydogtracker.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.viewholder.MyViewHolder;
import fr.ofuro.mydogtracker.models.Dog;

/**
 * Created by ofuro on 20/10/2017.
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<MyViewHolder> {
    private List<Dog> list;
    private Context context;
    private View.OnClickListener onClickListener;


    public RecyclerViewAdapter(Context context, List<Dog> items) {
        this.context = context;
        this.list = items;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        Dog myDog = list.get(position);
        viewHolder.bind(myDog);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder;
        myViewHolder = new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dog,viewGroup,false));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        return myViewHolder;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}