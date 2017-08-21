package com.olegsagenadatrytwo.w3_w_amazon;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.olegsagenadatrytwo.w3_w_amazon.model.Book;
import com.olegsagenadatrytwo.w3_w_amazon.service.GetBooksIntentService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = "MainActivity";
    private List<Book> books;
    private RecyclerView rvRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private BooksAdapter adapter;
    private MyBroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") != PackageManager.PERMISSION_GRANTED) {

            final int REQUEST_CODE_ASK_PERMISSIONS = 123;

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);

        }
        setContentView(R.layout.activity_main);

        rvRecyclerView = (RecyclerView) findViewById(R.id.rvRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvRecyclerView.setLayoutManager(layoutManager);
        rvRecyclerView.setItemAnimator(itemAnimator);
        receiver = new MyBroadcastReceiver(adapter, rvRecyclerView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("receivedBooks");
        registerReceiver(receiver, intentFilter);

        //start service to get books
        Intent intentService = new Intent(this, GetBooksIntentService.class);
        intentService.setAction("getBooks");
        startService(intentService);
    }
}
