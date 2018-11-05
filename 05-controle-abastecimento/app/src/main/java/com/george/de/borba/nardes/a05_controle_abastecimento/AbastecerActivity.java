package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AbastecerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecer);
    }

    public void onClickSalvar (View v) {
        EditText et_km = findViewById(R.id.etKm_atual);
        EditText et_litros = findViewById(R.id.etLitros_abastecidos);
        EditText et_data = findViewById(R.id.etData_de_abastecimento);
        Spinner et_posto = findViewById(R.id.spinnerPostos);

        double km_atual = Double.parseDouble( et_km.getText().toString() );
        double litros_ab = Double.parseDouble( et_litros.getText().toString() );
        String data = et_data.getText().toString();
        String posto = et_posto.getContentDescription().toString();

        Abastecer ab = new Abastecer();

        ab.setKm_atual(km_atual);
        ab.setLitros_abastecidos(litros_ab);
        ab.setData(data);
        ab.setPosto(posto);

        boolean sucesso_salvar = AbastecerDao.salvar(this.getApplicationContext(),ab);

        if (sucesso_salvar) {
            setResult(1);
            finish();

        }
        else
        {
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }

}
