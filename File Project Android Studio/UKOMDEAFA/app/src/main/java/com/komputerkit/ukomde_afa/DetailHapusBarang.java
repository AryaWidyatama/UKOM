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

public class DetailHapusBarang extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;
    ImageView imgdetail;
    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hapus_barang);
        getSupportActionBar().hide();

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

        imgdetail = (ImageView)findViewById(R.id.imgDetailUbahrcv);
        tv1 = (TextView) findViewById(R.id.tvJudulDetailrcv);
        tv2 = (TextView) findViewById(R.id.tvDescUbahDetail);
        tv3 = (TextView) findViewById(R.id.tvKodeBarangUbah);
        tv4 = (TextView) findViewById(R.id.tvHargaDetailRcv);


        imgdetail.setImageResource(getIntent().getIntExtra("gambarbarang",0));
        tv1.setText(getIntent().getStringExtra("judulbarang"));
        tv2.setText(getIntent().getStringExtra("Deskripsi barang"));
        tv3.setText(getIntent().getStringExtra("ubahkodebarang"));
        tv4.setText(getIntent().getStringExtra("hargabrg"));
    }

    public void backActivity(){
        Intent intent = new Intent(this,KurangData.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

    public void HomeUtama(){
        Toast.makeText(this, "Hapus Data Berhasil!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);

        finish();

    }
}