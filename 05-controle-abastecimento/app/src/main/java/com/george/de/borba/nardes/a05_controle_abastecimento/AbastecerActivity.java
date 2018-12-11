package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AbastecerActivity extends AppCompatActivity {

    private Spinner s_posto;
    private EditText et_km;
    private EditText et_litros;
    private EditText et_data;
    private double last_km;
    private boolean permissao;
    private LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecer);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else{
            permissao = true;
        }



        last_km = getIntent().getDoubleExtra("last_km", 0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.arrayPosto,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s_posto = (Spinner) findViewById(R.id.spinnerPostos);
        s_posto.setAdapter(adapter);

        et_km = findViewById(R.id.etKm_atual);
        et_litros = findViewById(R.id.etLitros_abastecidos);
        et_data = findViewById(R.id.etData_de_abastecimento);
    }

    public void onClickSalvar (View v) {
        et_km = findViewById(R.id.etKm_atual);
        et_litros = findViewById(R.id.etLitros_abastecidos);
        et_data = findViewById(R.id.etData_de_abastecimento);
        s_posto = findViewById(R.id.spinnerPostos);

        double km_atual = Double.parseDouble( et_km.getText().toString() );
        double litros_ab = Double.parseDouble( et_litros.getText().toString() );
        String data = et_data.getText().toString();
        String posto =  s_posto.getSelectedItem().toString();


        Abastecer ab = new Abastecer();
        ab.setKm_atual(km_atual);
        ab.setLitros_abastecidos(litros_ab);
        ab.setData(data);
        ab.setPosto(posto);

        if (km_atual < last_km ) {
            et_km.setError("Km atual menor que o anterior");
        } else {
            if (permissao) {
                LocationGPS g = new LocationGPS(this.getApplicationContext());
                Location l = g.getLocation();
                if (l != null){
                    ab.setLat(l.getLatitude());
                    ab.setLog(l.getLongitude());
                } else {
                    ab.setLat(90);
                    ab.setLog(190);
                }
                boolean sucesso_salvar = AbastecerDao.salvar(this, ab);

                if (sucesso_salvar) {
                    setResult(1);
                    finish();

                }
                else
                {
                    Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this.getApplicationContext(), "Sem permissão", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
            {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    permissao = true;
                }
                else
                {
                    //Permissao nao garantida
                }
                return;
            }
        }
    }

}
