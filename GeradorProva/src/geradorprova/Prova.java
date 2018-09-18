/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorprova;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author nardes
 */
public class Prova {
    private String disciplina;
    private float peso;
    private String local;
    private String data;
    private String instrucoes;
    private final ArrayList<Questao> questoes;
    
    public Prova (){
        questoes = new ArrayList<>();
        this.instrucoes = "Respostas à caneta.\nAtribuirá nota 0 ao aluno que"
                + " for pego usando de meios fraudulentos\npara responder as questões.";
    }
    public void recebeInformacoes(Questao q) {
        this.questoes.add(q);
    }
    

    public void salvarProva() {
        String retorno = "";
        System.out.println("\t\tPré-visualização da prova\n\n");
        retorno += "************************ Prova de "
                +this.getDisciplina()+" ************************\n";
        retorno += "-|| Local: "+this.getLocal()+" |  | Data: "
                +this.getData()+" |  | Peso: "+this.getPeso()+" ||\n\n";
                
        retorno += "Estudante:______________________________________";
        retorno += "\nInstrucoes: "+this.getInstrucoes()+"\n\n";
        
        int q= 1;
        for (Questao x: questoes){
            retorno += x.printer(q);
            q++;
        }
        
        String nome = JOptionPane.showInputDialog("Digite o nome do arquivo ou o "
                + "diretório no qual deseja salvar a prova:");
        if (nome == null)
            System.exit(0);

        try {
            try (PrintWriter file = new PrintWriter(new FileWriter(nome))) {
                file.print(retorno);
            }
        }
        catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Erro ocorrido ao gravar arquivo"
                    + "!", "Erro", 0);
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
     * @return the instrucoes
     */
    public String getInstrucoes() {
        return instrucoes;
    }

    /**
     * @param instrucoes the instrucoes to set
     */
    public void setInstrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
    }


}
