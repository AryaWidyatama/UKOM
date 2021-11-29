package com.komputerkit.ukomde_afa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private Button buttonout,btnpjl;
    TextView user,telp;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
        user = findViewById(R.id.username_info);
        telp = findViewById(R.id.telp_info);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String value = getIntent().getStringExtra("user");
            String value1 = getIntent().getStringExtra("telp");
            user.setText(value);
            telp.setText(value1);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });



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
                        startActivity(new Intent(getApplicationContext()
                                ,HomeUtamaActivity.class));
//                        Intent intent1 = new Intent(InfoActivity.this,HomeUtamaActivity.class);
//                        intent1.putExtra("userH",bundle);
//                        startActivity(intent1);

                        overridePendingTransition(0,0);

                        return true;
                    case R.id.info1:

                        return true;

                }
                return false;
            }
        });

        buttonout = (Button) findViewById(R.id.button4);
        buttonout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();



            }
        });

        btnpjl = (Button) findViewById(R.id.btnpjl);
        btnpjl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPenjual();
            }
        });




    }
    public void OutBack(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);


        finish();
    }

    public void openPenjual(){
        Intent intent = new Intent(this,PenjualActivity.class);
        startActivity(intent);
    }

    public void openDialog(){
        dialog=new Dialog(this);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_out);




        Button btnoke=dialog.findViewById(R.id.btniya);
        btnoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(InfoActivity.this, "My Notification");
                builder.setContentTitle("Anda Telah Keluar!");
                builder.setContentText("Silahkan Login Kembali");
                builder.setSmallIcon(R.drawable.ic_baseline_login_24);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(InfoActivity.this);
                managerCompat.notify(2,builder.build());
                Intent intent = new Intent(InfoActivity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        Button btntidak=dialog.findViewById(R.id.btntidak);
        btntidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

        dialog.show();
    }

    public void backActivity(){
        Intent intent = new Intent(this,HomeUtamaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

}