package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickedItem extends AppCompatActivity {

    ImageView imageView;
    TextView textView,tvCode,tvHarga,tvDesc,tvEmail;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);
        getSupportActionBar().hide();



        imageView = findViewById(R.id.gridimage);
        textView = findViewById(R.id.item_name);
        tvCode = findViewById(R.id.tvCode);
        tvHarga = findViewById(R.id.Harga);
        tvDesc = findViewById(R.id.Descrip);
        tvEmail = findViewById(R.id.tvEmail);


        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });


        Intent intent = getIntent();

        if (intent.getExtras() != null){
            String selectedName = intent.getStringExtra("flowerName");
            String selectedCode = intent.getStringExtra("kodeBarang");
            String selectedHarga = intent.getStringExtra("harga");
            String selectedDesc = intent.getStringExtra("Deskripsi");
            String selectedEmail = intent.getStringExtra("EmailPenjual");
            int selectedImage = intent.getIntExtra("flowerImage", 0);

            tvCode.setText(selectedCode);
            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);
            tvHarga.setText(selectedHarga);
            tvDesc.setText(selectedDesc);
            tvEmail.setText(selectedEmail);
        }


    }
    public void backActivity(){
        Intent intent = new Intent(this,HomeUtamaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);



    }
}