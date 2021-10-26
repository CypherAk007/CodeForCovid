package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class VerifyFragment extends Fragment {

    User user;
    Button submit;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_verify,container,false);
        submit = v.findViewById(R.id.button2);
        editText = v.findViewById(R.id.editTextTextPersonName);
        radioGroup = v.findViewById(R.id.radioGroup);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = editText.getText().toString();
                int id = radioGroup.getCheckedRadioButtonId();
                Toast.makeText(getActivity(), String.valueOf(id), Toast.LENGTH_SHORT).show();
                if(id != -1){
                    View radioBtn = radioGroup.findViewById(id);
                    int radioId = radioGroup.indexOfChild(radioBtn);
                    RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                    String selection = (String) btn.getText();
                    if(id == 2131296758){
                        boolean val = true;
                        user = new User(val);


//                        Toast.makeText(getActivity(), "Yes in if", Toast.LENGTH_SHORT).show();
//                        Bundle bundle = new Bundle();
//
//                        bundle.putString("Key","true");
                        FourmFragment fragment = new FourmFragment();
                        //fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    }else{
                        Toast.makeText(getActivity(), "no in if", Toast.LENGTH_SHORT).show();
                        boolean val = true;
                        user = new User(val);
//                        Bundle bundle = new Bundle();
//                        boolean val = false;
//                        bundle.putString("Key","false");
                        FourmFragment fragment = new FourmFragment();

                       // fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                    }

                    Toast.makeText(getActivity(), selection, Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(getActivity(), "Radio button" + radioButton.getText(), Toast.LENGTH_SHORT).show();
//                if(radioButton.getText() == "Yes"){
//
//                    Bundle bundle = new Bundle();
//                    bundle.putBoolean("key",true);
//                    FourmFragment fragment = new FourmFragment();
//                    fragment.setArguments(bundle);
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment)
//                            .commit();
//                }else{
//
//                }

            }
        });

        return v;
    }

}