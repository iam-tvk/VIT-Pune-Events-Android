package com.example.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;



public class HomeScreen extends AppCompatActivity {
ImageButton imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://melange.epecvitpune.in/"));
                startActivity(browseIntent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vitpunemun.com/"));
                startActivity(browseIntent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.treksandtrails.org/tours/katraj-to-sinhagad-k2s"));
                startActivity(browseIntent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.punetrekkers.com/rajgad-fort"));
                startActivity(browseIntent);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tedxvitpune.in/"));
                startActivity(browseIntent);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/veloce_racing/?hl=en"));
                startActivity(browseIntent);
            }
        });




    }
}
