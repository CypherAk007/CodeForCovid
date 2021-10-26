package com.example.code4covid_404notfound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FourmFragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ArrayList<User> userlist;
    RVAdapter adapter;
    DAOUser dao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fourm, container, false);

        swipeRefreshLayout = v.findViewById(R.id.swipe);
        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RVAdapter(getContext());
        recyclerView.setAdapter(adapter);

        dao = new DAOUser();
        loadData();

        FloatingActionButton fab;
        fab = v.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputFragment fragment = new InputFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.addToBackStack("manoj");
                ft.replace(R.id.fragment_container,fragment).commit();

            }
        });


        return v;
    }


    //    public void setFragment(){
//        VerifyFragment fragment = new VerifyFragment();
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container,fragment).commit();
//    }

    private void loadData() {
        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userlist = new ArrayList<User>();
                for(DataSnapshot data : snapshot.getChildren()){
                    User user = data.getValue(User.class);
                    userlist.add(user);
                }
                adapter.setItems(userlist);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}