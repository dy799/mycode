package com.duy.tieuluan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.duy.tieuluan.Model.Tenshop;
import com.duy.tieuluan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterTenshop extends BaseAdapter {
    Context context;
    ArrayList<Tenshop> arraylisttenshop;

    public AdapterTenshop(ArrayList<Tenshop> arraylisttenshop, Context context) {
        this.arraylisttenshop = arraylisttenshop;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylisttenshop.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylisttenshop.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }
    private class ViewHolder{
        TextView txttenshop,txtgiafood, txtmotafood;
        ImageView imagetenshop;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.food_listview,null);
            viewHolder.txttenshop = (TextView) view.findViewById(R.id.txttenfood);
            viewHolder.imagetenshop = (ImageView) view.findViewById(R.id.imgfood);
            viewHolder.txtgiafood = (TextView) view.findViewById(R.id.txtgia);
            viewHolder.txtmotafood = (TextView) view.findViewById(R.id.txtmotafood);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Tenshop tenshop = (Tenshop) getItem(i);

        viewHolder.txttenshop.setText(tenshop.getTenshop());
        viewHolder.txtmotafood.setText(tenshop.getMotafd());

        //viewHolder.txtgiafood.setText(tenshop.getGia());
        Picasso.with(context).load(tenshop.getHinhshop())
                .placeholder(R.drawable.bg)
                .error(R.drawable.background)
                .into(viewHolder.imagetenshop);
        return view;
    }
}