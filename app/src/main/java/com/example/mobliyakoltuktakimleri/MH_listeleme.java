package com.example.mobliyakoltuktakimleri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MH_listeleme extends AppCompatActivity {
    ListView MH_liste_li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_h_listeleme);

        MH_liste_li =findViewById(R.id.MH_liste);

        ArrayList<MH_mobilya_urun> MH_Urun = MH_veriTabani.MH_urun;

        Toast.makeText(MH_listeleme.this, MH_Urun.get(0).getMH_urun_isim()+"", Toast.LENGTH_SHORT).show();


        MH_UrunAdapter MH_adapter = new MH_UrunAdapter(MH_Urun,MH_listeleme.this);
        MH_liste_li.setAdapter(MH_adapter);

    }
}