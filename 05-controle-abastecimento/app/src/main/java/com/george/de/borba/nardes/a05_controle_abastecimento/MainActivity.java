package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AbastecerAdapter adaptador;
    private final int ADICIONAR_ABASTECIMENTO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvListasAbastecer = findViewById(R.id.rvListaAbastecimentos);

        this.adaptador = new AbastecerAdapter();

        this.adaptador.listaAbastecer = AbastecerDao.getLista(this.getApplicationContext());

        rvListasAbastecer.setAdapter(this.adaptador);

        rvListasAbastecer.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));

    }

    public void onClickAdd (View v) {
        Intent intencaoAbrirAbastecer = new Intent(this.getApplicationContext(), AbastecerActivity.class);
        startActivityForResult(intencaoAbrirAbastecer, ADICIONAR_ABASTECIMENTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADICIONAR_ABASTECIMENTO){
            //estou tratando o fechamento da activity AdicionarAvaliacaoActivity
            if(resultCode == 1){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 1!!!!!", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 2){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 2 -- -- - - - - - - ", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Retorno não tratado...", Toast.LENGTH_LONG).show();
            }
        }else{
            //veio de algum lugar obscuro...

        }

    }



}
