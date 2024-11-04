package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText emailET, passwordET;
    TextView errorTV;
    Button loginBtn;

    public void Login(String email) {
        Intent intent = new Intent(MainActivity.this, home_page.class);
        intent.putExtra("LoginName", email);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);
        errorTV = findViewById(R.id.errorLbl);
        loginBtn = findViewById(R.id.loginBtn);

        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        loginBtn.setOnClickListener(e -> {
            if(email.isEmpty()) {
                errorTV.setText("Email must be filled !");
                errorTV.setVisibility(View.VISIBLE);
                return;
            } else if (!email.contains(".")) {
                errorTV.setText("Email must contain \".\"");
                errorTV.setVisibility(View.VISIBLE);
                return;
            } else if (password.isEmpty()) {
                errorTV.setText("Password must be filled");
                errorTV.setVisibility(View.VISIBLE);
                return;
            } else {
                Login(email);
                return;
            }
        });
    }
}