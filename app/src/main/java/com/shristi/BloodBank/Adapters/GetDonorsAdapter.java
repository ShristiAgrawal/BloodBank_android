package com.shristi.BloodBank.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shristi.BloodBank.Models.DonorDetails;
import com.shristi.BloodBank.R;

import java.util.List;

public class GetDonorsAdapter extends RecyclerView.Adapter<GetDonorsAdapter.ViewHolder> {


    private Context context;
    private List<DonorDetails> list;

    public GetDonorsAdapter(Context context, List<DonorDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.donor_item,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {



        viewHolder.t1.setText(list.get(i).getName());
        viewHolder.t2.setText(list.get(i).getPhone().toString());
        viewHolder.t3.setText(list.get(i).getBloodgroup());
        viewHolder.t4.setText(list.get(i).getAddress());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView t1,t2,t3,t4;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            card=itemView.findViewById(R.id.cv);
            t1=itemView.findViewById(R.id.tv1);
            t2=itemView.findViewById(R.id.tv2);
            t3=itemView.findViewById(R.id.tv3);
            t4=itemView.findViewById(R.id.tv4);

        }
    }}
