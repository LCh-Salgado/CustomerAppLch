package com.example.customerapplch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addFABTN;
    ArrayList<Customer> customers;
    int customerIndex;
    Intent fABIntent;
    Button backBTNNN;
    Button nextBTNNN;
    TextView nameTvv;
    TextView lastNameTvv;
    TextView phoneTvv;
    TextView addressTvv;
    TextView emailTvv;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Customer currentCustomer;
    public static final String TAG = "VALUE FB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backBTNNN = (Button)findViewById(R.id.backBTN);
        nextBTNNN = (Button)findViewById(R.id.nextBTN);
        addFABTN = (FloatingActionButton)findViewById(R.id.add_fab);
        nameTvv = (TextView)findViewById(R.id.firstNameTV);
        lastNameTvv = (TextView)findViewById(R.id.lastNameTV);
        phoneTvv = (TextView)findViewById(R.id.phoneTV);
        addressTvv = (TextView)findViewById(R.id.phoneTV);
        emailTvv = (TextView)findViewById(R.id.emailTV);
        customerIndex = 0;

        customers = new ArrayList<Customer>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot customerSnapShot : dataSnapshot.getChildren()) {
                    Customer myCustomer = customerSnapShot.getValue(Customer.class);
                    Log.d(TAG, "Value is: " + myCustomer.getFirstName());
                    customers.add(myCustomer);
                }
                currentCustomer = customers.get(customerIndex);
                nameTvv.setText(currentCustomer.getFirstName());
                lastNameTvv.setText(currentCustomer.getLastName());
                phoneTvv.setText(currentCustomer.getPhone());
                addressTvv.setText(currentCustomer.getAddress());
                emailTvv.setText(currentCustomer.getEmail());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    backBTNNN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    });
    nextBTNNN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (customerIndex < customers.size()-1){
                customerIndex ++;
                currentCustomer = customers.get(customerIndex);
                nameTvv.setText(currentCustomer.getFirstName());
                lastNameTvv.setText(currentCustomer.getLastName());
                phoneTvv.setText(currentCustomer.getPhone());
                addressTvv.setText(currentCustomer.getAddress());
                emailTvv.setText(currentCustomer.getEmail());

            }
            else  {
                nextBTNNN.setVisibility(View.INVISIBLE);
            }

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