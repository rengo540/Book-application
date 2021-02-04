package com.example.bookapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class OneItemFav extends AppCompatActivity {

    ImageView img ;
    TextView title , authar , description ;

    String descriptionData;

    String titleData;
    String imgData;
    String authorData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_item);

        img=findViewById(R.id.bookImg);
        title=findViewById(R.id.bookTitle);
        authar =findViewById(R.id.bookAuthar);
        description=findViewById(R.id.bookDsc);


        //list 1
        imgData =getIntent().getStringExtra("img");
        titleData =getIntent().getStringExtra("title");
        authorData =getIntent().getStringExtra("authar");
        descriptionData =getIntent().getStringExtra("description");


        Picasso.get().load( imgData ).fit().centerInside().into( img );
        title.setText(titleData);
        authar.setText(authorData);
        description.setText(descriptionData);



    }
}
