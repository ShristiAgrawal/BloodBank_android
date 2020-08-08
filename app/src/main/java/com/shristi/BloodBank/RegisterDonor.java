package com.shristi.BloodBank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shristi.BloodBank.Models.DonorDetails;
import com.shristi.BloodBank.Services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterDonor extends AppCompatActivity {
    private RetrofitService postsService;

    Button register;
    RetrofitService service;
    DonorDetails details;
    EditText name,phone,bloodgroup,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_donor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bloodbank-sa.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postsService = retrofit.create(RetrofitService.class);


        register=findViewById(R.id.Register);
        name=findViewById(R.id.Name);
        phone=findViewById(R.id.Phone);
        bloodgroup=findViewById(R.id.BloodGroup);
        address=findViewById(R.id.Address);
       // details=new DonorDetails("name",123, "bloodgroup", "address");
//        details.setName("mona");
//        details.setPhone(1234);
//        details.setBloodgroup("Apositive");
//        details.setAddress("dhj");
  register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          sendPost();
      }
  });
    }
    private void sendPost() {
        DonorDetails post = new DonorDetails();
        post.setName(name.getText().toString());
        post.setAddress(address.getText().toString());
        post.setBloodgroup(bloodgroup.getText().toString());
        post.setPhone(Integer.parseInt(phone.getText().toString().trim()));
        Call<DonorDetails> call = postsService.sendPosts(bloodgroup.getText().toString().trim(),post);
        call.enqueue(new Callback<DonorDetails>() {
            @Override
            public void onResponse(Call<DonorDetails> call, Response<DonorDetails> response) {
                Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DonorDetails> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}