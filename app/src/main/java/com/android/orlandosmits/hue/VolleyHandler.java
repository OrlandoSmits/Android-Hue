package com.android.orlandosmits.hue;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
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

    public boolean turnOn(String url) {
        this.doRequest(url, "{\"on\":true}", Request.Method.PUT);
        return true;
    }

    public boolean turnOff(String url) {
        this.doRequest(url, "{\"on\":false}", Request.Method.PUT);
        return true;
    }

    // Sets the brightness of an individual Hue
    public boolean setBrightness(String url, int brightness) {
        this.doRequest(url, "{\"bri\":" + brightness + "}", Request.Method.PUT);
        return true;
    }

    // Sets the hue of an individual Hue
    public boolean setSaturation(String url, int saturation) {
        this.doRequest(url, "{\"sat\":" + saturation + "}", Request.Method.PUT);
        return true;
    }

    // Sets the hue of an individual Hue
    public boolean setHue(String url, int hue) {
        this.doRequest(url, "{\"hue\":" + hue + "}", Request.Method.PUT);
        return true;
    }

    // Sets the effect of an individual Hue
    public boolean setEffect(String url, boolean b) {

        String effect = "colorloop";

        if (!b) {
            effect = "none";
        }

        this.doRequest(url, "{\"effect\":\"" + effect + "\"}", Request.Method.PUT);
        return true;
    }

    public boolean setAlert(String url, boolean b) {

        String alert = "lselect";

        if (!b) {
            alert = "select";
        }

        this.doRequest(url, "{\"alert\":\"" + alert + "\"}", Request.Method.PUT);
        return true;
    }

    public boolean setDisco(String url, boolean b) {

        String alert = "lselect";
        String effect = "colorloop";

        if (!b) {
            alert = "select";
            effect = "none";
        }

        this.doRequest(url, "{\"effect\":\"" + effect + "\"}", Request.Method.PUT);
        this.doRequest(url, "{\"alert\":\"" + alert + "\"}", Request.Method.PUT);
        return true;
    }
}
