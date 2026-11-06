package com.bintang.rumahsakit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("123456")) {
                    startActivity(new Intent(MainActivity2.this, AdminActivity2.class));
                } else if (username.equals("dokter") && password.equals("6767")) {
                    startActivity(new Intent(MainActivity2.this, DoctorActivity.class));
                } else {
                    Toast.makeText(MainActivity2.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}