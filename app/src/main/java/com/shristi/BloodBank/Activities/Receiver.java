package com.shristi.BloodBank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shristi.BloodBank.R;

public class Receiver extends AppCompatActivity {
Button adbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        adbutton=findViewById(R.id.show_donor_button);
        adbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Receiver.this, AvailableDonors.class);
                startActivity(i);
            }
        });
    }
}