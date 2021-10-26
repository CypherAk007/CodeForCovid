package com.example.code4covid_404notfound;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;


public class InputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        setContentView(R.layout.activity_input_data);
        View v = inflater.inflate(R.layout.activity_input_data,container,false);
        final EditText edit_name = v.findViewById(R.id.name);
        final EditText edit_age = v.findViewById(R.id.age);
        final EditText edit_phone = v.findViewById(R.id.contact);
        Button button = v.findViewById(R.id.button);
        DAOUser dao = new DAOUser();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_name = edit_name.getText().toString();
                String input_des = edit_age.getText().toString();
                String input_phone = edit_phone.getText().toString();
                if(input_des.isEmpty() || input_name.isEmpty()){
                    Snackbar.make(v, "Please enter data", Snackbar.LENGTH_LONG).show();
                    //Toast.makeText(InputData.this, "Please enter data", Toast.LENGTH_SHORT).show();
                }else{
                    User user = new User(input_name,input_des,input_phone);
                    dao.add(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getActivity(), "Data added successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    //startActivity(new Intent(getActivity(),MainActivity.class));
                }
            }
        });
        return v;
    }
}
//        return inflater.inflate(R.layout.fragment_input, container, false);

