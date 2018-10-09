package com.nardes.calc_financeira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular_juros(View calcular){
        EditText capital = findViewById(R.id.valor_capital);
        EditText taxa = findViewById(R.id.valor_taxa);
        EditText periodo = findViewById(R.id.qtd_tempo);
        TextView resultado = findViewById(R.id.resultado);

        RadioButton ano = findViewById(R.id.periodo_ano);
        RadioButton mes = findViewById(R.id.periodo_mes);
        RadioButton dia = findViewById(R.id.periodo_dia);
        RadioButton j_s = findViewById(R.id.juros_simp);
        RadioButton j_c = findViewById(R.id.juros_comp);


        String cap = capital.getText().toString();
        String tax = taxa.getText().toString();
        String per = periodo.getText().toString();

        if (cap.equals("")){
            capital.setError("Informe o capital");
            return;
        }
        else if (tax.equals("")) {
            taxa.setError("Informe a taxa");
            return;
        }
        else if (per.equals("")){
            periodo.setError("Informe o período");
            return;
        }
        try {

            double d_cap = Double.parseDouble(cap);
            double d_tax = Double.parseDouble(tax);
            double d_per = Double.parseDouble(per);
            double d_mont = 0.0;

            if (j_s.isChecked()) {
                d_mont = d_cap + (d_cap * d_tax * d_per);
            }
            else if (j_c.isChecked()) {
                d_tax += 1.0;
                double d_fin_tax = ((float)d_tax);
                for (int i = 1; i < d_per; i++)
                    d_fin_tax = d_tax * d_fin_tax;
                d_mont = d_cap * d_fin_tax;
            }

            if (ano.isChecked()) {
                resultado.setText("R$"+((float) d_mont)+" em "+((float)d_per)+" ano(s).\n");
            }
            else if (mes.isChecked()) {
                resultado.setText("R$"+((float) d_mont)+" em "+(float)d_per+" mês(es).\n");
            }
            else if (dia.isChecked()) {
                resultado.setText("R$"+((float) d_mont)+" em "+((float)d_per)+" dia(s).\n");
            }


        }
        catch (NumberFormatException nfe) {
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }

    }

}
