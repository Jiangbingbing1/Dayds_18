package com.bawei.mylogin.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.mylogin.Icout;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyVolley {
    private static final MyVolley ourInstance = new MyVolley();

    public static MyVolley getInstance() {
        return ourInstance;
    }

    private MyVolley() {
    }

    public void getVolley(Context context, String url, final Icout.ICallback iCallback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    iCallback.getData(response);
            }
        },null);

        requestQueue.add(request);

    }

    public void setVolley(Context context, String url, final Map<String,String> map, final Icout.ICallback iCallback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallback.getData(response);
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };

        requestQueue.add(request);

    }

}
