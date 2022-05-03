package br.com.senaisp.aula05;

import java.util.Scanner;

public class Aula05Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calculo de empréstimo da PM Bauru");
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o valor do salário bruto:");
		double dblSalario = sc.nextDouble();
		System.out.println("Digite o valor da parcela a ser contratada:");
		double dblParcela = sc.nextDouble();
		//verificando se é possível contrair a dívida :-)
		if (dblSalario * 30 / 100.00 >= dblParcela)
			System.out.println("Parabéns, seu empréstimo foi aprovado!");
		else
			System.out.println("Infelizmente seu empréstimo não foi aprovado! :-(");
		
	}

}
