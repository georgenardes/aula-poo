package com.george.de.borba.nardes.a04_calculadora_area;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_triangulo);

        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double base = this.getIntent().getDoubleExtra("base", -1);

        double area = ( base * altura ) / 2;

        TextView tvArea = findViewById(R.id.tvTriArea);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        tvArea.setText(nf.format(area));

    }
}
