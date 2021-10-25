package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailUbahBarang extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;
    ImageView imgdetail;
    EditText tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ubah_barang);
        getSupportActionBar().hide();

        imgdetail = (ImageView)findViewById(R.id.imgDetailUbahrcv);
        tv1 = (EditText) findViewById(R.id.tvJudulDetailrcv);
        tv2 = (EditText) findViewById(R.id.tvDescUbahDetail);
        tv3 = (EditText) findViewById(R.id.tvKodeBarangUbah);
        tv4 = (EditText) findViewById(R.id.tvHargaDetailRcv);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        button = (Button) findViewById(R.id.btnout4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeUtama();
            }
        });


        imgdetail.setImageResource(getIntent().getIntExtra("gambarbarang",0));
        tv1.setText(getIntent().getStringExtra("judulbarang"));
        tv2.setText(getIntent().getStringExtra("Deskripsi barang"));
        tv3.setText(getIntent().getStringExtra("ubahkodebarang"));
        tv4.setText(getIntent().getStringExtra("hargabrg"));
    }

    public void backActivity(){
        Intent intent = new Intent(this,TambahData.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

    public void HomeUtama(){
        Toast.makeText(this, "Ubah Data Berhasil!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);

        finish();

    }
}