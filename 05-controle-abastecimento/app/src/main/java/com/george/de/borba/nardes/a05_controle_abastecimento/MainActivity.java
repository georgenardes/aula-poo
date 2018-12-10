package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private double last_km;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        setContentView(R.layout.activity_main);
        ArrayList<Abastecer> abastecerList = new ArrayList<Abastecer>();
        abastecerList = AbastecerDao.getLista(this);

        NumberFormat nF = DecimalFormat.getInstance();
        nF.setMaximumFractionDigits(2);

        if (abastecerList.size() > 1) {
            double km;
            this.last_km = abastecerList.get(abastecerList.size()-1).getKm_atual();
            km = abastecerList.get(abastecerList.size()-1).getKm_atual() - abastecerList.get(0).getKm_atual();
            double litros = 0;

            for (int i = 0; i < abastecerList.size()-1; i++){
                litros += abastecerList.get(i).getLitros_abastecidos();
            }

            double autonomia = km/litros;

            TextView tvResult =findViewById(R.id.tvResult);
            tvResult.setText(String.valueOf(nF.format(autonomia)));
            tvResult.setVisibility(View.VISIBLE);

            TextView tvKilometerPerLiter = findViewById(R.id.tvKilometersPerLiter);
            tvKilometerPerLiter.setVisibility(View.VISIBLE);
        }
        else
        {
            TextView tvResult =findViewById(R.id.tvResult);
            tvResult.setText("Abasteça mais");
            tvResult.setVisibility(View.VISIBLE);
        }
    }
    public void onClickVerHistoria(View v)
    {
        Intent intent = new Intent(this.getApplicationContext(), ListaActivity.class);
        intent.putExtra("last_km", last_km);
        startActivity(intent);
    }

    public double getLast_km() {
        return last_km;
    }

    public void setLast_km(double last_km) {
        this.last_km = last_km;
    }
}
