package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalculoIrrf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Programa de calculo do IRRF");
		System.out.println("Digite o salário base (acima de 5.000,00):");
		Scanner sc = new Scanner(System.in);
		double dblSalarioBase = sc.nextDouble();
		System.out.println("Digite o número de dependentes:");
		int intNrDependentes = sc.nextInt();
		double dblIrrfBase = dblSalarioBase - intNrDependentes * 189.9 -
							 828.38;
		double dblIrrfVlr = dblIrrfBase * 27.5 / 100.00 - 869.36;
		System.out.println("A base de calculo do IRRF é " + dblIrrfBase);
		System.out.println("O valor do IRRF é " + dblIrrfVlr);
	}

}
