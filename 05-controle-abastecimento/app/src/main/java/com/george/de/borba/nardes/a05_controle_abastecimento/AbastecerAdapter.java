package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AbastecerAdapter extends RecyclerView.Adapter {

    public ArrayList<Abastecer>  listaAbastecer;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflando o XML
        View elementoPaiDoXML =
                LayoutInflater.from(
                        viewGroup.getContext()
                ).inflate(
                        R.layout.item_da_lista_abastecidos,
                        viewGroup,
                        false
                );

        AbastecerViewHolder gaveta = new AbastecerViewHolder(elementoPaiDoXML);
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        AbastecerViewHolder gaveta = (AbastecerViewHolder) viewHolder;
        Abastecer daVez = listaAbastecer.get(position);
        gaveta.atualizaGaveta( daVez );

    }

    @Override
    public int getItemCount() {
        return listaAbastecer.size();
    }
}
