package com.example.ashtodo;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder> {


    Context context;
    private  final ArrayList<SubItems>  subItems;
     ItemClicked myAcyivity;

    public TodoItemAdapter(Context context, ArrayList<SubItems> list)
    {
         //myAcyivity =  (ItemClicked) context;
        this.context = context;
        subItems = list;
    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_add_item_design,parent,false);
    return new  ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

         holder.tvItem.setText(subItems.get(position).getSubItems());

        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 subItems.set(position,null);
                // holder.tvItem.setVisibility(View.INVISIBLE);

            }
        });
    }


    @Override
    public int getItemCount() {
        return subItems.size();
    }

    public interface ItemClicked {
        void onItemClicked(int index); }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvItem;
        ImageView imgItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
            imgItem = itemView.findViewById(R.id.imgItem);
        }
    }
}
