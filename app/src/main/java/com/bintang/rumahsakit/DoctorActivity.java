package com.bintang.rumahsakit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Button btnPatients = findViewById(R.id.btnPatients);
        Button btnMedicalRecord = findViewById(R.id.btnMedicalRecord);
        Button btnPrescription = findViewById(R.id.btnPrescription);
        Button btnSchedule = findViewById(R.id.btnSchedule);

        btnPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorActivity.this, "Daftar Pasien segera hadir", Toast.LENGTH_SHORT).show();
            }
        });

        btnMedicalRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorActivity.this, "Rekam Medis segera hadir", Toast.LENGTH_SHORT).show();
            }
        });

        btnPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorActivity.this, "Tulis Resep segera hadir", Toast.LENGTH_SHORT).show();
            }
        });

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DoctorActivity.this, "Jadwal Saya segera hadir", Toast.LENGTH_SHORT).show();
            }
        });
    }
}