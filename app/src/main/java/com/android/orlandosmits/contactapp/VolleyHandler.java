package com.android.orlandosmits.contactapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;

/**
 * Created by Luuk on 1-11-2016.
 */

public class VolleyHandler {

    // Tag for logging-purposes
    private String TAG = this.getClass().getName();

    private static VolleyHandler sInstance = null;
    private Context mContext;

    private String requestResponse;

    public VolleyHandler(Context context) {
        this.mContext = context;
    }

    public static VolleyHandler getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VolleyHandler(context);
        }

        return sInstance;
    }

    public String doRequest(String requestUrl, final String requestBody, int requestMethod) {

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        StringRequest stringRequest = new StringRequest(requestMethod, requestUrl,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response);
                        requestResponse = response;
                    }

                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
                error.printStackTrace();
            }

        }) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while getting the bytes of %s using %s",
                            requestBody, "utf-8");
                    uee.printStackTrace();
                    return null;
                }

            }

        };

        requestQueue.add(stringRequest);

        return requestResponse;

    }
}
