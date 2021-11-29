package com.komputerkit.ukomde_afa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHapusBarang extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button;
    public static final String EXTRA_DATA = "string_extra";
    ImageView imgdetail;
    ApiMenuInterface mApiInterface;
    String tittle,overview;
    TextView tv1,tv2,tv3,tv4;
    dataMenu dataMenu;
    private int idkategori;

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

        Intent mIntent = getIntent();
        imgdetail = (ImageView) findViewById(R.id.imgDetailUbahrcv);
        tv1 = (TextView) findViewById(R.id.idKaaategoriUbah);
        tv2 = (TextView) findViewById(R.id.KodeUbah);
        tv3 = (TextView) findViewById(R.id.tvKodeBarangUbah);
        tv4 = (TextView) findViewById(R.id.tvHargaDetailRcv);
        dataMenu = getIntent().getParcelableExtra(EXTRA_DATA);



//        imgdetail.setImageResource(getIntent().getIntExtra("gambarbarang", 0));
//        tv1.setText(mIntent.getStringExtra("Id"));

        tv1.setText(String.valueOf(mIntent.getStringExtra("Nama")));
//        tv2.setText(mIntent.getStringExtra("desc"));
        tv4.setText(mIntent.getStringExtra("Alamat"));
        Glide.with(DetailHapusBarang.this)
                .load("" + mIntent.getStringExtra("gambarbarang"))
                .apply(new RequestOptions().override(350, 550))
                .into(imgdetail);

        tv3.setText(mIntent.getStringExtra("kode"));

//        tv3.setText(getIntent().getStringExtra("ubahkodebarang"));
//        tv4.setText(getIntent().getStringExtra("harga"));

//        if (tv2.equals("")) {
//
//            tv2.setText(mIntent.getStringExtra("idkategori"));
//            idkategori = Integer.parseInt(tv2.getText().toString());
//
//        }


//



        button = (Button) findViewById(R.id.btnout4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setTag(tv2.getKeyListener());
            tv2.setKeyListener(null);
                tv2.setText(Integer.toString(mIntent.getIntExtra("idmenu",0)));


//                pd.setMessage("Loading Hapus ...");
//                pd.setCancelable(false);
//                pd.show();
                mApiInterface = ApiClient.getClient().create(ApiMenuInterface.class);
                String npm = tv2.getText().toString();




//

// gagl hapus data
                Integer id = getIntent().getIntExtra("idmenu",0);
                    ApiMenuInterface api = ApiClient.getClient().create(ApiMenuInterface.class);
                    Call<dataMenu> del = api.PostputDel(id);
                    del.enqueue(new Callback<dataMenu>() {
                        @Override
                        public void onResponse(Call<dataMenu> call, Response<dataMenu> response) {
                            Log.d("Retro", "onResponse"+call);

//                        Toast.makeText(DetailHapusBarang.this, "Succes", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(DetailHapusBarang.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            Intent gotampil = new Intent(DetailHapusBarang.this, PenjualActivity.class);

                            startActivity(gotampil);
                            finish();

                        }

                        @Override
                        public void onFailure(Call<dataMenu> call, Throwable t) {
//                        pd.hide();
                            Log.d("Retro", "onFailure");

                            Toast.makeText(DetailHapusBarang.this, "tes :"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    });

//                if (idkategori.getText().length().trim().isEmpty()==false){
//                    Call<PostPutDel> deleteKontak = mApiInterface.deleteKontak(tv2.getText().charAt(id));
//                    deleteKontak.enqueue(new Callback<PostPutDel>() {
//                        @Override
//                        public void onResponse(Call<PostPutDel> call, Response<PostPutDel> response) {
//                            KurangData.ma.refresh();
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Call<PostPutDel> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                }
//            }





            }
        });


    }



    public void backActivity(){
        Intent intent = new Intent(this,KurangData.class);
        startActivity(intent);
        overridePendingTransition(R.anim.kanan, R.anim.kanan1);
        finish();


    }

    public void HomeUtama() {

        Toast.makeText(this, "Hapus Data Berhasil!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PenjualActivity.class);
        startActivity(intent);

        finish();

            }
}