package com.example.formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NavigatedTo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigated_to);

        Intent intent =  getIntent();
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");
        String email = intent.getStringExtra("email");


        TextView nameView = (TextView)findViewById(R.id.name);
        TextView numberView = (TextView)findViewById(R.id.number);
        TextView emailView = (TextView)findViewById(R.id.email);

        nameView.setText(name);
        numberView.setText(number);
        emailView.setText(email);

//        Toast.makeText(getApplicationContext(),name, Toast.LENGTH_LONG).show();

    }
}