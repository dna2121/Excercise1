package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        switch (nama) {
            case "Jimin":
                tvnama.setText("Park Jimin");
                tvnomor.setText("0812345678");
                break;
            case "Yasmin":
                tvnama.setText("Yasmina Azza");
                tvnomor.setText("0812345679");
                break;
            case "Sekara":
                tvnama.setText("Sekara Pure");
                tvnomor.setText("0812345670");
                break;
            case "Karin":
                tvnama.setText("Karina Nur");
                tvnomor.setText("0812345677");
                break;
            case "Jungkook":
                tvnama.setText("Jeon Jungkook");
                tvnomor.setText("0812345676");
                break;
            case "Taehyung":
                tvnama.setText("Kim Taehyung");
                tvnomor.setText("0812345675");
                break;
            case "Suga":
                tvnama.setText("Min Suga");
                tvnomor.setText("0812345674");
                break;
            case "Seokjin":
                tvnama.setText("Kim Seokjin");
                tvnomor.setText("0812345673");
                break;
            case "Namjoon":
                tvnama.setText("Kim Namjoon");
                tvnomor.setText("0812345672");
                break;
            case "Hoba":
                tvnama.setText("Jung Hoba");
                tvnomor.setText("0812345671");
                break;
        }
    }
}