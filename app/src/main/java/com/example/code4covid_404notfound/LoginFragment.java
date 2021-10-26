package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {

    FirebaseAuth fAuth;
    EditText email;
    EditText password;
    Button signIn;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login,container,false);
        email = v.findViewById(R.id.email_signin);
        password = v.findViewById(R.id.passsignin);
        textView = v.findViewById(R.id.textView2);
        signIn = v.findViewById(R.id.login_btn);
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        if(userEmail.isEmpty() || userPassword.isEmpty()){
            Toast.makeText(getActivity(), "Enter Details", Toast.LENGTH_SHORT).show();
        }
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            NewsFragment fragment = new NewsFragment();
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container,fragment).commit();
                            Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getActivity(), "Unable to login", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Unable to login", Toast.LENGTH_SHORT).show();

                    }
                });
                
            }
        });
        return v;    }
}