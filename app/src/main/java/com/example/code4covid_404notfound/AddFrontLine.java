package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddFrontLine extends Fragment {


    EditText name,type,descprtion,contact;
    FirebaseFirestore dbroot;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_front_line,container,false);
        dbroot = FirebaseFirestore.getInstance();
        Button button = v.findViewById(R.id.add_btn);
        name = v.findViewById(R.id.name1);
        type = v.findViewById(R.id.type);
        descprtion = v.findViewById(R.id.loaction1);
        contact = v.findViewById(R.id.contact1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();

//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container,new FrontLineFragment()).commit();
            }
        });
        return v;
    }

    private void insertData() {
        Map<String,String> items = new HashMap<>();
        items.put("Type",type.getText().toString().trim());
        items.put("name",name.getText().toString().trim());
        items.put("Location",descprtion.getText().toString().trim());
        items.put("Contact",contact.getText().toString().trim());


        dbroot.collection("Insert Data")
                .add(items).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(getActivity().getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity().getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

}