package com.duy.tieuluan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.duy.tieuluan.Adapter.AdapterTenshop;
import com.duy.tieuluan.Adapter.TraSuaAdapter;
import com.duy.tieuluan.Model.Tenshop;

import java.util.ArrayList;

public class TraSua extends AppCompatActivity {
    ListView lvtrasua;
    ArrayList<TraSua> arraylisttrasua;
    TraSuaAdapter TraSuaAdapter;
    int id = 0;
    String tendoan = "";
    String tencuahang = "";
    int gia = 0;
    String diachi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_sua);
        Anhxa();
    }

    private void Anhxa() {
        lvtrasua = (ListView) findViewById(R.id.listtrasua);
        arraylisttrasua = new ArrayList<>();
        //TraSuaAdapter = new TraSuaAdapter(arraylisttrasua,getApplicationContext());
        lvtrasua.setAdapter(TraSuaAdapter);
    }
}
