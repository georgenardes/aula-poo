package com.george.de.borba.nardes.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_circulo);

        double raio = this.getIntent().getDoubleExtra("raio", -1);

        double area = 3.1416 * ( Math.pow(raio, 2) );

        TextView tvArea = findViewById(R.id.tvCirArea);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        tvArea.setText(nf.format(area));

    }
    public void onClickVoltar (View v) {
        Intent abrirTelaIni = new Intent (this.getApplicationContext(), MainActivity.class);
        abrirTelaIni.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(abrirTelaIni);
    }

}
