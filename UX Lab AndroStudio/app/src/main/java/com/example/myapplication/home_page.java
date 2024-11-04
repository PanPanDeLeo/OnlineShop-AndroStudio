package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class home_page extends AppCompatActivity {
    Button home, item, about, logout;
    TextView name;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button home = findViewById(R.id.homeBtn);
        Button item = findViewById(R.id.itemBtn);
        Button about = findViewById(R.id.aboutBtn);
        Button logout = findViewById(R.id.logoutBtn);
        TextView name = findViewById(R.id.emailName);
        Bundle extras = getIntent().getExtras();

        name.setText(extras.getString("userNameLogin").toString());
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
        Intent intent = new Intent(home_page.this, MainActivity.class);
        startActivity(intent);
    }
    public void Home() {
        Intent intent = new Intent(home_page.this, home_page.class);
        startActivity(intent);
    }
    public void Item() {
        Intent intent = new Intent(home_page.this, item_page.class);
        startActivity(intent);
    }public void About() {
        Intent intent = new Intent(home_page.this, about_page.class);
        startActivity(intent);
    }

}