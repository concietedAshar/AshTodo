package com.example.ashtodo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
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

        holder.tvTitle.setText(todoItems.get(position).getTitle());
        holder.tvDesc.setText(todoItems.get(position).getItemsConcatenate());
        holder.rbTimeSet.setText(todoItems.get(position).getTime());
        String prio = todoItems.get(position).getPriority();

        if(prio.equals("H"))
       {
           //Drawable res =  holder.imgPriorityTag.getResources().getDrawable(R.drawable.red);
           holder.imgPriorityTag.setImageResource(R.drawable.red);

       }
        if(prio.equals("M"))
        {
           //Drawable res =  holder.imgPriorityTag.getResources().getDrawable(R.drawable.red);
           holder.imgPriorityTag.setImageResource(R.drawable.green);

       }
        if(prio.equals("L"))
        {
           //Drawable res =  holder.imgPriorityTag.getResources().getDrawable(R.drawable.red);
           holder.imgPriorityTag.setImageResource(R.drawable.yellow);

        }

        holder.rbTimeSet.setText(todoItems.get(position).getTime());

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
        TextView tvTitle,tvDesc;
        ImageView imgPriorityTag;
        RadioButton rbTimeSet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc =itemView.findViewById(R.id.tvDesc);
            imgPriorityTag =itemView.findViewById(R.id.imgPriorityTag);
            rbTimeSet = itemView.findViewById(R.id.rbTimeSet);
        }
    }
}
