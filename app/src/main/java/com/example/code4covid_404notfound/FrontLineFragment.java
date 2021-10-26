package com.example.code4covid_404notfound;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FrontLineFragment extends Fragment {

    CardView cardDoc;
    CardView cardMed;
    CardView cardVol;
    CardView cardOxy;
    CardView cardCare;
    CardView cardOthers;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frontline,container,false);
        cardDoc = v.findViewById(R.id.doctor);
        cardMed = v.findViewById(R.id.medical);
        cardVol = v.findViewById(R.id.voluenteer);
        cardOxy = v.findViewById(R.id.oxygen);
        cardCare = v.findViewById(R.id.caretaker);
        cardOthers = v.findViewById(R.id.others);
        button = v.findViewById(R.id.add_workers);
        cardDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("doc clicked");
                DoctorsFragment fragment = new DoctorsFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.addToBackStack("true");
                ft.replace(R.id.fragment_container,fragment).commit();

            }
        });
        cardMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_volunteer fragment_volunteer = new fragment_volunteer();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true").replace(R.id.fragment_container,fragment_volunteer).commit();
            }
        });
        cardVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_volunteer fragment_volunteer = new fragment_volunteer();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true").replace(R.id.fragment_container,fragment_volunteer).commit();
            }
        });
        cardOxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_oxygen fragment_oxygen = new fragment_oxygen();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true").replace(R.id.fragment_container,fragment_oxygen).commit();
                showToast("oxy clicked");
            }
        });

        cardCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_caretakers fragment_caretakers = new fragment_caretakers();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true").replace(R.id.fragment_container,fragment_caretakers).commit();
            }
        });

        cardOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_container fragment_container = new fragment_container();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true").replace(R.id.fragment_container,fragment_container).commit();
                showToast("others clicked");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddFrontLine frontLine = new AddFrontLine();
                getActivity().getSupportFragmentManager().beginTransaction().
                        addToBackStack("true")
                        .replace(R.id.fragment_container,frontLine).commit();
            }
        });

        Button editbtn = v.findViewById(R.id.button4);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditFrontLine frontLine = new EditFrontLine();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("true")
                        .replace(R.id.fragment_container,frontLine).commit();
            }
        });
        return v;
    }


    private void showToast(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }
}