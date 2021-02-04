package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class favourite extends AppCompatActivity implements myAdapter.RecyclerViewClickListener  {

    RecyclerView favList;
    myAdapter adapter;
    private myAdapter.RecyclerViewClickListener listener;
    Button removeAll ;

ArrayList<dataModel> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);


        sql data =new sql(this);
         list =data.get_data();

        setOnClickLisener();

        favList =findViewById(R.id.favList);
        adapter=new myAdapter(list,listener) ;
        favList.setAdapter(adapter);
        favList.setLayoutManager( new LinearLayoutManager(this));


        removeAll=findViewById(R.id.btnRemoveAll);

        removeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.Delete();

            }
        });




    }

    private void setOnClickLisener() {
        listener =new myAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (favList == view.getParent()) {

                   // ArrayList<String> listt = list.get(position).getAuthar();

                    Intent intent = new Intent(getApplicationContext(), OneItemFav.class);
                    intent.putExtra("img", list.get(position).getImg());
                    intent.putExtra("title", list.get(position).getName());
                    intent.putExtra("authar", list.get(position).getAuthar());
                    intent.putExtra("description", list.get(position).getDescription());
                    startActivity(intent);
                }
            }
        };
}

    @Override
    public void onClick(View view, int position) {

    }
}