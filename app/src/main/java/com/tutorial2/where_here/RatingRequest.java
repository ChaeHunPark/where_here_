package com.tutorial2.where_here;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RatingRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://192.168.216.70//RatingRequest.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;

    public RatingRequest(double score, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("score", score + "");
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
