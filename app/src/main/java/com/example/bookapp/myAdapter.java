package com.example.bookapp;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.bookVH> {

    ArrayList<dataModel> books ;
    RecyclerViewClickListener listener;


    public myAdapter(ArrayList<dataModel> books,RecyclerViewClickListener listener)
    {

        this.books=books;
        this.listener=listener;
    }







    class bookVH extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewName,textViewAuthar ;
        ImageView imageView ;
        RatingBar ratingBar;



        public bookVH(@NonNull View itemView) {

            super(itemView);

            textViewName=itemView.findViewById(R.id.bookName);
            textViewAuthar=itemView.findViewById(R.id.autharName);
            imageView=itemView.findViewById(R.id.bookImg);
            ratingBar=itemView.findViewById(R.id.ratingBar);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v ,getAdapterPosition());
        }
    }




    @NonNull
    @Override
    public bookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);

        bookVH b =new bookVH(v);


        return b;
    }




    public void onBindViewHolder(@NonNull bookVH holder, int position) {

        holder.textViewName.setText(books.get(position).getName());

        holder.textViewAuthar.setText(books.get(position).getAuthar());

        Picasso.get().load( books.get(position).getImg() ).fit().centerInside().into( holder.imageView );
        holder.ratingBar.setRating(books.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    public interface RecyclerViewClickListener{
        void onClick (View view,int position);
    }








}
