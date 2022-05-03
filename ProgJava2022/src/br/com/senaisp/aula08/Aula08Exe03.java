package br.com.senaisp.aula08;

import java.util.Scanner;

public class Aula08Exe03 {

	public static void main(String[] args) {
		int intMenor = Integer.MAX_VALUE;
		int intMaior = Integer.MIN_VALUE;
		int intNumero;
		Scanner sc = new Scanner(System.in);
		System.out.println("Programa Menor e maior de números positivos");
		do {
			System.out.println("Digite um número positivo: " + "(negativo finaliza o programa)");
			intNumero = sc.nextInt();
			if (intNumero >= 0) {
				if (intNumero > intMaior)
					intMaior = intNumero;
				if (intNumero < intMenor)
					intMenor = intNumero;
			}
		} while (intNumero >= 0);
		System.out.println("O menor é " + intMenor);
		System.out.println("O maior é " + intMaior);
		sc.close();
	}

}
