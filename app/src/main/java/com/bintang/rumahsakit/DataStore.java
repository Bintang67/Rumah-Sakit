package com.bintang.rumahsakit;

import java.util.ArrayList;

public class DataStore {

    // daftar dokter, dipakai bersama oleh Kelola dan Pantau
    public static ArrayList<String> dokter = new ArrayList<>();

    static {
        dokter.add("dr. Andre - Spesialis Anak");
        dokter.add("dr. Sinta - Penyakit Dalam");
    }
}