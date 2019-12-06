package com.duy.tieuluan.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.duy.tieuluan.Model.Food;
import com.duy.tieuluan.Model.Tenshop;
import com.duy.tieuluan.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    Context context;
    ArrayList<Food> arrayfd;

    public FoodAdapter(Context context, ArrayList<Food> arrayfd) {
        this.context = context;
        this.arrayfd = arrayfd;
    }

    @Override
    public int getCount() {
        return arrayfd.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayfd.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }
    public class ViewHolder{
        public TextView txttenfood,txtgiafood,txtmotafood;
        public ImageView imgfood;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.food_listview,null);
            viewHolder.txttenfood = (TextView) view.findViewById(R.id.txttenfood);
            viewHolder.txtgiafood = (TextView) view.findViewById(R.id.txtgia);
            viewHolder.txtmotafood = (TextView) view.findViewById(R.id.txtmotafood);
            viewHolder.imgfood = (ImageView) view.findViewById(R.id.imgfood);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Food food = (Food) getItem(i);

        viewHolder.txttenfood.setText(food.getTenfood());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiafood.setText("Gia: " + decimalFormat.format(food.getGiafood())+ " Đ");
        viewHolder.txtmotafood.setMaxLines(1);
        viewHolder.txtmotafood.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotafood.setText(food.getMotafood());
        Picasso.with(context).load(food.getHinhfood())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.erro)
                .into(viewHolder.imgfood);
        return view;
    }
}
