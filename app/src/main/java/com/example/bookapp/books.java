package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class books extends AppCompatActivity implements myAdapter.RecyclerViewClickListener {



    private static final String url ="https://run.mocky.io/v3/b5adf54a-9e8a-47eb-a055-7ba3249aae9c",
            url1="https://run.mocky.io/v3/e36cc68e-5e78-4f11-950b-fc6570bc5d03";
    RecyclerView recyclerView1 , recyclerView2   ;
    public myAdapter adapter1, adapter2  ;
    RequestQueue requestQueue;
    ArrayList<dataModel> booksOfLife , booksOfTime;
    myPresenter presenter;
    private myAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        requestQueue = Volley.newRequestQueue(this);

        booksOfLife = new ArrayList<>();
        booksOfTime=new ArrayList<>();

        setOnClickLisener();

        getLifeDataFromApi(this);
        //life books list
        recyclerView1 =findViewById(R.id.recyclerLifeBooks);
        adapter1 =new myAdapter(booksOfLife,listener) ;
        recyclerView1.setAdapter(adapter1);
        recyclerView1.setLayoutManager( new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));


        getTimeDataFromApi(this);
        //time books list
        recyclerView2=findViewById(R.id.recyclerLoveBooks);
        adapter2 =new myAdapter(booksOfTime,listener) ;
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

    }

    private void setOnClickLisener() {
        listener =new myAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent;
        if(recyclerView1==view.getParent()) {

//ArrayList<String> list=booksOfLife.get(position).getAuthar();

             intent = new Intent(getApplicationContext(), OneItem.class);
            intent.putExtra("img", booksOfLife.get(position).getImg());
            intent.putExtra("title", booksOfLife.get(position).getName());
            intent.putExtra("authar" , booksOfLife.get(position).getAuthar() );
            intent.putExtra("description", booksOfLife.get(position).getDescription());
            intent.putExtra("rating",booksOfLife.get(position).getRating());
            startActivity(intent);
        }
else if(recyclerView2==view.getParent()) {

           // ArrayList<String> list2=booksOfTime.get(position).getAuthar();

             intent = new Intent(getApplicationContext(), OneItemTime.class);
            intent.putExtra("img2", booksOfTime.get(position).getImg());
            intent.putExtra("title2", booksOfTime.get(position).getName());
            intent.putExtra("authar2", booksOfTime.get(position).getAuthar());
            intent.putExtra("description2", booksOfTime.get(position).getDescription());
            intent.putExtra("rating2",booksOfTime.get(position).getRating());
            startActivity(intent);
        }
            }
        };
    }


    public void  getLifeDataFromApi (Context context)
    {
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arr = response.getJSONArray("items");

                    for(int i=0 ;i<arr.length();i++)
                    {
                        JSONObject object = arr.getJSONObject(i);

                        JSONObject volumeInfo =object.getJSONObject("volumeInfo");
                        String title =volumeInfo.getString("title");

                        String publisher =volumeInfo.getString("publisher");

                        String description=null;

                        if(i != 1)
                        {
                             description =volumeInfo.getString("description");
                        }



                        JSONObject imageLinks=volumeInfo.getJSONObject("imageLinks");
                        String img =imageLinks.getString("smallThumbnail");


                        float rating;
                        if( volumeInfo.has("averageRating"))
                        {
                            rating  =volumeInfo.getLong("averageRating");
                        }
                        else
                        {
                            rating=0;
                        }

                          JSONArray authors =volumeInfo.getJSONArray("authors");
                       // ArrayList<String> auther =new ArrayList<>();
                        //for(int j=0;j<authors.length();j++)
                       // {
                            // auther.add(authors.getString(0));
                       // }

                        String author =authors.getString(0);


                        booksOfLife.add(new dataModel(img,title,author,description,rating));




                      //  booksOfLife.add(i, new dataModel(img,title,auther).setDescription(description));

                        adapter1.notifyDataSetChanged();



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context ,error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(request);

    }



    public void  getTimeDataFromApi (Context context)
    {
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arr = response.getJSONArray("items");

                    for(int i=0 ;i<arr.length();i++)
                    {
                        JSONObject object = arr.getJSONObject(i);

                        JSONObject volumeInfo =object.getJSONObject("volumeInfo");
                        String title =volumeInfo.getString("title");

                        String publisher =volumeInfo.getString("publisher");

                        String description=null;

                        if(i != 1)
                        {
                            description =volumeInfo.getString("description");
                        }


                        JSONObject imageLinks=volumeInfo.getJSONObject("imageLinks");
                        String img =imageLinks.getString("smallThumbnail");

                        long rating;
                       if( volumeInfo.has("averageRating"))
                       {
                          rating  =volumeInfo.getLong("averageRating");
                       }
                       else
                       {
                          rating=0;
                       }


                        JSONArray authors =volumeInfo.getJSONArray("authors");
                      /*  ArrayList<String> auther2 =new ArrayList<>();
                       for(int j=0;j<authors.length();j++)
                        {
                            auther2.add(authors.getString(j));
                        }*/

                        String author =authors.getString(0);

                        booksOfTime.add(new dataModel( img ,title ,author,description,rating));


                        adapter2.notifyDataSetChanged();


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context ,error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(request);
    }


    @Override
    public void onClick(View view, int position) { }




}