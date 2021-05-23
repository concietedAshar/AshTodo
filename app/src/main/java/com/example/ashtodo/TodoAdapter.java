package com.example.ashtodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;

 import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {


    ItemClicked myAcyivity;
    Context context;
    private  final  ArrayList<TodoItems> todoItems;


    public TodoAdapter(Context context, ArrayList<TodoItems> list)
    {
        myAcyivity = (ItemClicked) context;
        this.context = context;
        todoItems = list;
    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_main_screen_single_item,parent,false);
        return new  ViewHolder(v) ;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public interface ItemClicked {
        void onItemClicked(int index);

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
