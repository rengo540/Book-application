package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OneItem extends AppCompatActivity {

    ImageView img ;
    TextView title , authar , description ;
    Button button;


    String descriptionData;

    String titleData;
    String imgData;
    String authorData;
    float ratingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_item);

        img=findViewById(R.id.bookImg);
        title=findViewById(R.id.bookTitle);
        authar =findViewById(R.id.bookAuthar);
        description=findViewById(R.id.bookDsc);
        button=findViewById(R.id.bookFav);



        //list 1
        imgData =getIntent().getStringExtra("img");
        titleData =getIntent().getStringExtra("title");
       authorData =getIntent().getStringExtra("authar");
       descriptionData =getIntent().getStringExtra("description");
       ratingData =getIntent().getFloatExtra("rating",0);


        Picasso.get().load( imgData ).fit().centerInside().into( img );
        title.setText(titleData);
        authar.setText(authorData);
        description.setText(descriptionData);




        sql data =new sql(this);
        Context context = getApplicationContext();
       button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context ,"add to favourite", Toast.LENGTH_SHORT).show();
              data.insert(imgData,titleData,authorData,descriptionData);
            }
        });


    }
}