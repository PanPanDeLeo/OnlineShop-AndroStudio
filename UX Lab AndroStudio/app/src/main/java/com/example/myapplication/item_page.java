package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.uxlab.models.alatTulis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class item_page extends AppCompatActivity {
    Button home, item, about, logout, prev, next, hotseller, allproducts;
    private ViewFlipper flipper;
    TextView judul, getJudul, stokProduk;
    ImageView imgProduk;

    LinearLayout linearLayout;

    RecyclerView alatTulisView1, alatTulisView2;
    LinearLayout hotSellerContent;
    ScrollView sv1;
    private final List<Integer> images = Arrays.asList(
            R.drawable.pencil, R.drawable.ballpoint, R.drawable.gluestick, R.drawable.ruler, R.drawable.scissors);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_page);
        home = findViewById(R.id.homeBtn);
        item = findViewById(R.id.itemBtn);
        about = findViewById(R.id.aboutBtn);
        logout = findViewById(R.id.logoutBtn);
        prev = findViewById(R.id.prevBtn);
        next = findViewById(R.id.nextBtn);
        hotseller = findViewById(R.id.hotSellerBtn);
        allproducts = findViewById(R.id.allItemsBtn);
        judul = findViewById(R.id.itemName);
        hotSellerContent = findViewById(R.id.hotSellerItem);
        sv1 =findViewById(R.id.scrollview);

        sv1.setVisibility(View.VISIBLE);

        this.flipper = findViewById(R.id.carousel);
        for (int image : images){
            this.slidesImage(image);
        }

        alatTulisView1 = findViewById(R.id.recyclerView1);
        alatTulisView1.setLayoutManager(new LinearLayoutManager(this));
        alatTulisView2 = findViewById(R.id.View2);
        alatTulisView2.setLayoutManager(new LinearLayoutManager(this));



        hotseller.setOnClickListener((v)->{
            sv1.setVisibility(View.VISIBLE);
            alatTulisView2.setVisibility(View.GONE);
        });
        allproducts.setOnClickListener((v)->{
            alatTulisView2.setVisibility(View.VISIBLE);
            sv1.setVisibility(View.GONE);
        });
        prev.setOnClickListener((v)->{
            flipper.setInAnimation(this, android.R.anim.slide_in_left);
            flipper.showPrevious();
            flipper.setInAnimation(this, R.anim.slide_in_right);
        });
        next.setOnClickListener(e->{
            flipper.showNext();
        });



        home.setOnClickListener(e->{
            Home();
        });
        item.setOnClickListener(e->{
            Item();
        });
        about.setOnClickListener(e->{
            About();
        });
        logout.setOnClickListener(e->{
            Login();
        });
    }

    public void slidesImage(int image){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(image);
        flipper.addView(imageView);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(2000);
        flipper.setInAnimation(this, R.anim.slide_in_right);
        flipper.setOutAnimation(this, R.anim.slide_out_left);
    }

    public void Login() {
        Intent intent = new Intent(item_page.this, MainActivity.class);
        startActivity(intent);
    }public void Home() {
        Intent intent = new Intent(item_page.this, home_page.class);
        startActivity(intent);
    }public void Item() {
        Intent intent = new Intent(item_page.this, item_page.class);
        startActivity(intent);
    }public void About() {
        Intent intent = new Intent(item_Page.this, about_page.class);
        startActivity(intent);
    }
}
