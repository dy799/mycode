package com.duy.tieuluan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.duy.tieuluan.Adapter.FoodAdapter;
import com.duy.tieuluan.ultil.Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Food extends AppCompatActivity {

    Toolbar toolbarfd;
    ListView lvfd;
    FoodAdapter foodAdapter;
    ArrayList<Food> mangfd;
    int idfood = 0;
    int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Anhxa();
        Getidtenshop();
        ActionToolbar();
        GetData (page);
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanfood+String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tenfd = "";
                int Giafd = 0;
                String Hinhanhfd = "";
                String Mota = "";
                int Idspfd = 0;
                if (response!=null){


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String, String>();
                param.put("key",String.valueOf(idfood));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolbar() {
        //setSupportActionBar(toolbarfd);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        toolbarfd.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Getidtenshop() {
        idfood = getIntent().getIntExtra("key",-1);
        Log.d("giatritenshop",idfood+"");
    }

    private void Anhxa() {
        toolbarfd = findViewById(R.id.toolbarfood);
        lvfd = findViewById(R.id.lvfood);
        mangfd = new ArrayList<>();
        //foodAdapter = new FoodAdapter(getApplicationContext(),mangfd);
        lvfd.setAdapter(foodAdapter);


    }
}
