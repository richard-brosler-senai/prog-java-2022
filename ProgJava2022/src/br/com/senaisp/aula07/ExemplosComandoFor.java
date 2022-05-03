package br.com.senaisp.aula07;

public class ExemplosComandoFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for( int intValor = 10; intValor > 0; intValor--){
			if (intValor % 2 == 0)
				System.out.println("O número " + intValor + " é par");
			else 
				System.out.println("O número " + intValor + " é impar");
		}
	}

}
