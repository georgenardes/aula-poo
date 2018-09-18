package geradorprova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 * @author George
 */

public class GeradorProva {
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Novo gerador de prova versão 1.0", "George Software!", 1);
        do {
            int ci = -1; // Variavel para consistencias
            float cf = -1; // Variavel para consistencias
            String auxi;
            Prova p = new Prova();
            try{
                
                auxi = JOptionPane.showInputDialog("Qual o nome da disciplina?");
                p.setDisciplina(auxi); 

                auxi = JOptionPane.showInputDialog("Em que local será realizada"
                        + " a prova?");
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
                        JOptionPane.showMessageDialog(null,
                                        "Digite uma data válida","Error Message!", 0);
                    }
                }    
                p.setData(auxi);

                while ( cf <= 0 ){
                    try{
                        auxi = JOptionPane.showInputDialog("Qual o peso da prova?");
                        cf = Float.parseFloat(auxi);
                        if (cf <= 0){
                            JOptionPane.showMessageDialog(null,"Digite um numero positivo");
                        }
                    }
                    catch(NumberFormatException ime) {
                        JOptionPane.showMessageDialog(null,
                                        "Digite um numero valido","Error Message!", 0);
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
                            "Escolha o tipo da questão.",
                            "Tipo da questão",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, option, option[0]);
                    if (op == 0){
                        Discursiva ds = new Discursiva();
                        auxi = JOptionPane.showInputDialog("Digite a "+cont+" questão:");
                        ds.setPergunta(auxi);
                        auxi = JOptionPane.showInputDialog("Digite o criterio de avaliação:");
                        ds.setCriteriosCorrecao(auxi);

                        while ( cf <= 0 ) {
                            try{
                                auxi = JOptionPane.showInputDialog("Digite o peso da questão:");
                                cf = Float.parseFloat(auxi);
                                if (cf <= 0){
                                    JOptionPane.showMessageDialog(null,
                                            "Digite um numero positivo");
                                }
                            }catch(NumberFormatException nfe){
                                JOptionPane.showMessageDialog(null,
                                        "Digite um numero valido","Error Message!", 0);
                            }
                        }
                        ds.setPeso(cf);
                        p.recebeInformacoes(ds);
                        cf = -1;
                        cont++;
                    } 
                    else if (op == 1) {
                        Objetiva ob = new Objetiva();
                        auxi = JOptionPane.showInputDialog("Digite a "+cont+" questão:");
                        ob.setPergunta(auxi);
                        String[] tmp = new String[5];
                        for (int j = 0; j < 5; j++){
                            tmp[j] = JOptionPane.showInputDialog("Digite a "+(j+1)+" opção:");
                        }
                        ob.setOpcoes(tmp);

                        while ( ci < 0 || ci > 4) {
                            try{
                                auxi = JOptionPane.showInputDialog("Digite a opção correta"
                                        + "(0 a 4):");
                                ci = Integer.parseInt(auxi);    
                                if (ci < 0 || ci > 4){
                                    JOptionPane.showMessageDialog(null,
                                            "Digite um numero entre 0 e 4");
                                }
                            }
                            catch(NumberFormatException nfe){
                                JOptionPane.showMessageDialog(null,
                                        "Digite um numero valido","Error Message!", 0);
                            }
                        }
                        ob.setRespostaCorreta(ci);

                        while ( cf <= 0 ){
                            try{
                                auxi = JOptionPane.showInputDialog("Digite o peso da questão:");
                                cf = Float.parseFloat(auxi);
                                if (cf <= 0){
                                    JOptionPane.showMessageDialog(null,
                                            "Digite um numero positivo");
                                }
                            }catch(NumberFormatException nfe){
                                JOptionPane.showMessageDialog(null,
                                        "Digite um numero valido","Error Message!", 0);
                            }
                        }
                        ob.setPeso(cf);
                        p.recebeInformacoes(ob);
                        cf = -1;
                        cont++;
                    }
                    if (cont == 1){
                        JOptionPane.showMessageDialog(null, "Voce nao pode criar uma prova sem questões!");
                    }
                    else{
                        int choice;
                        choice = JOptionPane.showConfirmDialog(null,
                                "Deseja inserir outra questão?", "Sim ou não", JOptionPane.YES_NO_OPTION);
                        if (choice != 0) {
                            cond = true;
                        }
                    }
                } while (cond == false);

                p.salvarProva();
                JOptionPane.showMessageDialog(null,"Prova Gerada com sucesso!", "George Software!", 1);
            }
            catch (NullPointerException npe){
                JOptionPane.showMessageDialog(null,"Ocorreu um erro desconhecido "
                        + "ao gerar a prova! :( ","Error Message", 0);
            }
            
            int choice;
            choice = JOptionPane.showConfirmDialog(null,
                    "\nDeseja criar outra prova?", "George Software!", JOptionPane.YES_NO_OPTION);
            if (choice != 0)
                break;
            
            
        } while (true);
        JOptionPane.showMessageDialog(null,"Este programa foi desenvolvido por:\n "
                + "George de Borba Nardes\nEmail: nardes@edu.univali.br", "Créditos", 1);
    }
}
