package com.george.de.borba.nardes.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OperacaoQuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao_quadrado);
    }


    protected void onClickAvancar (View v) {
        EditText alt = findViewById(R.id.etAltInf);
        EditText bas = findViewById(R.id.etBaseINf);

        double altura = Double.parseDouble(alt.getText().toString());
        double base = Double.parseDouble(bas.getText().toString());

        Intent intencaoAbrirResQua = new Intent(this.getApplicationContext(), ResultQuadrado.class);

        intencaoAbrirResQua.putExtra("altura", altura);
        intencaoAbrirResQua.putExtra("base", base);

        this.startActivity(intencaoAbrirResQua);


    }



}
