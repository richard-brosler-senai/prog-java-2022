package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalcDigVerAgencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calculo do dígito verificado de agência");
		System.out.println("Entre com o número da Agência (max. 4 díg.):");
		Scanner sc = new Scanner(System.in);
		int intNrAgencia = sc.nextInt();
		//calculando o dígito
		int intUn = intNrAgencia % 10;
		int intDz = intNrAgencia % 100 / 10;
		int intCn = intNrAgencia % 1000 / 100;
		int intMl = intNrAgencia / 1000;
		int intSoma = intUn * 6 + intDz * 7 + intCn * 8 + intMl * 9;
		int intDig = 10 - intSoma % 10;
		System.out.println("O dígito verificado é " + intDig);
	}

}
