package pkg01.geradorprova;

/**
 *
 * @author George
 */
final class Objetiva extends Questao {
    private String[] opcoes;
    private int respostaCorreta;
    
    
    public Objetiva (){
        this.opcoes = new String[5];
    }

    /**
     * @return the opcoes
     */
    public String[] getOpcoes() {
        return opcoes;
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
    
    
}
