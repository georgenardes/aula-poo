package com.george.de.borba.nardes.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OperacaoTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacao_triangulo);
    }

    public void onClickAvancar (View v) {
        EditText alt = findViewById(R.id.etTriInfAlt);
        EditText bas = findViewById(R.id.etTriInfBase);

        double altura = Double.parseDouble(alt.getText().toString());
        double base = Double.parseDouble(bas.getText().toString());

        Intent intencaoAbrirResTri = new Intent(this.getApplicationContext(), ResultTriangulo.class);

        intencaoAbrirResTri.putExtra("altura", altura);
        intencaoAbrirResTri.putExtra("base", base);

        this.startActivity(intencaoAbrirResTri);


    }
}
