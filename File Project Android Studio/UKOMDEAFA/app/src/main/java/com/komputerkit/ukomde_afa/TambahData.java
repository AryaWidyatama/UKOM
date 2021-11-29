package com.komputerkit.ukomde_afa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahData extends AppCompatActivity {

    private ImageButton imageButton;
    ApiMenuInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static TambahData ma;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        getSupportActionBar().hide();

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiMenuInterface.class);
        ma=this;

        RecyclerView recyclerView = findViewById(R.id.recycleView);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        DataPenjual[] DataPenjual = new DataPenjual[]{
//                new DataPenjual("Fresh Flower Box","- Mix fresh flower & custom box or bamboo bag or etc" +
//                        "2. Data Penjelasan paket ",R.drawable.b1,"A0006","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//                new DataPenjual("tes","tes",R.drawable.b1,"t12","Rp.215000"),
//        };
//
//        DataPenjualAdapter mydatapenjualadapter = new DataPenjualAdapter(DataPenjual,TambahData.this);
//        recyclerView.setAdapter(mydatapenjualadapter);

         panggilRetrofit();

    }

    public void panggilRetrofit(){
        Call<GetDaataMenu> kontakCall = mApiInterface.getMenu();
        kontakCall.enqueue(new Callback<GetDaataMenu>() {
            @Override
            public void onResponse(Call<GetDaataMenu> call, Response<GetDaataMenu>
                    response) {
                List<dataMenu> KontakList = response.body().getData();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(KontakList.size()));
                mAdapter = new DataPenjualAdapter(KontakList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetDaataMenu> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void backActivity(){
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

}