package com.george.de.borba.nardes.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void onClickAvancar (View v) {
        RadioButton rbQuad = findViewById(R.id.rbQuadrado);
        RadioButton rbTria = findViewById(R.id.rbTriangulo);
        RadioButton rbCirc = findViewById(R.id.rbCirculo);


        if ( rbQuad.isChecked() ) {
            Intent abrirTelaDetalhes = new Intent(this.getApplicationContext(), OperacaoQuadrado.class);
            this.startActivity( abrirTelaDetalhes );
        }
        else if ( rbTria.isChecked() ) {
            Intent abrirTelaDetalhes = new Intent(this.getApplicationContext(), OperacaoTriangulo.class);
            this.startActivity( abrirTelaDetalhes );
        }
        else if ( rbCirc.isChecked() ){
            Intent abrirTelaDetalhes = new Intent(this.getApplicationContext(), OperacaoCirculo.class);
            this.startActivity( abrirTelaDetalhes );
        }



    }



}
