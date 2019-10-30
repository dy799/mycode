package com.duy.tieuluan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.duy.tieuluan.Adapter.AdapterFood;
import com.duy.tieuluan.Model.Food;
import com.duy.tieuluan.ultil.Server;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView txtFullName;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Food> mangfd;
    AdapterFood adapterFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Anhxa();
        Getdulieumoinhat();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCart = new Intent(Home.this, Cart.class);
                startActivity(intentCart);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void Getdulieumoinhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdanfdmonhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    int ID = 0;
                    String Tenfood = "";
                    Integer Giafood = 0;
                    String Hinhfood = "";
                    String Motafood = "";
                    int IDfood = 0;
                    for ( int i = 0; i <response.length();i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tenfood = jsonObject.getString("tenfd");
                            Giafood = jsonObject.getInt("giafd");
                            Hinhfood = jsonObject.getString("hinhfd");
                            Motafood = jsonObject.getString("motafd");
                            IDfood = jsonObject.getInt("idfd");
                            mangfd.add(new Food(ID,Tenfood,Giafood,Hinhfood,Motafood,IDfood));
                            adapterFood.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void Anhxa() {
        recyclerView = findViewById(R.id.recyclerView);
        mangfd = new ArrayList<>();
        adapterFood = new AdapterFood(getApplicationContext(),mangfd);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(adapterFood);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
        } else if (id == R.id.nav_cart) {
            Intent orderIntent = new Intent(Home.this,Cart.class);
            startActivity(orderIntent);
        } else if (id == R.id.nav_order) {
            Intent cartIntent = new Intent(Home.this, Shop.class);
            startActivity(cartIntent);
        } else if (id == R.id.nav_map) {
            Intent mapIntent = new Intent(Home.this,Map.class);
            startActivity(mapIntent);
        } else if (id == R.id.nav_exit) {
            Intent signIn = new Intent(Home.this, SignIn.class);

            startActivity(signIn);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
