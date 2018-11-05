package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AbastecerViewHolder extends RecyclerView.ViewHolder {
    private TextView tvData_de_abastecimento;
    private TextView tvKm_de_abastecimento;
    private TextView tvLitros_abastecidos;

    public AbastecerViewHolder (View itemView) {
        super(itemView);
        this.tvData_de_abastecimento = itemView.findViewById(R.id.tv_Data_de_abastecimento);
        this.tvKm_de_abastecimento = itemView.findViewById(R.id.tv_km_de_abastecimento);
        this.tvLitros_abastecidos = itemView.findViewById(R.id.tv_litros_abastecidos);

    }

    public void atualizaGaveta(Abastecer objetoAbastecer){
        this.tvData_de_abastecimento.setText( objetoAbastecer.getData() );
        this.tvKm_de_abastecimento.setText( ""+objetoAbastecer.getKm_atual() );
        this.tvLitros_abastecidos.setText( ""+objetoAbastecer.getLitros_abastecidos() );

//        if(objetoAvaliacao.getMedia().equals("M1")){
//            this.tvMedia.setTextColor(Color.BLUE);
//        }else{
//            this.tvMedia.setTextColor(Color.GRAY);
//        }
    }



}
