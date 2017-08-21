package com.olegsagenadatrytwo.w3_w_amazon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olegsagenadatrytwo.w3_w_amazon.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omcna on 8/20/2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> listOfBooks = new ArrayList<>();

    public BooksAdapter(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_recycler_books, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(listOfBooks.get(position).getTitle());
        holder.tvAuthor.setText(listOfBooks.get(position).getAuthor());
        Glide.with(holder.imageView.getContext()).load(listOfBooks.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listOfBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvAuthor;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            imageView = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }
}
