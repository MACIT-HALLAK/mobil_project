package com.example.mobliyakoltuktakimleri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MH_MainActivity extends AppCompatActivity {

    EditText MH_urunAdi,MH_urunFiyat;
    Spinner MH_urunRengi;
    RadioGroup MH_ayakModeli;
    RadioButton MH_ahsap,MH_metal;
    CheckBox MH_masa,MH_berjer;
    Button MH_liste,MH_fotoCek;
    String MH_ayak;
    String MH_str="";
    ArrayList<MH_mobilya_urun> MH_urunler;

    private static final int MH_PERMISSIN_CODE =1000 ;
    private int MH_IMAGE_Cap = 1001;
    int MH_foto_drawable_cek,MH_sayac=0;
    ImageView MH_fotoYeri;
    Uri MH_imge_uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MH_urunAdi = findViewById(R.id.MH_etxt_urun_isim);
        MH_urunFiyat = findViewById(R.id.MH_etxt_urun_fiyat);
        MH_urunRengi = findViewById(R.id.MH_sp_urun_rengi);
        MH_ayakModeli = findViewById(R.id.MH_rg_ayak_turu);
        MH_masa = findViewById(R.id.MH_cb_masa);
        MH_berjer = findViewById(R.id.MH_cb_berjer);
        MH_masa = findViewById(R.id.MH_cb_masa);
        MH_berjer = findViewById(R.id.MH_cb_berjer);
        MH_urunler = new ArrayList<MH_mobilya_urun>();

        MH_liste=findViewById(R.id.MH_btn_liste);
        MH_liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh_gecis = new Intent(MH_MainActivity.this, MH_listeleme.class);
                MH_veriTabani.MH_urun = MH_urunler;
                startActivity(mh_gecis);
            }
        });
        MH_fotoYeri= findViewById(R.id.MH_image_yeri);
        MH_fotoCek=findViewById(R.id.MH_btn_resimC);
        MH_fotoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, MH_PERMISSIN_CODE);
                    } else {
                        openCamera();
                    }
                } else {
                    openCamera();
                }
            }
        });
    }
    private void openCamera() {
        ContentValues value =new ContentValues();
        value.put(MediaStore.Images.Media.TITLE,"new Picture");
        value.put(MediaStore.Images.Media.DESCRIPTION,"from the camera");
        MH_imge_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,value);
        Intent  camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,MH_imge_uri);
        startActivityForResult(camera,MH_IMAGE_Cap);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){

            case MH_PERMISSIN_CODE:{
                if (grantResults.length>0 && grantResults[0]==
                        PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }else{

                    Toast.makeText(this, "camera izin verilmedi", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            MH_fotoYeri.setImageURI(MH_imge_uri);

        }
    }
    public void MH_urun_ekle(View view) {
        MH_ayak = ((RadioButton)(findViewById(MH_ayakModeli.getCheckedRadioButtonId()))).getText().toString();
        if (MH_masa.isChecked())
            MH_str="Masa ";
        if (MH_berjer.isChecked())
            MH_str +="Berjer";

        if (Integer.parseInt(MH_urunFiyat.getText().toString()) < 0){
            Toast.makeText(getApplicationContext(), "Fiyat Negatif Olamaz "
                    ,Toast.LENGTH_SHORT).show();
        }else {
                MH_sayac++;
                if ( MH_sayac==1)
                MH_foto_drawable_cek = R.drawable.koltuk6;
                if ( MH_sayac==2)
                    MH_foto_drawable_cek = R.drawable.koltuk2;
                if ( MH_sayac==3)
                   MH_foto_drawable_cek = R.drawable.kolttuk3;
                if ( MH_sayac==4)
                     MH_foto_drawable_cek = R.drawable.koltuk7;

            MH_urunler.add(new MH_mobilya_urun(MH_foto_drawable_cek,MH_urunAdi.getText().toString(),
                    Integer.parseInt(MH_urunFiyat.getText().toString()),MH_urunRengi.getSelectedItem().toString(),
                    MH_ayak.toString(),MH_str));
            Toast.makeText(getApplicationContext(), "Ürün sayısı: "
                            + MH_urunler.size() + " Eklenen: " + MH_urunler.get(MH_urunler.size() - 1).getMH_urun_isim()
                    , Toast.LENGTH_SHORT).show();
            MH_str="";
        }
    }
}