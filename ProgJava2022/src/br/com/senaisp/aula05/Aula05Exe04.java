package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sistema de calculo de peso nos planetas");
		Scanner sc = new Scanner(System.in);
		System.out.println("Opções de planetas");
		System.out.println("1 - Mercúrio");
		System.out.println("2 - Vênus");
		System.out.println("3 - Marte");
		System.out.println("4 - Júpiter");
		System.out.println("5 - Saturno");
		System.out.println("6 - Urano");
		System.out.println("Entre com o planeta desejado:");
		int intPlaneta = sc.nextInt();
		System.out.println("Entre com o peso na Terra:");
		double dblPesoTerra = sc.nextDouble();
		double dblIndice = 10.00;
		switch(intPlaneta) {
		case 1: dblIndice = 0.37; break;
		case 2: dblIndice = 0.88; break;
		case 3: dblIndice = 0.38; break;
		case 4: dblIndice = 2.64; break;
		case 5: dblIndice = 1.15; break;
		case 6: dblIndice = 1.17; break;
		default: 
			System.out.println("Planeta inválido!");
		}
		double dblPeso = dblPesoTerra / 10.00 * dblIndice;
		System.out.println("O peso no planeta selecionado é " + dblPeso);
	}

}
