package com.example.code4covid_404notfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;

public class InputData extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
        final EditText edit_name = findViewById(R.id.name);
        final EditText edit_age = findViewById(R.id.age);
        final EditText edit_phone = findViewById(R.id.contact);
        Button button = findViewById(R.id.button);
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
                            Toast.makeText(InputData.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputData.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
