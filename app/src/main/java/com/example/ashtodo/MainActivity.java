package com.example.ashtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TodoAdapter.ItemClicked{


    FloatingActionButton fabAddTodo;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;
    ArrayList<TodoItems> todoItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fabAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.ashtodo.AddActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String time,title,desc,prio,date ;
        title = getIntent().getStringExtra("title");
        time = getIntent().getStringExtra("time");
        desc = getIntent().getStringExtra("subItems");
        prio = getIntent().getStringExtra("priority");
        date = getIntent().getStringExtra("date");


        todoItems = new ArrayList<TodoItems>();
        todoItems.add(new  TodoItems (title,prio,date,time,desc));

        recyclerView = findViewById(R.id.rvMainItems);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new TodoAdapter(MainActivity.this,todoItems);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();






    }

    void init()
    {
        fabAddTodo = findViewById(R.id.fabAddTodo);


    }

    @Override
    public void onItemClicked(int index) {
        //Intent intent = new Intent();
    }
}