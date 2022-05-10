package br.com.senaisp.aula14;

import java.util.Scanner;

public class ExemploExcecoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Digite um número:");
			int intNr = sc.nextInt();
			System.out.println("Você digitou "+intNr);
		} while(true);
		//sc.close();
	}

}
