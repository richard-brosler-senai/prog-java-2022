package br.com.senaisp.aula08;

import java.util.Scanner;

public class Aula08Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intContador = 0;
		int intNumero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Programa contador de números positivos");
		do {
			System.out.println("Digite um número positivo: "+
								"(negativo finaliza o programa)");
			intNumero = sc.nextInt();
			if (intNumero>=0) { 
				intContador++;
			}
		}while (intNumero >= 0);
		System.out.println("A quantidade de números "+
					"positivos digitados foi de " + intContador );
		sc.close();
	}
}
