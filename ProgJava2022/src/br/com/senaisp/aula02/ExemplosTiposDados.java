package br.com.senaisp.aula02;

import java.util.Scanner;

public class ExemplosTiposDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Aqui estamos fazendo uma soma
		int intSoma = 5 + 2;
		System.out.println("Soma: " + intSoma);
		//Aqui estamos fazendo uma subtração
		int intSubtracao = 5 - 2;
		System.out.println("Subtração: " + intSubtracao);
		//Aqui estamos fazendo uma multiplicação
		int intMultiplicacao = 3 * 2;
		System.out.println("Multiplicação: " + intMultiplicacao);
		//Aqui estamos fazendo uma divisão inteira (nesse caso temos 2 inteiros)
		int intDivisao = 3 / 2;
		System.out.println("Divisão Inteira: " + intDivisao);
		//Aqui estamos fazendo uma divisão com ponto flutuante.
		double dblDivisao = 3.00 / 2.00;
		System.out.println("Divisão: " + dblDivisao);
		//Aqui estamos fazendo o resto de uma divisão
		int intResto = 3 % 2;
		System.out.println("Resto: " + intResto);
		//Usando somente o print (não o println)
		System.out.print("Mostrando um valor");
		System.out.println("Outro valor");
		//Utilizando entrada de dados
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome:");
		//Nesse ponto iremos solicitar ao usuário a entrada de dados
		String strNome = sc.nextLine();
		System.out.println("Olá " + strNome);		
	}

}
