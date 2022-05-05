package br.com.senaisp.aula13;

import java.util.Scanner;

public class Aula13Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int intNumero[] = new int[10];
		//Entrando com os numeros
		for (int intI = 0; intI < 10; intI++) {
			System.out.println("Digite o numero da posição "+ ( intI + 1) +" :");
			intNumero[intI] = sc.nextInt();
		}
		//Ordenando os valores - BubbleSort - Bolha
		int intApoio;
		for (int intI=0; intI<9; intI++) {
			for (int intF=intI; intF<10; intF++) {
				//Ordenação Ascendente
				if (intNumero[intI] < intNumero[intF] ) {
					intApoio = intNumero[intI];
					intNumero[intI] = intNumero[intF];
					intNumero[intF] = intApoio;
				}
			}
		}
		//Mostrando os nomes
		System.out.println("Mostrando os valores digitados!");
		for (int intI = 0; intI < 10; intI++) {
			System.out.println(intNumero[intI]);
		}
		sc.close();
	}

}
