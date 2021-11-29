package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ClickedItem extends AppCompatActivity {

    ImageView imageView;
    TextView textView,tvCode,tvHarga,tvDesc,tvEmail,tvNomor;
    private ImageButton imageButton;
    Button b1;


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
        tvEmail = findViewById(R.id.tvPasswordDaftaar);
        tvNomor = findViewById(R.id.tvNomor);


        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });








        Intent intent = getIntent();



        if (intent.getExtras() != null){
            String selectedName = intent.getStringExtra("name");
            String selectedCode = intent.getStringExtra("kode");
            String selectedHarga = intent.getStringExtra("harga");
            String setNomerWa = intent.getStringExtra("nomor");
            String selectedDesc = intent.getStringExtra("desc");
            String selectedEmail = intent.getStringExtra("email");
            String selectedImage = intent.getStringExtra("gambar");

            tvCode.setText(selectedCode);
            textView.setText(selectedName);
//            imageView.setImageResource(selectedImage);
            Glide.with(this)
                    .load(selectedImage)
//                    .apply(new RequestOptions().override(350, 550))
                    .into(imageView);
            tvHarga.setText(selectedHarga);
            tvDesc.setText(selectedDesc);
            tvEmail.setText(selectedEmail);
            tvNomor.setText(setNomerWa);

            Button b1;
            b1 = findViewById(R.id.btnWa);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nomor = tvNomor.getText().toString();
                    String deskripsi = tvDesc.getText().toString();
                    String barang = textView.getText().toString();
                    String harga = tvHarga.getText().toString();
                    String code = tvCode.getText().toString();
                    boolean installed = appInstalledOrNot("com.whatsapp");

                    if (installed){
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+62"+nomor+"&text="+"- Judul Barang : "+barang+"\n"+"- Deskripsi : "+deskripsi+"\n"+"- Kode Barang : "+code+"\n"+"- Harga : "+harga));
                        startActivity(intent1);
                    }else {
                        Intent mIntent = new Intent(ClickedItem.this,HomeActivity.class);
                        startActivity(mIntent);
                        Toast.makeText(ClickedItem.this, "ye", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }


    }

    private boolean appInstalledOrNot(String url){
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }catch (PackageManager.NameNotFoundException e){ Toast.makeText(this, "ye", Toast.LENGTH_SHORT).show();
            app_installed = false;
        }
        return app_installed;
    }

    public void backActivity(){
        Intent intent = new Intent(this,HomeUtamaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);



    }
}