package com.duy.tieuluan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.duy.tieuluan.Model.Tenshop;
import com.duy.tieuluan.Model.TraSua;
import com.duy.tieuluan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TraSuaAdapter extends BaseAdapter {
    Context context;
    ArrayList<TraSua> arraylisttrasua;

    public TraSuaAdapter(ArrayList<TraSua> arraylisttrasua, Context context) {
        this.arraylisttrasua = arraylisttrasua;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylisttrasua.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylisttrasua.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    private class ViewHolder{
        TextView txttendoan ,txttencuahang, txtgia, txtdiachi;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.trasua_listview,null);
            viewHolder.txttendoan = (TextView) view.findViewById(R.id.txttendoan);
            viewHolder.txttencuahang = (TextView) view.findViewById(R.id.txttencuahang);
            viewHolder.txtgia = (TextView) view.findViewById(R.id.txtgia);
            viewHolder.txtdiachi = (TextView) view.findViewById(R.id.txtdiachi);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Tenshop tenshop = (Tenshop) getItem(i);

       // viewHolder.txttenshop.setText(tenshop.getTenshop());
        //Picasso.with(context).load(tenshop.getHinhshop())
        //        .placeholder(R.drawable.bg)
       //         .error(R.drawable.background)
      //          .into(viewHolder.imagetenshop);
        return view;

    }
}
