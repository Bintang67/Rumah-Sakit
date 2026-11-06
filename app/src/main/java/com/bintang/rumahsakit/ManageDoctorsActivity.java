package com.bintang.rumahsakit;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ManageDoctorsActivity extends AppCompatActivity {

    EditText etNamaDokter, etSpesialis;
    ListView lvDoctors;
    ArrayList<String> data = DataStore.dokter;
    ArrayAdapter<String> adapter;
    int dipilih = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_doctors);

        etNamaDokter = findViewById(R.id.etNamaDokter);
        etSpesialis = findViewById(R.id.etSpesialis);
        lvDoctors = findViewById(R.id.lvDoctors);
        Button btnTambah = findViewById(R.id.btnTambah);
        Button btnUbah = findViewById(R.id.btnUbah);
        Button btnHapus = findViewById(R.id.btnHapus);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lvDoctors.setAdapter(adapter);

        // pilih dokter dari daftar
        lvDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dipilih = position;
                String[] bagian = data.get(position).split(" - ");
                etNamaDokter.setText(bagian[0]);
                etSpesialis.setText(bagian.length > 1 ? bagian[1] : "");
            }
        });

        // TAMBAH
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaDokter.getText().toString();
                String spesialis = etSpesialis.getText().toString();
                if (nama.equals("") || spesialis.equals("")) {
                    Toast.makeText(ManageDoctorsActivity.this, "Nama dan spesialis harus diisi", Toast.LENGTH_SHORT).show();
                } else {
                    data.add(nama + " - " + spesialis);
                    adapter.notifyDataSetChanged();
                    kosongkan();
                }
            }
        });

        // UBAH
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dipilih == -1) {
                    Toast.makeText(ManageDoctorsActivity.this, "Pilih dokter dulu", Toast.LENGTH_SHORT).show();
                } else {
                    String nama = etNamaDokter.getText().toString();
                    String spesialis = etSpesialis.getText().toString();
                    data.set(dipilih, nama + " - " + spesialis);
                    adapter.notifyDataSetChanged();
                    kosongkan();
                }
            }
        });

        // HAPUS
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dipilih == -1) {
                    Toast.makeText(ManageDoctorsActivity.this, "Pilih dokter dulu", Toast.LENGTH_SHORT).show();
                } else {
                    data.remove(dipilih);
                    adapter.notifyDataSetChanged();
                    kosongkan();
                }
            }
        });
    }

    private void kosongkan() {
        etNamaDokter.setText("");
        etSpesialis.setText("");
        dipilih = -1;
    }
}