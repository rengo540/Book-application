package com.example.bookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class sql extends SQLiteOpenHelper {

    static  final  String DBname = "books.dp" ;

    public sql(Context context) {
        super(context, DBname, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  card (img TEXT PRIMARY KEY ,title TEXT ,author1 TEXT,description TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS card ");
        onCreate(db);

    }


    public  boolean insert (String img,String title,String author,String description )
    {

        SQLiteDatabase db = this.getWritableDatabase() ;

        ContentValues contentValues = new ContentValues();
        contentValues.put("img" , img);
        contentValues.put("title",title);
        contentValues.put("author1", author);
        contentValues.put("description",description);


        int r = (int) db.insert("card" ,null , contentValues);
        if(r== -1 )
        {
            return  false ;
        }
        else
            return  true ;

    }


    public ArrayList<dataModel> get_data ()
    {

        ArrayList <dataModel> arrayList= new ArrayList() ;

        SQLiteDatabase db =this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT img,title,author1,description FROM card ",   null );

        while (res.moveToNext())
        {   String img = res.getString(0);
            String title = res.getString(1);
            String author1 = res.getString(2);
            String description = res.getString(3);






            arrayList.add( new dataModel(img,title,author1,description));

        }

        return  arrayList ;

    }





    public void Delete ()
    {
        SQLiteDatabase db =this.getWritableDatabase() ;
        db.delete("card",null,null);

    }


}
