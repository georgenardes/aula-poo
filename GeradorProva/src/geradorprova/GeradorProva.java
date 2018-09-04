package geradorprova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author George
 */

public class GeradorProva {
    public static void main(String[] args){
        int ci = 0; // Variavel para consistencias
        float cf = 0; // Variavel para consistencias
        
        Scanner scan = new Scanner(System.in);
        Prova p = new Prova();
        
        System.out.println("Qual o nome da disciplina?");
        p.setDisciplina(scan.nextLine()); 
        
        System.out.println("Qual o local?");
        p.setLocal(scan.nextLine());
        
        System.out.println("Qual a data da prova? (dd/MM/yyyy)");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String dt = null;
        int cond = -1;
        while (cond < 0) {
            try{
                dt = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate d = LocalDate.parse(dt, formatter);    
                Date dataProva = sdf.parse(dt);
                cond = 1;
            }
            catch(DateTimeParseException | ParseException ex) {
                System.out.println("Data invalida! Digite novamente");
            }
        }    
        p.setData(dt);
        
        System.out.println ("Qual é o peso da prova?");
        
        while ( cf < 1 ){
            try{
                cf = scan.nextFloat();
                if (cf < 1){
                    throw new InputMismatchException("Digite um numero valido");
                }
            }
            catch(InputMismatchException ime){
                System.out.println("Digite um numero valido!");
                scan.nextLine();
            }
        }
        p.setPeso(cf);
        cf = -1;
        
        System.out.println("Quantas questoes discursivas?");
        
        while ( ci < 1 ){
            try{
                ci = scan.nextInt();    
                if (ci < 1){
                    throw new InputMismatchException("Digite um numero valido");
                }
            }
            catch(InputMismatchException ime){
                System.out.println("Digite um numero valido!");
                scan.nextLine();
            }
        }
        
        p.setQtdQuestoesD(ci);
        ci = -1;
        scan.nextLine();
       
        Discursiva[] ds = new Discursiva[p.getQtdQuestoesD()];
        for (int i = 0; i < p.getQtdQuestoesD(); i++){
            ds[i] = new Discursiva();
            String aux;
            System.out.println("Digite a "+(i+1)+" questao:");
            aux = scan.nextLine();
            ds[i].setPergunta(aux);
            System.out.println("\tDigite o criterio de avaliacao:");
            aux = scan.nextLine();
            ds[i].setCriteriosCorrecao(aux);
            System.out.println("\tDigite o peso da questao:");
            
            while ( cf < 0 ){
                try{
                    cf = scan.nextFloat();
                    if (cf < 0){
                        throw new InputMismatchException("Digite um numero valido");
                    }
                }catch(InputMismatchException ime){
                    System.out.println("Digite um numero valido!");
                    scan.nextLine();
                }
            }
            
            ds[i].setPeso(cf);
            cf = -1;
            
            System.out.println("\n----------------------------\n");
            scan.nextLine();
        }
        System.out.println("Quantas questoes objetivas?");
        while ( ci < 1 ){
            try{
                ci = scan.nextInt();    
                if (ci < 1){
                    throw new InputMismatchException("Digite um numero valido");
                }
            }
            catch(InputMismatchException ime){
                System.out.println("Digite um numero valido!");
                scan.nextLine();
            }
        }
        
        p.setQtdQuestoesO(ci);
        ci = -1;
        scan.nextLine();
        
        Objetiva[] ob = new Objetiva[p.getQtdQuestoesO()];
        for (int i = 0 ; i < p.getQtdQuestoesO(); i++){
            ob[i] = new Objetiva();
            String aux;
            System.out.println("Digite a "+(i+1)+" questao:");
            aux = scan.nextLine();
            ob[i].setPergunta(aux);
            String[] tmp = new String[5];
            for (int j = 0; j < 5; j++){
                System.out.println("\tDigite a "+(j+1)+" opcao:");
                tmp[j] = scan.nextLine();
            }
            ob[i].setOpcoes(tmp);
            System.out.println("\tOpcao correta:");
            while ( ci < 1 ){
                try{
                    ci = scan.nextInt();    
                    if (ci < 1){
                        throw new InputMismatchException("Digite um numero valido");
                    }
                }
                catch(InputMismatchException ime){
                    System.out.println("Digite um numero valido!");
                    scan.nextLine();
                }
            }
            ob[i].setRespostaCorreta(ci);
            scan.nextLine();
            System.out.println("\tDigite o peso da questao:");
            while ( cf < 0 ){
                try{
                    cf = scan.nextFloat();
                    if (cf < 0){
                        throw new InputMismatchException("Digite um numero valido");
                    }
                }catch(InputMismatchException ime){
                    System.out.println("Digite um numero valido!");
                    scan.nextLine();
                }
            }
            
            ob[i].setPeso(cf);
            System.out.println("\n----------------------------\n");
            scan.nextLine();
            
        }
        p.recebeInformacoes(ds);
        p.recebeInformacoes(ob);
        p.printProva();
    }
}
