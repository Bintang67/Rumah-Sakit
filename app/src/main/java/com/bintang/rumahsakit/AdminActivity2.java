package com.bintang.rumahsakit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2); // sesuaikan dengan nama file layout admin Anda

        Button btnMonitorMembers = findViewById(R.id.btnMonitorMembers);
        Button btnManageDoctors = findViewById(R.id.btnManageDoctors);
        Button btnReport = findViewById(R.id.btnReport);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnMonitorMembers.setOnClickListener(v ->
                startActivity(new Intent(this, MonitorMembersActivity2.class)));

        btnManageDoctors.setOnClickListener(v ->
                startActivity(new Intent(this, ManageDoctorsActivity.class)));

        btnReport.setOnClickListener(v ->
                startActivity(new Intent(this, ReportActivity.class)));

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}