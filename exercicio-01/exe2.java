public class exe2{
    public static void main(String args[]){
	int d = Integer.parseInt(args[0]);
	switch (d)
	{
		case 1:
		System.out.println("Hoje e Segunda-feira!");
		break;	
		case 2:
		System.out.println("Hoje e Terca-feira!");
		break;	
		case 3:
		System.out.println("Hoje e Quarta-feira!");
		break;	
		case 4:
		System.out.println("Hoje e Quinta-feira!");
		break;	
		case 5:
		System.out.println("Hoje e Sexta-feira!");
		break;	
		case 6:
		System.out.println("Hoje e Sabado!");
		break;	
		case 7:
		System.out.println("Hoje e Domingo!");
		break;
		default:
		System.out.println("Nao e dia de semana");
		break;	
	}        
    }
}