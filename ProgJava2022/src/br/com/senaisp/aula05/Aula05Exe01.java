package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Verificação de valores pares ou impares");
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um valor a ser verificado:");
		int intVlr = sc.nextInt();
		if ( intVlr % 2 == 0 )
			System.out.println("O número digitado é Par");
		else
			System.out.println("O número digitado é Impar");
	}

}
