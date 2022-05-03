package br.com.senaisp.aula06;

import java.util.Locale;
import java.util.Scanner;

public class Aula06Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1; // 1 - sim , 2 -não
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		while (intResp != 2) {
			// Limpeza de tela
			//
			System.out.println("Programa de calculo de IMC");
			System.out.println("Digite seu peso:");
			double dblPeso = sc.nextDouble();
			System.out.println("Digite sua altura em Metros:");
			double dblAltura = sc.nextDouble();
			double dblImc = dblPeso / (dblAltura * dblAltura); // Math.pow(dblAltura, 2)
			System.out.println("Seu IMC é " + dblImc);
			if (dblImc < 20.00)
				System.out.println("Abaixo do peso");
			else if (dblImc >= 20.00 && dblImc <= 25.00)
				System.out.println("Normal");
			else if (dblImc > 25.00 && dblImc <= 30.00)
				System.out.println("Excesso de peso");
			else if (dblImc > 30.00 && dblImc <= 35.00)
				System.out.println("Obesidade");
			else
				System.out.println("Obesidade mórbida");
			System.out.println("Deseja continuar? (1-sim/2-não):");
			intResp = sc.nextInt();
		}
	}

}
