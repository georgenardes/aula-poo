package com.george.de.borba.nardes.a05_controle_abastecimento;

import java.util.Date;

public class Abastecer {
    private double km_atual;
    private double litros_abastecidos;
    private String data;
    private String posto;


    public double getKm_atual() {
        return km_atual;
    }

    public void setKm_atual(Double km_atual) {
        this.km_atual = km_atual;
    }

    public double getLitros_abastecidos() {
        return litros_abastecidos;
    }

    public void setLitros_abastecidos(double litros_abastecidos) {
        this.litros_abastecidos = litros_abastecidos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
