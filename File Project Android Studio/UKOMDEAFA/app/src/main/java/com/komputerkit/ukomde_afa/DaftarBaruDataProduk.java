package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DaftarBaruDataProduk extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_baru_data_produk);
        getSupportActionBar().hide();

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        button = (Button) findViewById(R.id.btnout5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeUtama();
            }
        });


    }

    public void backActivity(){
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

    public void HomeUtama(){
        Toast.makeText(this, "Unggah Data Berhasil!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);

        finish();

    }
}