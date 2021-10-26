package com.example.code4covid_404notfound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private Context context;
    ArrayList<User> list = new ArrayList<>();
    public RVAdapter(Context ctx){
        this.context = ctx;
    }
    public void setItems(ArrayList<User> user){
        list.addAll(user);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        holder.Name.setText(user.getmName());
        holder.Age.setText(user.getmAge());
        holder.Contact.setText("Contact: "+user.getmContact());
        holder.verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                VerifyFragment fragment = new VerifyFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .addToBackStack(null).commit();
            }
        });
        if(user.isVal()){
            holder.verify_txt.setText("Fake");
        }else {
            holder.verify_txt.setText("Verified");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Name;
        private TextView Age;
        private TextView Contact;
        private Button verify;
        private TextView verify_txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.text_name);
            Age = itemView.findViewById(R.id.text_age);
            Contact = itemView.findViewById(R.id.text_contact);
            verify = itemView.findViewById(R.id.verify);
            verify_txt = itemView.findViewById(R.id.verify_text);

        }
    }
}
