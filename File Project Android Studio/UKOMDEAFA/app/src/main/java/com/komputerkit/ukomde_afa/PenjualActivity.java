package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PenjualActivity extends AppCompatActivity {

    Button btntambah,btnhapus,btnubah,btnkeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjual);
        getSupportActionBar().hide();

        btnubah = (Button) findViewById(R.id.btnubah);
        btnubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UbahData();
            }
        });

        btntambah = (Button) findViewById(R.id.btntambah);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tambahdata();
            }
        });
        btnhapus = (Button) findViewById(R.id.btnhapus);
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HapusData();
            }
        });

        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeluarData();
            }
        });


    }
    public void UbahData(){
        Intent intent = new Intent(this,TambahData.class);
        startActivity(intent);

    }

    public void Tambahdata(){
        Intent intent = new Intent(this,DaftarBaruDataProduk.class);
        startActivity(intent);
    }
    public void HapusData(){
        Intent intent = new Intent(this,KurangData.class);
        startActivity(intent);
    }

    public void KeluarData(){
        Intent intent = new Intent(this,InfoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}