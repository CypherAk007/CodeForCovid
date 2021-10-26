package com.example.code4covid_404notfound;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CenterAdapter extends RecyclerView.Adapter<CenterAdapter.CenterRVViewHolder> {

    List<CenterModel> centerList;
    Context mContext;
    public CenterAdapter(ArrayList<CenterModel> items, Context context) {
        super();
        this.centerList = items;
        this.mContext = context;
    }
    @NonNull
    @Override
    public CenterRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccine_view,parent,false);
        return new CenterRVViewHolder(view);
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CenterRVViewHolder holder, int position) {

        CenterModel center = centerList.get(position);
        holder.centerNameTv.setText(center.getCenterName());
        holder.vaccineFeesTv.setText(center.getFee_type());
        holder.VaccineNameTv.setText(center.getVaccineName());
        holder.ageLimit.setText(String.valueOf(center.getAge_limit()) + "+");
        holder.availability.setText(String.valueOf(center.getAvailableCapacity()));

        if (center.getAvailableCapacity() == 0) {
            holder.Bookurl.setTextColor(R.color.grey);
            holder.availability.setBackgroundResource(R.drawable.myshape);
        }
        if (center.getAvailableCapacity() != 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://selfregistration.cowin.gov.in/";
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(mContext, Uri.parse(url));

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return centerList.size();
    }


    public static class CenterRVViewHolder extends RecyclerView.ViewHolder{

        private TextView centerNameTv;
        private TextView VaccineNameTv;
        private TextView vaccineFeesTv;
        private TextView ageLimit;
        private TextView availability;
        private TextView Bookurl;
        public CenterRVViewHolder(@NonNull View itemView) {
            super(itemView);
            centerNameTv = itemView.findViewById(R.id.idTVCenterName);
            VaccineNameTv = itemView.findViewById(R.id.idTVVaccineName);
            vaccineFeesTv = itemView.findViewById(R.id.idTVFeeType);
            ageLimit = itemView.findViewById(R.id.idTVAgeLimit);
            availability = itemView.findViewById(R.id.idTVAvaliablity);
            Bookurl = itemView.findViewById(R.id.bookNow);


        }

    }
}
