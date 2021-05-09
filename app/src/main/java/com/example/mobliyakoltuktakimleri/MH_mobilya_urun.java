package com.example.mobliyakoltuktakimleri;

import android.net.Uri;

import java.io.Serializable;

public class MH_mobilya_urun implements Serializable {
    Uri MH_id_image;
    String MH_urun_isim;
    int MH_urun_fiyat;
    String MH_urun_renk;
    String MH_urun_ayaklari;
    String Mh_urun_yanindakiler;

    public MH_mobilya_urun(Uri MH_id_image, String MH_urun_isim, int MH_urun_fiyat, String MH_urun_renk,//
                           String MH_urun_ayaklari, String mh_urun_yanindakiler) {
        this.MH_id_image = MH_id_image;
        this.MH_urun_isim = MH_urun_isim;
        this.MH_urun_fiyat = MH_urun_fiyat;
        this.MH_urun_renk = MH_urun_renk;
        this.MH_urun_ayaklari = MH_urun_ayaklari;
        this.Mh_urun_yanindakiler = mh_urun_yanindakiler;
    }

    public Uri getMH_id_image() {
        return MH_id_image;
    }

    public void setMH_id_image(Uri MH_id_image) {
        this.MH_id_image = MH_id_image;
    }

    public String getMH_urun_isim() {
        return MH_urun_isim;
    }

    public void setMH_urun_isim(String MH_urun_isim) {
        this.MH_urun_isim = MH_urun_isim;
    }

    public int getMH_urun_fiyat() {
        return MH_urun_fiyat;
    }

    public void setMH_urun_fiyat(int MH_urun_fiyat) {
        this.MH_urun_fiyat = MH_urun_fiyat;
    }

    public String getMH_urun_renk() {
        return MH_urun_renk;
    }

    public void setMH_urun_renk(String MH_urun_renk) {
        this.MH_urun_renk = MH_urun_renk;
    }

    public String getMH_urun_ayaklari() {
        return MH_urun_ayaklari;
    }

    public void setMH_urun_ayaklari(String MH_urun_ayaklari) {
        this.MH_urun_ayaklari = MH_urun_ayaklari; }

    public String getMh_urun_yanindakiler() {
        return Mh_urun_yanindakiler;
    }

    public void setMh_urun_yanindakiler(String mh_urun_yanindakiler) {
        Mh_urun_yanindakiler = mh_urun_yanindakiler; }
}
