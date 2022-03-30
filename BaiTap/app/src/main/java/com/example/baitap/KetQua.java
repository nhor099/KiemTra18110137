package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class KetQua extends AppCompatActivity {
    TextView tienLaiText;
    TextView tongTienText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        Intent intent = getIntent();
        String tienLai = intent.getStringExtra("tienLai");
        String tongTien = intent.getStringExtra("tongTien");

        tienLaiText = findViewById(R.id.tienLaiText);
        tongTienText = findViewById(R.id.tongTienText);

        if (savedInstanceState != null) {
            tienLaiText.setText(savedInstanceState.getString("tienLaiText"));
            tongTienText.setText(savedInstanceState.getString("tongTienText"));
        } else {
            tienLaiText.setText(tienLai + "đ");
            tongTienText.setText(tongTien + "đ");
        }

    }

    public void cameraClick(View view) {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tienLaiText", tienLaiText.getText().toString());
        outState.putString("tongTienText", tongTienText.getText().toString());
    }

    public void backClick(View view) {
        finish();
    }
}