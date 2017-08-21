package com.olegsagenadatrytwo.w3_w_amazon.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;

import com.google.gson.Gson;
import com.olegsagenadatrytwo.w3_w_amazon.BooksLab;
import com.olegsagenadatrytwo.w3_w_amazon.model.Book;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetBooksIntentService extends IntentService {

    private static final String TAG = "GetBooksIntentService";
    private static final String URL = "http://de-coding-test.s3.amazonaws.com/books.json";
    private ArrayList<Book> booksList = new ArrayList<>();


    public GetBooksIntentService() {
        super("GetBooksIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent: ");
        switch (intent.getAction()) {
            case "getBooks":
                Log.d(TAG, "onHandleIntent: " + "case");

                final OkHttpClient okHttpClient;
                final Request request;

                //get the data
                okHttpClient = new OkHttpClient();
                request = new Request.Builder()
                        .url(URL)
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: "  + call.toString() + e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d(TAG, "onResponse: ");
                        Gson gson = new Gson();
                        Book[] books;
                        books = gson.fromJson(response.body().string(), Book[].class);
                        //copy to array list
                        for (int i = 0; i < books.length; i++) {
                            booksList.add(books[i]);
                        }
                        Intent intent = new Intent();
                        intent.setAction("receivedBooks");
                        //intent.putExtra("books", booksList);
                        BooksLab.get().setBookList(booksList);
                        sendBroadcast(intent);
                    }
                });
                break;
        }

    }
}
