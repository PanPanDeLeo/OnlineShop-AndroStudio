package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class about_page extends AppCompatActivity {
    Button home, item, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        Button home = findViewById(R.id.homeBtn);
        Button item = findViewById(R.id.itemBtn);
        Button about = findViewById(R.id.aboutBtn);
        Button logout = findViewById(R.id.logoutBtn);

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

    public void Login() {
        Intent intent = new Intent(about_page.this, MainActivity.class);
        startActivity(intent);
    }
    public void Home() {
        Intent intent = new Intent(about_page.this, home_page.class);
        startActivity(intent);
    }
    public void Item() {
        Intent intent = new Intent(about_page.this, item_page.class);
        startActivity(intent);
    }public void About() {
        Intent intent = new Intent(about_page.this, about_page.class);
        startActivity(intent);
    }
}

