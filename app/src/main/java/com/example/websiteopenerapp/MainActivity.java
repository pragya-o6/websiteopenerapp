package com.example.websiteopenerapp; // Replace with your actual package name

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] websites = {
            "Google",
            "YouTube",
            "Facebook",
            "Twitter",
            "Instagram"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView and Adapter
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, websites);
        listView.setAdapter(adapter);

        // Set an item click listener to handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String website = websites[position];
                String url = "";

                // Define URLs based on the selected website
                switch (website) {
                    case "Google":
                        url = "https://www.google.com";
                        break;
                    case "YouTube":
                        url = "https://www.youtube.com";
                        break;
                    case "Facebook":
                        url = "https://www.facebook.com";
                        break;
                    case "Twitter":
                        url = "https://www.twitter.com";
                        break;
                    case "Instagram":
                        url = "https://www.instagram.com";
                        break;
                }

                // Open the website using an implicit intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
