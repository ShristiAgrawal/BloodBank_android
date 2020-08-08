package com.shristi.BloodBank.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shristi.BloodBank.Adapters.GetDonorsAdapter;
import com.shristi.BloodBank.Models.DonorDetails;
import com.shristi.BloodBank.R;
import com.shristi.BloodBank.Services.RetrofitClient;
import com.shristi.BloodBank.Services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableDonors extends AppCompatActivity {
    Button search;RetrofitService service;
    EditText bg;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_donors);
        search=findViewById(R.id.search);
        service= RetrofitClient.getinstance().create(RetrofitService.class);
        bg=findViewById(R.id.bg);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDonorsAvailable();
            }
        });

    }
    void getDonorsAvailable(){

        Call<List<DonorDetails>> call=service.getDonorsAvailable(bg.getText().toString());
        call.enqueue(new Callback<List<DonorDetails>>() {
            @Override
            public void onResponse(Call<List<DonorDetails>> call, Response<List<DonorDetails>> response) {
                generatelist(response.body());
            }

            @Override
            public void onFailure(Call<List<DonorDetails>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"unsuccessful",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generatelist(List<DonorDetails> body) {

        rv=findViewById(R.id.rv_donor);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(AvailableDonors.this);
        GetDonorsAdapter adapter=new GetDonorsAdapter(AvailableDonors.this,body);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);



    }
}
