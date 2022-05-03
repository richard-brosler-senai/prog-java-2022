package br.com.senaisp.aula04;

import java.util.Scanner;

public class CalculoJurosFuturos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calculo de aplicação futura");
		System.out.println("Digite o valor a ser aplicado:");
		Scanner sc = new Scanner(System.in);
		double dblValorAplicado = sc.nextDouble();
		System.out.println("Digite o Tempo de aplicação (meses):");
		int intTempoAplicacao = sc.nextInt();
		System.out.println("Digite o percentual de juros:");
		double dblJuros = sc.nextDouble();
		//calculando os Juros
		double dblValorFuturo = dblValorAplicado * 
					Math.pow((1 + dblJuros / 100.00), intTempoAplicacao);
		//mostrando o resultado
		System.out.println("O valor aplicado será de R$ " + dblValorFuturo);
				

	}

}
