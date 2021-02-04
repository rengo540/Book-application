package com.example.bookapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class myPresenter {

    private static final String url ="https://run.mocky.io/v3/b5adf54a-9e8a-47eb-a055-7ba3249aae9c";




    BookView bookview;

    public myPresenter(BookView bookview) {
        this.bookview = bookview;
    }


    public ArrayList<dataModel> getLifeDataFromApi (RequestQueue requestQueue, myAdapter adapter1, myAdapter adapter2, Context context)
    {
            ArrayList<dataModel> list=new ArrayList<>();


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


                    /*    String description =volumeInfo.getString("description");
                        String publisher =volumeInfo.getString("publisher");
                        String publishedDate =volumeInfo.getString("publishedDate");
                        int pageCount =volumeInfo.getInt("pageCount");
*/
                        JSONObject imageLinks=volumeInfo.getJSONObject("imageLinks");
                        String img =imageLinks.getString("smallThumbnail");


                        // String img, String name, String[] authar, String description, String publisher, String publishedDate, int pageCount)

                        // ddd[i]= new dataModel(img,title ,auther,description,publisher,publishedDate,pageCount);

                      //  list.add(new dataModel(img,title));

                        adapter1.notifyDataSetChanged();
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

return list;
    }










    public ArrayList<dataModel> getLkkllifeDataFromApi (RequestQueue requestQueue, myAdapter adapter1, myAdapter adapter2, Context context)
    {
        ArrayList<dataModel> list = new ArrayList<>();


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

                      /*  JSONArray authors =volumeInfo.getJSONArray("authors");
                       String []auther =new String[authors.length()];
                        for(int j=0;j<authors.length();j++)
                        {
                             auther [j] =authors.getString(j);
                        }*/

                        String description =volumeInfo.getString("description");
                        String publisher =volumeInfo.getString("publisher");
                        String publishedDate =volumeInfo.getString("publishedDate");
                        int pageCount =volumeInfo.getInt("pageCount");

                        JSONObject imageLinks=volumeInfo.getJSONObject("imageLinks");
                        String img =imageLinks.getString("smallThumbnail");


                       // String img, String name, String[] authar, String description, String publisher, String publishedDate, int pageCount)

                       // ddd[i]= new dataModel(img,title ,auther,description,publisher,publishedDate,pageCount);

                     //   list.add(new dataModel(img,title,description,publisher,publishedDate,pageCount));


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

        return list;
    }


    public void getLifeData (RequestQueue requestQueue, myAdapter adapter1, myAdapter adapter2, Context context)
    {
        //arr=new JSONArray();
        ArrayList<dataModel> list =getLifeDataFromApi(requestQueue,adapter1,adapter2,context);

        ArrayList<String> img = null;
        ArrayList<String> name = null;


        for(int i=0 ; i<list.size() ; i++) {
            img.add(list.get(i).getImg());
            name.add(list.get(i).getName());


        }

        bookview.onGetLifeBooks(img,name);
    }

    }



