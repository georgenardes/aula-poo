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
public final class Discursiva extends Questao {
    private String criteriosCorrecao;
    
    
    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }

    @Override
    String printer(int q) {
        String retorno = "";
        retorno += q+") Peso:"+this.getPeso()+"\n";
        retorno += "- "+this.getPergunta() +"\n";
        retorno += "\nCriterio de avaliacao: "+
                this.getCriteriosCorrecao() +"\n";
        retorno += "\tR:___________________________________________\n";
        retorno += "\t_____________________________________________\n";
        retorno += "\t_____________________________________________\n";
        retorno += "\t_____________________________________________.\n\n";
        return retorno;
        
    }
    
}
