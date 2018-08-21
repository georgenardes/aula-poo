public class exe3{
    public static void main(String args[]){
	String d [] ={"Janeiro","Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}; //new String [12];
	int i = Integer.parseInt(args[0]);
	System.out.println(d[i-1]);
    }
}