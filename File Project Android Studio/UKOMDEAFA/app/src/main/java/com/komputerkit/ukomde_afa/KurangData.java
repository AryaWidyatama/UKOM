package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KurangData extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurang_data);
        getSupportActionBar().hide();


        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataPenjual[] DataPenjual = new DataPenjual[]{
                new DataPenjual("Fresh Flower Box","- Mix fresh flower & custom box or bamboo bag or etc" +
                        "2. Data Penjelasan paket ",R.drawable.b1,"A0006","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
        };

        KurangDataAdapter mydatapenjualadapter = new KurangDataAdapter(DataPenjual,KurangData.this);
        recyclerView.setAdapter(mydatapenjualadapter);



    }

    public void backActivity(){
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }
}