package geradorprova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *  Gravar em arquivo 
 *  Usar array list para questões
 *  Possibilidade de adicionar infinitas questões
 * @author George
 */

public class GeradorProva {
    public static void main(String[] args){
        int ci = 0; // Variavel para consistencias
        float cf = -1; // Variavel para consistencias
        String auxi;
        Scanner scan = new Scanner(System.in);
        Prova p = new Prova();
        
        auxi = JOptionPane.showInputDialog("Qual o nome da disciplina?");
        p.setDisciplina(auxi); 

        auxi = JOptionPane.showInputDialog("Qual o local?");
        p.setLocal(auxi);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try{
                auxi = JOptionPane.showInputDialog("Digite a data (dd/MM/yyyy):");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(auxi, formatter);    
                sdf.parse(auxi);
                break;
            }
            catch(DateTimeParseException | ParseException ex) {
                JOptionPane.showMessageDialog(null,"Digite uma data valida!");
            }
        }    
        p.setData(auxi);
        
        while ( cf <= 0 ){
            try{
                auxi = JOptionPane.showInputDialog("Qual o peso da prova?");
                cf = Float.parseFloat(auxi);
                if (cf <= 0){
                    throw new InputMismatchException("Digite um numero positivo");
                }
            }
            catch(InputMismatchException | NumberFormatException ime){
                JOptionPane.showMessageDialog(null,"Digite um numero valido");
            }
        }
        p.setPeso(cf);
        cf = -1;
        boolean cond = false;
        int cont = 1;
        /*
        Inicio entrada de questoes
        */
        do {
            Object[] option = {"Discursiva", "Objetiva"};
            int op =  JOptionPane.showOptionDialog(null,
                    "Voce deseja inserir que tipo de questao?",
                    "Questao",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, option, option[0]);
            if (op == 0){
                Discursiva ds = new Discursiva();
                auxi = JOptionPane.showInputDialog("Digite a "+cont+" questao:");
                ds.setPergunta(auxi);
                auxi = JOptionPane.showInputDialog("Digite o criterio de avaliacao:");
                ds.setCriteriosCorrecao(auxi);
                
                while ( cf <= 0 ){
                    try{
                        auxi = JOptionPane.showInputDialog("Digite o peso da questao:");
                        cf = Float.parseFloat(auxi);
                        if (cf <= 0){
                            throw new InputMismatchException("Digite um numero"
                                    + "maior que 0");
                        }
                    }catch(InputMismatchException ime){
                        JOptionPane.showMessageDialog(null,"Digite um numero valido");
                    }
                }
                ds.setPeso(cf);
                p.recebeInformacoes(ds);
                cf = -1;
                System.out.println("\n----------------------------\n");
                cont++;
            } 
            else if (op == 1) {
                Objetiva ob = new Objetiva();
                auxi = JOptionPane.showInputDialog("Digite a "+cont+" questao:");
                ob.setPergunta(auxi);
                String[] tmp = new String[5];
                for (int j = 0; j < 5; j++){
                    tmp[j] = JOptionPane.showInputDialog("Digite a "+(j+1)+" opcao:");
                }
                ob.setOpcoes(tmp);
                
                while ( ci < 1 || ci > 5) {
                    try{
                        auxi = JOptionPane.showInputDialog("Opcao correta:");
                        ci = Integer.parseInt(auxi);    
                        if (ci < 1 || ci > 5){
                            throw new InputMismatchException("Digite um numero entre 1 e 5");
                        }
                    }
                    catch(InputMismatchException ime){
                        JOptionPane.showMessageDialog(null,"Digite um numero valido");
                    }
                }
                ob.setRespostaCorreta(ci);
                
                while ( cf <= 0 ){
                    try{
                        auxi = JOptionPane.showInputDialog("Digite o peso da questao:");
                        cf = Float.parseFloat(auxi);
                        if (cf <= 0){
                            throw new InputMismatchException("Digite um numero maior que 0");
                        }
                    }catch(InputMismatchException ime){
                        JOptionPane.showMessageDialog(null,"Digite um numero valido");
                    }
                }
                ob.setPeso(cf);
                p.recebeInformacoes(ob);
                System.out.println("\n----------------------------\n");
                cont++;
            }
            if (cont == 1){
                JOptionPane.showMessageDialog(null, "Voce nao pode criar uma prova sem questoes!");
            }
            else{
                int choice;
                choice = JOptionPane.showConfirmDialog(null,
                        "Deseja inserir outra questao?", "Sim ou nao", JOptionPane.YES_NO_OPTION);
                if (choice != 0) {
                    cond = true;
                }
            }
        } while (cond == false);
        
        p.printProva();
    }
}
