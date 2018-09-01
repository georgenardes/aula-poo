package geradorprova;
import java.util.Scanner;

/**
 *
 * @author George
 */

public class GeradorProva {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Prova p = new Prova();
        
        System.out.println("Qual o nome da disciplina?");
        p.setDisciplina(scan.nextLine()); 
        
        System.out.println("Qual o local?");
        p.setLocal(scan.nextLine());
        
        System.out.println("Qual a data da prova?");
        p.setData(scan.nextLine());
        
        System.out.println("Qual é o peso da prova?");
        p.setPeso(scan.nextInt());
        
        System.out.println("Quantas questoes discursivas?");
        p.setQtdQuestoesD(scan.nextInt());
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
            ds[i].setPeso(scan.nextFloat());
            System.out.println("\n----------------------------\n");
            scan.nextLine();
        }
        System.out.println("Quantas questoes objetivas?");
        p.setQtdQuestoesO(scan.nextInt());
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
            ob[i].setRespostaCorreta(scan.nextInt());
            scan.nextLine();
            System.out.println("\tDigite o peso da questao:");
            ob[i].setPeso(scan.nextFloat());
            System.out.println("\n----------------------------\n");
            scan.nextLine();
            
        }
//        System.out.println(p.getLocal());
//        System.out.println(ds[1].getPergunta());
//        System.out.println(ob[1].getPergunta());
        p.recebeInformacoes(ds);
        p.recebeInformacoes(ob);
        p.printProva();
    }
}
