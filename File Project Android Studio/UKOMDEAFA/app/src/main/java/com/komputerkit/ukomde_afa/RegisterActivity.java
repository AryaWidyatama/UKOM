package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {
    private ImageButton imageButton1;
    private Button button,btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        imageButton1 = (ImageButton) findViewById(R.id.imageButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity1();
            }
        });

        button = (Button) findViewById(R.id.btnout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home();
            }
        });

        btnReg = (Button) findViewById(R.id.btnout);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(RegisterActivity.this, "My Notification");
                builder.setContentTitle("Register Anda Berhasil!");
                builder.setContentText("Silahkan Login Menggunakan Akun Yang Telah Anda Buat!");
                builder.setSmallIcon(R.drawable.ic_baseline_cloud_done_24);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(RegisterActivity.this);
                managerCompat.notify(3,builder.build());
                HomeBalik();
            }
        });
    }

    public void backActivity1(){

            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
            finish();



    }

    public void Home(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void HomeBalik(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);


        finish();
    }

}