package com.duy.tieuluan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duy.tieuluan.Model.Food;
import com.duy.tieuluan.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.ItemHolder> {
    Context context;
    ArrayList<Food> arrayfood;

    public AdapterFood(Context context, ArrayList<Food> arrayfood) {
        this.context = context;
        this.arrayfood = arrayfood;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listviewfdmoinhat,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Food food = arrayfood.get(position);
        holder.txttenfd.setText(food.getTenfood());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiafd.setText("Gia: " + decimalFormat.format(food.getGiafood())+ "Đ");
        Picasso.with(context).load(food.getHinhfood())
                .placeholder(R.drawable.noimg)
                .error(R.drawable.erro)
                .into(holder.imghinhfd);
    }

    @Override
    public int getItemCount() {
        return arrayfood.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhfd;
        public TextView txttenfd,txtgiafd;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imghinhfd = itemView.findViewById(R.id.imgeviewfd);
            txtgiafd = itemView.findViewById(R.id.textviewgiafd);
            txttenfd = itemView.findViewById(R.id.textviewtenfd);
        }
    }
}
