package com.example.baitaptuan4;

import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Volleyfn {
    String strJson="";
    public void getJsonArrayOfObject(MainActivity context, TextView textview){
        // tạo request
        RequestQueue queue= Volley.newRequestQueue(context);
        // URl
        String url="https://jsonplaceholder.typicode.com/comments";
        // gọi request
        JsonArrayRequest request =new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject person=response.getJSONObject(i);// lấy từng đối tượng

                                String id=person.getString("id");
                                String name=person.getString("name");
                                String email=person.getString("email");
                                strJson+="Id:"+id+"\n";
                                strJson+="Name"+name+"\n";
                                strJson+="Email"+email+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textview.setText(strJson);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText(error.getMessage());
            }
        });

        //thực thi
        queue.add(request);


    }
}
