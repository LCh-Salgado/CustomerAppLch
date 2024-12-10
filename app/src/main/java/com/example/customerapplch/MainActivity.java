package com.example.customerapplch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addFABTN;
    ArrayList<Customer> customers;
    Intent fABIntent;
    Button backBTNNN;
    Button nextBTNNN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backBTNNN = (Button)findViewById(R.id.backBTN);
        nextBTNNN = (Button)findViewById(R.id.nextBTN);
        addFABTN = (FloatingActionButton)findViewById(R.id.add_fab);
        customers = new ArrayList<Customer>();

    backBTNNN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    });
    nextBTNNN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    });
    addFABTN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fABIntent = new Intent(MainActivity.this, AddCustomerActivity.class);
            startActivity(fABIntent);
        }
    });

    }


}