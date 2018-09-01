
package pkg01.geradorprova;
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
        
        Discursiva[] d = new Discursiva[p.getQtdQuestoesD()];
        
        for (int i = 0; i < p.getQtdQuestoesD(); i++){
            String aux = "";
            System.out.println("Digite a "+(i+1)+"questao:");
            aux = scan.nextLine();
            //d[i].setPergunta(aux);
            System.out.println("Digite o criterio de avaliacao:");
            aux = scan.nextLine();
            d[i].setCriteriosCorrecao(aux);
            System.out.println("Digite o peso da questao:");
            d[i].setPeso(scan.nextFloat());
            System.out.println("\n----------------------------\n");

        }
        
        
        
        
        
       
    }

}
