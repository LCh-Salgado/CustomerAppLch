package com.example.customerapplch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCustomerActivity extends AppCompatActivity {

    EditText nameET;
    EditText lastNameET;
    EditText phoneET;
    EditText addressET;
    EditText emailET;
    Button submitBTNN;

    String name;
    String lastname;
    String phone;
    String address;
    String email;
    Customer myCustomer;
    FirebaseDatabase database;
    DatabaseReference myRef;
//    Firebase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        nameET = (EditText)findViewById(R.id.typeNET);
        lastNameET = (EditText)findViewById(R.id.lastNET);
        phoneET = (EditText)findViewById(R.id.phoneET);
        addressET = (EditText)findViewById(R.id.addressET);
        emailET = (EditText)findViewById(R.id.emailET);
        submitBTNN = (Button)findViewById(R.id.submitBTN);
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

//        myRef.setValue(myCustomer);

        submitBTNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameET.getText().toString();
                lastname = lastNameET.getText().toString();
                phone = phoneET.getText().toString();
                address = addressET.getText().toString();
                email = emailET.getText().toString();
                myCustomer = new Customer(name, lastname, phone, address, email);
                myRef.setValue(myCustomer);
            }
        });
    }


}