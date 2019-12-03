package com.duy.tieuluan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.duy.tieuluan.Adapter.AdapterFood;
import com.duy.tieuluan.Model.Food;
import com.duy.tieuluan.Model.Tenshop;
import com.duy.tieuluan.ultil.KiemTraInternet;
import com.duy.tieuluan.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.duy.tieuluan.R.id.btnSignIn;
import static com.duy.tieuluan.R.id.recyclerView;

public class MainActivity extends AppCompatActivity {

    Button btntrasua,btnmicay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btntrasua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Shop.class);
                startActivity(intent);
            }
        });
        btnmicay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MiCay.class);
                startActivity(intent);
            }
        });
    }


    protected void AnhXa (){
        btntrasua = (Button) findViewById(R.id.btntrasua);
        btnmicay = (Button) findViewById(R.id.btnmicay);



    }

}
