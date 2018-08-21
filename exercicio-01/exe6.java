import java.util.Scanner;
public class exe6{
    public static void operar (int vet[]){
	int soma = 0;
	double media = 0.0;
	int maior = vet[0];
	int menor = vet[0];
	for (int i = 0; i < 10; i++){
		if(vet[i] > maior)
			maior = vet[i];
		if (vet[i] < menor)
			menor = vet[i];
		soma += vet[i];
	}
	media = (soma*1.0)/ 10;
	System.out.println("O Maior numero:"+maior);
	System.out.println("O Menor numero:"+menor);
	System.out.println("A soma:"+soma);
	System.out.println("A media:"+media);
    }

    public static void main(String args[]){
	
	int i = 0;
	int vet[] = new int [10];
	Scanner s = new Scanner (System.in);
	while (i < 10)
	{
		System.out.println("Digite o "+(i+1)+" numero:");
		vet[i] = s.nextInt();
		i++;
	}
	operar(vet);
	
    }
}