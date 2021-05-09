package com.example.mobliyakoltuktakimleri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MH_UrunAdapter extends BaseAdapter {

    private ArrayList<MH_mobilya_urun> MH_urunler;
    Context MH_context;
    Button MH_siparis;

    public MH_UrunAdapter(ArrayList<MH_mobilya_urun> MH_urunler, Context MH_context) {
        this.MH_urunler = MH_urunler;
        this.MH_context = MH_context;
    }
    @Override
    public int getCount() {
        return MH_urunler.size();
    }

    @Override
    public Object getItem(int position) {
        return MH_urunler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder tutucu;
        MH_mobilya_urun MH_urun = (MH_mobilya_urun) getItem(position);

        if (convertView == null)
        {
            tutucu = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(MH_context);
            convertView = inflater.inflate(R.layout.mh_row_items, parent,false);
            tutucu.MH_uResim =convertView.findViewById(R.id.MH_imge_li);
            tutucu.MH_uIsim =convertView.findViewById(R.id.MH_txt_isim_li);
            tutucu.MH_uFiyat =convertView.findViewById(R.id.MH_txt_fiyat_li);
            tutucu.MH_uRengi =convertView.findViewById(R.id.MH_txt_urun_renk_li);
            tutucu.MH_uAyakleri =convertView.findViewById(R.id.MH_txt_ayak_li);
            tutucu.MH_ulaYanindaki =convertView.findViewById(R.id.MH_txt_yanindakiler_li);
             MH_siparis = convertView.findViewById(R.id.MH_btn_siparişVer_li);
            convertView.setTag(tutucu);
        }else
        {
            tutucu = (ViewHolder) convertView.getTag();
        }
        tutucu.MH_uResim.setImageURI(MH_urun.getMH_id_image());
        tutucu.MH_uIsim.setText("Model "+MH_urun.getMH_urun_isim());
        tutucu.MH_uFiyat.setText(String.valueOf(MH_urun.getMH_urun_fiyat()));
        tutucu.MH_uRengi.setText(MH_urun.getMH_urun_renk());
        tutucu.MH_uAyakleri.setText(MH_urun.getMH_urun_ayaklari());
        tutucu.MH_ulaYanindaki.setText(MH_urun.getMh_urun_yanindakiler());

        MH_siparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MH_context, MH_urun.getMH_urun_isim()+" Siparişiniz Alınmıştır....", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    private static class ViewHolder{
        ImageView MH_uResim;
        TextView MH_uIsim;
        TextView MH_uFiyat;
        TextView MH_uRengi;
        TextView MH_uAyakleri;
        TextView MH_ulaYanindaki;
    }


}
