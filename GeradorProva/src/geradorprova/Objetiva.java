/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorprova;

/**
 *
 * @author nardes
 */
public final class Objetiva extends Questao {
    private String[] opcoes;
    private int respostaCorreta;
    
    
    public Objetiva (){
        this.opcoes = new String[5];
    }

    /**
     * @param o
     * @return the opcoes
     */
    public String getOpcoes(int o) {
        return opcoes[o];
    }

    /**
     * @param opcoes the opcoes to set
     */
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * @return the respostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param respostaCorreta the respostaCorreta to set
     */
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    String printer(int q) {
        String retorno = "";
        
        retorno += q+") Peso:"+this.getPeso()+"\n";
        retorno += "- "+this.getPergunta()+"\n";
 
        for (int j = 0; j < 5; j++){
            retorno += j+1+") "+this.getOpcoes(j)+"\n";
        }
        retorno += "Alternativa correta "+
                this.getRespostaCorreta()+"\n";

        return retorno;
    }
    
    
}
