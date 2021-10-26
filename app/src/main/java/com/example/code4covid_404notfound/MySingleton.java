//package com.example.newsapp;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class MySingleton extends AppCompatActivity {
//        // creating que queue object
//        private RequestQueue queue;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // initializing the queue object
//        super.onCreate(savedInstanceState);
//
//        queue = Volley.newRequestQueue(this);
//    }
//
//    private StringRequest searchNameStringRequest(String nameSearch) {
//        final String API = "&api_key=<<YOUR_API_KEY_HERE>>";
//        final String NAME_SEARCH = "&q=";
//        final String DATA_SOURCE = "&ds=Standard Reference";
//        final String FOOD_GROUP = "&fg=";
//        final String SORT = "&sort=r";
//        final String MAX_ROWS = "&max=25";
//        final String BEGINNING_ROW = "&offset=0";
//        final String URL_PREFIX = "https://api.nal.usda.gov/ndb/search/?format=json";
//
//        String url = URL_PREFIX + API + NAME_SEARCH + nameSearch + DATA_SOURCE + FOOD_GROUP + SORT + MAX_ROWS + BEGINNING_ROW;
//
//        // 1st param => type of method (GET/PUT/POST/PATCH/etc)
//        // 2nd param => complete url of the API
//        // 3rd param => Response.Listener -> Success procedure
//        // 4th param => Response.ErrorListener -> Error procedure
//        return new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    // 3rd param - method onResponse lays the code procedure of success return
//                    // SUCCESS
//                    @Override
//                    public void onResponse(String response) {
//                        // try/catch block for returned JSON data
//                        // see API's documentation for returned format
//                        try {
//                            JSONObject result = new JSONObject(response).getJSONObject("list");
//                            int maxItems = result.getInt("end");
//                            JSONArray resultList = result.getJSONArray("item");
//
//                            // catch for the JSON parsing error
//                        } catch (JSONException e) {
//                            Toast.makeText(AddFoodItems.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    } // public void onResponse(String response)
//                }, // Response.Listener<String>()
//                new Response.ErrorListener() {
//                    // 4th param - method onErrorResponse lays the code procedure of error return
//                    // ERROR
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // display a simple message on the screen
//                        Toast.makeText(AddFoodItems.this, "Food source is not responding (USDA API)", Toast.LENGTH_LONG).show();
//                    }
//                });
//    }
//    // Click event of the button Search
//    public void btnSearchClickEventHandler(View view) {
//
//        // cancelling all requests about this search if in queue
//        queue.cancelAll(TAG_SEARCH_NAME);
//
//        // first StringRequest: getting items searched
//        StringRequest stringRequest = searchNameStringRequest(txtSearch.getText().toString());
//        stringRequest.setTag(TAG_SEARCH_NAME);
//
//        // executing the request (adding to queue)
//        queue.add(stringRequest);
//    }


package com.example.code4covid_404notfound;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}