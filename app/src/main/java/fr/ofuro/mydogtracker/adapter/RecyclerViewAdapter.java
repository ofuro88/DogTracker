package fr.ofuro.mydogtracker.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import java.util.List;

import fr.ofuro.mydogtracker.R;
import fr.ofuro.mydogtracker.viewholder.MyViewHolderDog;
import fr.ofuro.mydogtracker.models.Dog;

/**
 * Created by ofuro on 20/10/2017.
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<MyViewHolderDog> {
    private List<Dog> list;
    private Context context;
    private View.OnClickListener onClickListener;


    public RecyclerViewAdapter(Context context, List<Dog> items) {
        this.context = context;
        this.list = items;
    }

    @Override
    public void onBindViewHolder(MyViewHolderDog viewHolder, int position) {
        Dog myDog = list.get(position);
        viewHolder.bind(myDog);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolderDog onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolderDog myViewHolderDog;
        myViewHolderDog = new MyViewHolderDog(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dog,viewGroup,false));

        myViewHolderDog.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(view);
            }
        });
        return myViewHolderDog;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}