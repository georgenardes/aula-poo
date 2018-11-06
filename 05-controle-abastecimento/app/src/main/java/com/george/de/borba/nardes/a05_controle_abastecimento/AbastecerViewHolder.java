package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AbastecerViewHolder extends RecyclerView.ViewHolder {
    private TextView tvData_de_abastecimento;
    private TextView tvKm_de_abastecimento;
    private TextView tvLitros_abastecidos;
    private ImageView ivposto;

    public AbastecerViewHolder (View itemView) {
        super(itemView);
        this.tvData_de_abastecimento = itemView.findViewById(R.id.tv_Data_de_abastecimento);
        this.tvKm_de_abastecimento = itemView.findViewById(R.id.tv_km_de_abastecimento);
        this.tvLitros_abastecidos = itemView.findViewById(R.id.tv_litros_abastecidos);
        ivposto = itemView.findViewById(R.id.ivFoto_do_posto);

    }

    public void atualizaGaveta(Abastecer objetoAbastecer){
        this.tvData_de_abastecimento.setText( objetoAbastecer.getData() );
        this.tvKm_de_abastecimento.setText( ""+objetoAbastecer.getKm_atual() );
        this.tvLitros_abastecidos.setText( ""+objetoAbastecer.getLitros_abastecidos() + " litros");
        String posto = objetoAbastecer.getPosto();

        if (posto.equals("Texaco"))
            ivposto.setImageResource(R.drawable.texaco);
        if (posto.equals("Ipiranga"))
            ivposto.setImageResource(R.drawable.ipiranga);
        if (posto.equals("Petrobras"))
            ivposto.setImageResource(R.drawable.petrobras);
        if (posto.equals("Shell"))
            ivposto.setImageResource(R.drawable.shell);



//        if(objetoAvaliacao.getMedia().equals("M1")){
//            this.tvMedia.setTextColor(Color.BLUE);
//        }else{
//            this.tvMedia.setTextColor(Color.GRAY);
//        }
    }



}
