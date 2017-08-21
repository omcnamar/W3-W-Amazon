package com.olegsagenadatrytwo.w3_w_amazon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = "MyBroadcastReceiver";
    private BooksAdapter adapter;
    private RecyclerView recyclerView;

    public MyBroadcastReceiver(BooksAdapter adapter, RecyclerView recyclerView) {
        this.adapter = adapter;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");
        switch (intent.getAction()) {
            case "receivedBooks":
                Log.d(TAG, "onReceive: ");
                BooksLab lab = BooksLab.get();
                adapter = new BooksAdapter(lab.getBooks());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;
        }

    }
}
