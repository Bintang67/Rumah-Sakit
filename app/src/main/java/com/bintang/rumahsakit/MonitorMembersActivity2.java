package com.bintang.rumahsakit;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MonitorMembersActivity2 extends AppCompatActivity {

    ArrayList<String> semua = new ArrayList<>();
    ArrayList<String> tampil = new ArrayList<>();
    ArrayAdapter<String> adapter;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_members2);

        tvTotal = findViewById(R.id.tvTotal);
        ListView lvMembers = findViewById(R.id.lvMembers);
        Button btnSemua = findViewById(R.id.btnSemua);
        Button btnResepsionis = findViewById(R.id.btnResepsionis);
        Button btnPerawat = findViewById(R.id.btnPerawat);
        Button btnDokter = findViewById(R.id.btnDokter);

        // data contoh: nama - peran
        semua.add("Rina Wulandari - Resepsionis");
        semua.add("Tono Prasetyo - Resepsionis");
        semua.add("Siti Aminah - Perawat");
        semua.add("Budi Santoso - Perawat");
        semua.add("Dewi Lestari - Perawat");
        for (String d : DataStore.dokter) {
            String nama = d.split(" - ")[0];
            semua.add(nama + " - Dokter");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tampil);
        lvMembers.setAdapter(adapter);

        tampilkan("");

        btnSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkan("");
            }
        });

        btnResepsionis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkan("Resepsionis");
            }
        });

        btnPerawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkan("Perawat");
            }
        });

        btnDokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tampilkan("Dokter");
            }
        });
    }

    // role kosong = tampilkan semua
    private void tampilkan(String role) {
        tampil.clear();
        for (String s : semua) {
            if (role.equals("") || s.endsWith(role)) {
                tampil.add(s);
            }
        }
        adapter.notifyDataSetChanged();
        tvTotal.setText("Total: " + tampil.size());
    }
}