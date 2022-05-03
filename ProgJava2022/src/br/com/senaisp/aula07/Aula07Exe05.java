package br.com.senaisp.aula07;

import java.util.Scanner;

public class Aula07Exe05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1; //1 - sim, 2- não
		Scanner sc = new Scanner(System.in);
		while (intResp != 2) {
			System.out.println("Programa frequencia de fibonacci");
			System.out.println("Entre com o número do termo desejado:");
			int intTermo = sc.nextInt();
			int intAnt1 = 0;
			int intAnt2 = 1;
			int intApoio = 0;
			//Imprimindo o 1 e 2 termo
			System.out.print(intAnt1 + " " + intAnt2+ " ");
			for (int intCont=3; intCont <= intTermo; intCont++) {
				System.out.print( (intAnt1 + intAnt2) + " " );
				intApoio = intAnt1;
				intAnt1 = intAnt2;
				intAnt2 = intApoio + intAnt2;
			}
			System.out.println("Deseja continuar? (1-Sim, 2-Não)");
			intResp = sc.nextInt();
		}
		sc.close();
	}

}
