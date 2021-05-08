package com.example.mobliyakoltuktakimleri;

import java.util.ArrayList;

public class MH_veriTabani {
     static ArrayList<MH_mobilya_urun> MH_urun;


    public static ArrayList<MH_mobilya_urun> getMH_urun() {
        return MH_urun;
    }

    public static void setMH_urun(ArrayList<MH_mobilya_urun> MH_urun) {
        MH_veriTabani.MH_urun = MH_urun;
    }
}
