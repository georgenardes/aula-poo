/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorprova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.dc.pr.PathStroker;

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
    public void recebeInformacoes(Objetiva[] o){
        this.setObjetivas(new Objetiva[this.getQtdQuestoesO()]);
        for (int i = 0; i < this.getQtdQuestoesO(); i++){
            this.getObjetivas()[i] = new Objetiva();
            getObjetivas()[i] = o[i];
        }
    }
    public void printProva(){
        String retorno = "";
        
        retorno += "************************ Prova de "
                +this.getDisciplina()+" ************************\n";
        retorno += "-|| Local: "+this.getLocal()+" |  | Data: "
                +this.getData()+" |  | Peso: "+this.getPeso()+" ||\n\n";
                
        retorno += "Estudante:______________________________________";
        retorno += "Instrucoes: "+this.intrucoes+"\n\n";
        
        int q= 1;
        for(int i = 0; i < this.getQtdQuestoesD(); i++, q++){
            retorno += this.discursivas[i].printer(q);      
        }
        for (int i = 0; i < this.getQtdQuestoesO(); i++, q++){
            retorno += this.objetivas[i].printer(q);
        }
        
        System.out.println(retorno);
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
