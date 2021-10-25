package com.komputerkit.ukomde_afa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeUtamaActivity extends AppCompatActivity {

    GridView gridView;
    Button button;

    String[] flowerName = {"Fresh Flower Box","Dry Flower Box","Paket Bouqet 3","Chocolate bouqet","Paket Bouqet 5","Paket Bouqet 6","Paket Bouqet 7","Paket Bouqet 8","Paket Bouqet 9","Paket Bouqet 10","Paket Bouqet 11","Paket Bouqet 12","Paket Bouqet 13"};
    String[] harga = {"Rp.187000","Rp.195000","Rp.25000","Rp.150000","Rp.24000","Rp.24000","Rp.24000","Rp.24000","Rp.24000","Rp.40000","Rp.56000","Rp12050","Rp.675888"};
    String[] Deskripsi = {"- Mix fresh flower & custom box or bamboo bag or etc" +
            "2. Data Penjelasan paket ","- Mix dry flower & custom 4 white fresh flower","Ferero bouqet + babybreath ( bisa diganti jenis coklat lain )","Ferero bouqet + babybreath ( bisa diganti jenis coklat lain )","Deskrip12","Deskrip1","Deskrip1","Deskrip134","Deskrip1","Deskrip1"};
     String[] kodeBarang = {"MM0006","MM0002","gahsf56","B003","gahsf56","gahsf56","gahsf56","gahsf56","gahsf56","asjdgsao","764bduhs","sdvasud","ajsdg45"};
     String[] EmailPenjual = {"deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com","deafaofficial@gmail.com"};
     int[] flowerImages = {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_utama);
        getSupportActionBar().hide();

        gridView = findViewById(R.id.grid_view);
        GridAdapter adapter = new GridAdapter(HomeUtamaActivity.this,flowerName,flowerImages);
        gridView.setAdapter(adapter);





        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = flowerName[i];
                int selectedImage = flowerImages[i];
                String selectedCode = kodeBarang[i];
                String selectedHarga = harga[i];
                String selectedDesc = Deskripsi[i];
                String selectedEmail = EmailPenjual[i];
                startActivity(new Intent(HomeUtamaActivity.this,ClickedItem.class).putExtra("flowerName",selectedName).putExtra("flowerImage",selectedImage).putExtra("kodeBarang",selectedCode).putExtra("harga",selectedHarga).putExtra("Deskripsi",selectedDesc).putExtra("EmailPenjual",selectedEmail));
            }
        });

        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setSelectedItemId(R.id.home1);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.pesan:
                        startActivity(new Intent(getApplicationContext()
                                ,PemesananActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home1:

                        return true;
                    case R.id.info1:
                        startActivity(new Intent(getApplicationContext()
                                ,InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });




    }
}