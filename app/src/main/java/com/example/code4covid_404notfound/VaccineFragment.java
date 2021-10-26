package com.example.code4covid_404notfound;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;


public class VaccineFragment extends Fragment {

    private EditText mPincode;
    private Button mSearchBtn;
    RecyclerView recyclerRV;
    ArrayList<CenterModel> centerModelList;
    CenterAdapter centerAdapter;
    ProgressBar loadingPB;
    LinearLayoutManager layoutManager;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_vaccine,container,false);
        imageView = v.findViewById(R.id.imageView11);
        mPincode = v.findViewById(R.id.idEdtPinCode);
        mSearchBtn = v.findViewById(R.id.idBtnSearch);
        loadingPB = v.findViewById(R.id.idPBLoading);
        recyclerRV = v.findViewById(R.id.centersRV);
        centerModelList = new ArrayList<CenterModel>();

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pincode = mPincode.getText().toString();
                if(pincode.length() != 6 ){
                    Toast.makeText(getActivity(), "Please Enter a Vaild Pincode", Toast.LENGTH_SHORT).show();
                }
                else{
                    centerModelList.clear();
                    imageView.setVisibility(View.INVISIBLE);
                    final Calendar c = Calendar.getInstance();
                    int mYear = c.get(Calendar.YEAR);
                    int mMonth = c.get(Calendar.MONTH);
                    int mDay = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    loadingPB.setVisibility(View.VISIBLE);
                                    String dateStr = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
                                    getAppointement(pincode,dateStr);
                                    Log.v("something",dateStr);
                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });
        return v;
    }


    private void getAppointement(String pinCode,String date){
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=" +pinCode+ "&date=" + date;
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    loadingPB.setVisibility(View.GONE);
                    JSONArray centreArray = response.getJSONArray("centers");
                    Log.v("something", String.valueOf(centreArray.length()));
                    if(centreArray.length() == 0) {
                        Toast.makeText(getActivity(), "No vaccination available", Toast.LENGTH_SHORT).show();
                    }
                    Log.v("something", String.valueOf(centreArray));
                    for(int i=0;i<centreArray.length();i++) {
                        JSONObject centreObj = centreArray.getJSONObject(i);
                        String centreName = centreObj.getString("name");
                        String fee_type = centreObj.getString("fee_type");
                        JSONObject sessionObj = centreObj.getJSONArray("sessions").getJSONObject(0);
                        int availableCapacity = sessionObj.getInt("available_capacity");
                        int ageLimit = sessionObj.getInt("min_age_limit");
                        String vaccineName = sessionObj.getString("vaccine");

                        Log.v("something", String.valueOf(pinCode));
                        CenterModel center = new CenterModel(
                                centreName,
                                fee_type,
                                ageLimit,
                                vaccineName,
                                availableCapacity
                        );
                        centerModelList.add(center);

                    }

                    layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerRV.setLayoutManager(layoutManager);
                    centerAdapter = new CenterAdapter(centerModelList,getActivity());
                    recyclerRV.setAdapter(centerAdapter);
                    centerAdapter.notifyDataSetChanged();

                }catch (Exception e) {
                    loadingPB.setVisibility(View.GONE);
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadingPB.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Unable to Fetch Data\nCheck your wifi connection", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonObjectRequest);
    }

}