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

public class OneItemTime extends AppCompatActivity {

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


         imgData =getIntent().getStringExtra("img2");
        titleData =getIntent().getStringExtra("title2");
        authorData =getIntent().getStringExtra("authar2");
         descriptionData =getIntent().getStringExtra("description2");
        ratingData =getIntent().getFloatExtra("rating2",0);

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