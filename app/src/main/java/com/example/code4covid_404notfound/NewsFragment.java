package com.example.code4covid_404notfound;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class NewsFragment extends Fragment implements NewsItemClicked{
    NewsAdapter newsAdapter;
    ArrayList<News> newsArray;
    News news;
    LinearLayoutManager layoutManager;
    Dialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        dialog = new Dialog(getActivity());
//        SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        boolean isCheck = prefs.getBoolean("check",true);
//        if(isCheck){
//            openTipDialog();
//        }
        openTipDialog();
        View v = inflater.inflate(R.layout.fragment_news,container,false);
        RecyclerView newsList = v.findViewById(R.id.newsList);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        newsList.setLayoutManager(layoutManager);

        fetchData();
        newsAdapter = new NewsAdapter(this);
        newsList.setAdapter(newsAdapter);
        return v;
    }


    private void openTipDialog() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Wear a mask");
        arrayList.add("Sanitize your Hands");
        arrayList.add("Have a nutritious diet");
        arrayList.add("Exercise a little every day");
        arrayList.add("Maintain 6-feet distance");
        arrayList.add("Stay Home Stay Safe");
        arrayList.add("Check your blood oxygen level");
        arrayList.add("Watch out for symptoms");
        arrayList.add("Play a few memory games");
        dialog.setContentView(R.layout.tip_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageView = dialog.findViewById(R.id.imageViewclose);
        TextView textView = dialog.findViewById(R.id.close_text);
        TextView tipOfday = dialog.findViewById(R.id.tipoftheday);
        Collections.shuffle(arrayList);
        tipOfday.setText(arrayList.get(2));
        dialog.show();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//                SharedPreferences prefs = getActivity().getSharedPreferences("prefs",Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = prefs.edit();
//                editor.putBoolean("check",false);
//                editor.apply();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    private void fetchData() {
        String url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {//get data

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray newsJsonArray = response.getJSONArray("articles");//getting json array
                            newsArray = new ArrayList<News>();
                            for(int i=1;i<newsJsonArray.length();i++){
                                JSONObject newsJsonObject = newsJsonArray.getJSONObject(i);
                                news = new News(
                                        newsJsonObject.getString("title"),
                                        newsJsonObject.getString("author"),
                                        newsJsonObject.getString("url"),
                                        newsJsonObject.getString("urlToImage")
                                );
                                newsArray.add(news);
                            }
                            newsAdapter.updateNews(newsArray);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Unable to Fetch data", Toast.LENGTH_SHORT).show();

                    }
                });
        MySingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest);

    }
    public void onItemClicked(News item){
//        Toast.makeText(this,"Clicked item is "+ item,Toast.LENGTH_SHORT).show();
        String url = item.getmUrl();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
    }
}
