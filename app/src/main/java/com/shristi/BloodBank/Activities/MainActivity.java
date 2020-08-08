package com.shristi.BloodBank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shristi.BloodBank.R;

public class MainActivity extends AppCompatActivity {
Button donor,receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donor=(Button)findViewById(R.id.donor);
        receiver=findViewById(R.id.receiver);
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, RegisterDonor.class);
                startActivity(i);
            }
        });
        receiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Receiver.class);
                startActivity(i);

            }
        });

    }
}