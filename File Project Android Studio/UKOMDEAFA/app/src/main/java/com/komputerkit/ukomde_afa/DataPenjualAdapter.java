package com.komputerkit.ukomde_afa;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DataPenjualAdapter extends RecyclerView.Adapter<DataPenjualAdapter.ViewHolder> {
    DataPenjual[] DataPenjual;
    Context context;
    public DataPenjualAdapter(DataPenjual[] DataPenjual,TambahData activity) {
        this.DataPenjual = DataPenjual;
        this.context = activity;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        final DataPenjual myDatalist = DataPenjual[position];
        holder.tvHargabrg.setText(myDatalist.getHargaBarang());
        holder.tvjudulrcv.setText(myDatalist.getJudulBarang());
        holder.tvdescrcv.setText(myDatalist.getDescBarang());
        holder.tvkodebrg.setText(myDatalist.getKodeBarang());
        holder.imgviewrcv.setImageResource(myDatalist.getGambarBarang());


       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(context,DetailUbahBarang.class);
               intent.putExtra("gambarbarang",myDatalist.getGambarBarang());
               intent.putExtra("judulbarang",myDatalist.getJudulBarang());
               intent.putExtra("Deskripsi barang",myDatalist.getDescBarang());
               intent.putExtra("ubahkodebarang",myDatalist.getKodeBarang());
               intent.putExtra("hargabrg",myDatalist.getHargaBarang());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);


           }
       });
    }

    @Override
    public int getItemCount() {
        return DataPenjual.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView imgviewrcv;
        TextView tvjudulrcv;
        TextView tvdescrcv;
        CardView cardView;
        TextView tvkodebrg;
        TextView tvHargabrg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgviewrcv = itemView.findViewById(R.id.imgviewrcv);
            tvjudulrcv = itemView.findViewById(R.id.tvjudulrcv);
            tvdescrcv = itemView.findViewById(R.id.tvdescrcv);
            cardView = itemView.findViewById(R.id.cardview3);
            tvkodebrg = itemView.findViewById(R.id.tvKodebrg);
            tvHargabrg = itemView.findViewById(R.id.tvHargabrg);
        }


    }



}
