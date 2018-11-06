package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AbastecerDao {

    private static ArrayList<Abastecer> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "avaliacoes.txt";

    public static boolean salvar(Context c, Abastecer aSerSalvo){
        AL_CACHE.add(aSerSalvo);

        String avEmString = "";
        avEmString += aSerSalvo.getKm_atual() + ";";
        avEmString += aSerSalvo.getLitros_abastecidos() + ";";
        avEmString += aSerSalvo.getData() + ";";
        avEmString += aSerSalvo.getPosto() + "\n";

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write( avEmString );
            escritor.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Abastecer> getLista(Context c){
        AL_CACHE = new ArrayList<Abastecer>();

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO);

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAvaliacao = null;

            while((linhaAvaliacao = leitorDeLinha.readLine()) != null){

                String[] partesDaLinha = linhaAvaliacao.split(";");
                Abastecer daVez = new Abastecer();
                daVez.setKm_atual( Double.parseDouble( partesDaLinha[0] ) );
                daVez.setLitros_abastecidos( Double.parseDouble( partesDaLinha[1] ));
                daVez.setData( partesDaLinha[2] );
                daVez.setPosto( partesDaLinha[3] );
                AL_CACHE.add(daVez);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }


        return AL_CACHE;
    }
}
