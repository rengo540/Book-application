package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1 ,button2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.browseBooks);
        button2 = findViewById(R.id.browseFav);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseBooks();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseFav();
            }
        });

    }


    public void browseBooks () {
        Intent intent =new Intent(this , books.class);
        startActivity(intent);

    }

    public void browseFav (){
        Intent intent =new Intent (this , favourite.class);
        startActivity(intent);
    }

}