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
public class Prova {
    private String disciplina;
    private float peso;
    private String local;
    private String data;
    private String intrucoes;
    private int qtdQuestoesD;
    private int qtdQuestoesO;
    private Discursiva[] discursivas;
    private Objetiva[] objetivas;
    
    public Prova (){
        
    }
    public void recebeInformacoes(Discursiva[] d){
        this.setDiscursivas(new Discursiva[this.getQtdQuestoesD()]);
        for (int i = 0; i < this.getQtdQuestoesD(); i++){
            this.getDiscursivas()[i] = new Discursiva();
            getDiscursivas()[i] = d[i];
        }
    }
    public void recebeInformacoes(Objetiva o[]){
        this.setObjetivas(new Objetiva[this.getQtdQuestoesO()]);
        for (int i = 0; i < this.getQtdQuestoesO(); i++){
            this.getObjetivas()[i] = new Objetiva();
            getObjetivas()[i] = o[i];
        }
    }
    public void printProva(){
        System.out.println("************************ Prova de "
                +this.getDisciplina()+" ************************\n");
        
        System.out.println("-|| Local: "+this.getLocal()+" |  | Data: "
                +this.getData()+" |  | Peso: "+this.getPeso()+" ||\n\n");
        System.out.println("Estudante:______________________________________");
        
        System.out.println("Instrucoes: "+this.intrucoes+"\n\n");
        
        int q= 1;
        for(int i = 0; i < this.getQtdQuestoesD(); i++, q++){
            System.out.println(q+") Peso:"+getDiscursivas()[i].getPeso());
            System.out.println("- "+getDiscursivas()[i].getPergunta());
            System.out.println("\nCriterio de avaliacao: "+
                    getDiscursivas()[i].getCriteriosCorrecao());
            System.out.println("\tR:___________________________________________");
            System.out.println("\t_____________________________________________");
            System.out.println("\t_____________________________________________");
            System.out.println("\t____________________________________________.\n");
           
        }
        for (int i = 0; i < this.getQtdQuestoesO(); i++, q++){
            System.out.println(q+") Peso:"+getObjetivas()[i].getPeso());
            System.out.println("- "+getObjetivas()[i].getPergunta());
            for (int j = 0; j < 5; j++){
                System.out.println(j+1+") "+getObjetivas()[i].getOpcoes(j));
            }
            System.out.println("Alternativa correta "+
                    getObjetivas()[i].getRespostaCorreta()+"\n");

        }
        
    }
    

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return this.disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return this.peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the qtdQuestoesD
     */
    public int getQtdQuestoesD() {
        return qtdQuestoesD;
    }

    /**
     * @param qtdQuestoesD the qtdQuestoesD to set
     */
    public void setQtdQuestoesD(int qtdQuestoesD) {
        this.qtdQuestoesD = qtdQuestoesD;
    }

    /**
     * @return the qtdQuestoesO
     */
    public int getQtdQuestoesO() {
        return qtdQuestoesO;
    }

    /**
     * @param qtdQuestoesO the qtdQuestoesO to set
     */
    public void setQtdQuestoesO(int qtdQuestoesO) {
        this.qtdQuestoesO = qtdQuestoesO;
    }

    /**
     * @return the intrucoes
     */
    public String getIntrucoes() {
        return intrucoes;
    }

    /**
     * @param intrucoes the intrucoes to set
     */
    public void setIntrucoes(String intrucoes) {
        this.intrucoes = intrucoes;
    }

    /**
     * @return the discursivas
     */
    public Discursiva[] getDiscursivas() {
        return discursivas;
    }

    /**
     * @param discursivas the discursivas to set
     */
    public void setDiscursivas(Discursiva[] discursivas) {
        this.discursivas = discursivas;
    }

    /**
     * @return the objetivas
     */
    public Objetiva[] getObjetivas() {
        return objetivas;
    }

    /**
     * @param objetivas the objetivas to set
     */
    public void setObjetivas(Objetiva[] objetivas) {
        this.objetivas = objetivas;
    }
}
