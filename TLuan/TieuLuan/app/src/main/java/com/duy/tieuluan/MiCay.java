package com.duy.tieuluan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.duy.tieuluan.Adapter.AdapterTenshop;
import com.duy.tieuluan.Adapter.TraSuaAdapter;
import com.duy.tieuluan.Model.Tenshop;
import com.duy.tieuluan.ultil.KiemTraInternet;
import com.duy.tieuluan.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MiCay extends AppCompatActivity {
    ListView lvshop;
    ArrayList<Tenshop> mangtenshop;
    AdapterTenshop adapterTenshop;
    int idfd = 0;
    String tenfd = "";
    String hinhfd = "";
    int giafd = 0;
    String motafood = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cay);
        Anhxa();
        if (KiemTraInternet.haveNetworkConnection(getApplicationContext())) {
            Getdltenshop();
        } else {
            KiemTraInternet.ShowToast_Short(getApplicationContext(), "Hãy kiểm tra lại kết nối");
            finish();
        }
    }

    private void Anhxa() {
        lvshop = (ListView) findViewById(R.id.listshop);
        mangtenshop = new ArrayList<>();
        adapterTenshop = new AdapterTenshop(mangtenshop, getApplicationContext());
        lvshop.setAdapter(adapterTenshop);
    }


    private void Getdltenshop() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanmicay, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            idfd = jsonObject.getInt("idmicay");
                            tenfd = jsonObject.getString("tenmicay");
                            hinhfd = jsonObject.getString("hinhmicay");
                            giafd = jsonObject.getInt("giamicay");
                            motafood = jsonObject.getString("diachimicay");
                            mangtenshop.add(new Tenshop(idfd, tenfd, hinhfd, giafd, motafood));
                            adapterTenshop.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                KiemTraInternet.ShowToast_Short(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}