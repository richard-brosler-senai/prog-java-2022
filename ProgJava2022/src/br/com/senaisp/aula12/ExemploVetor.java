package br.com.senaisp.aula12;

import java.util.Scanner;

public class ExemploVetor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declarando um vetor de 10 posições inteiras
		int intVetor[] = new int[10];
		Scanner sc = new Scanner(System.in);
		//agora podemos acessar as 10 posiões do vetor 0..9
		for(int intI=0;intI<10;intI++) {
			System.out.println("Digite o valor de intInt["+intI+"]:");
			intVetor[intI] = sc.nextInt();
		}
		//listando os valores
		for(int intI=0;intI<10;intI++) {
			System.out.println("O valor de intInt["+intI+"] é " + intVetor[intI]);
		}
		sc.close();
	}
}
