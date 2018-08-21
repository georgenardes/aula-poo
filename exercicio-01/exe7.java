import java.util.Scanner;

public class exe7{
    public static void main(String args[]){
	Scanner s = new Scanner(System.in);
	double media = 0.0;
	float notas[] = new float[3];
	String nome;	
	System.out.println("Digite seu nome: ");
	nome = s.nextLine();
	for (int i = 0; i < 3; i++)
	{
		System.out.println("M"+(i+1)+" nota: ");
		notas[i] = s.nextFloat();
		media += notas[i];
	}
	media = media / 3;
	System.out.println("Nome do Aluno:"+nome);
	System.out.println("Media:"+media);	
	if (media >= 6.0)
		System.out.println("Situacao: Aprovado");
	else
		System.out.println("Situacao: Reprovado");		
	
    }
}