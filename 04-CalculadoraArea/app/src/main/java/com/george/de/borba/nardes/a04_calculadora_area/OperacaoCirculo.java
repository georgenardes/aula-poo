package com.george.de.borba.nardes.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class OperacaoCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao_circulo);

        EditText rai = findViewById(R.id.etTriInfAlt);

        double raio = Double.parseDouble(rai.getText().toString());

        Intent intencaoAbrirResCir = new Intent(this.getApplicationContext(), ResultCirculo.class);

        intencaoAbrirResCir.putExtra("raio", raio);


        this.startActivity(intencaoAbrirResCir);

    }
}
