/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorprova;

import java.io.File;
import java.util.ArrayList;



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
    private ArrayList<Questao> questoes;
    
    public Prova (){
        questoes = new ArrayList<>();
    }
    public void recebeInformacoes(Questao q){
        this.questoes.add(q);
    }
    

    public void salvarProva(){
        String retorno = "";
        File fl = new File("\\home\\nardes");
        
        retorno += "************************ Prova de "
                +this.getDisciplina()+" ************************\n";
        retorno += "-|| Local: "+this.getLocal()+" |  | Data: "
                +this.getData()+" |  | Peso: "+this.getPeso()+" ||\n\n";
                
        retorno += "Estudante:______________________________________";
        retorno += "Instrucoes: "+this.getIntrucoes()+"\n\n";
        
        int q= 1;
        for (Questao x: questoes){
            retorno += x.printer(q);
            q++;
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


}
