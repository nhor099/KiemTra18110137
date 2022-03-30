package com.example.baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText soTienEditText;
    EditText laiSuatEditText;
    EditText kyHanEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soTienEditText = findViewById(R.id.soTien);
        laiSuatEditText = findViewById(R.id.laiSuat);
        kyHanEditText = findViewById(R.id.kiHan);

    }

    public void xemKetQuaClick(View view) {
        String soTienStr = soTienEditText.getText().toString().trim();
        String laiSuatStr = laiSuatEditText.getText().toString().trim();
        String kyHanStr = kyHanEditText.getText().toString().trim();

        if (soTienStr.equals("") || laiSuatStr.equals("") || kyHanStr.equals(""))
             return;

        double soTien = Double.parseDouble(soTienStr);
        double laiSuat = Double.parseDouble(laiSuatStr);
        double kyHan = Double.parseDouble(kyHanStr);

        double tienLai = soTien*laiSuat*kyHan/12/100;



        Intent intent = new Intent(this, KetQua.class);
        intent.putExtra("tienLai", Integer.toString((int)tienLai));
        intent.putExtra("tongTien", Integer.toString((int) (soTien + tienLai)));
        startActivity(intent);
    }
}