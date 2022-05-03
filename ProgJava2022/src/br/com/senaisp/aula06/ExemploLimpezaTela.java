package br.com.senaisp.aula06;

import java.util.Scanner;

public class ExemploLimpezaTela {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intOpc=0;
		Scanner sc = new Scanner(System.in);
		while (intOpc!=9) {
			clearConsole();
			System.out.println("Menu de opções");
			System.out.println("1 - Soma");
			System.out.println("2 - Subtração");
			System.out.println("3 - Multiplicação");
			System.out.println("4 - Divisão");
			System.out.println("Digite sua opção:");
			intOpc = sc.nextInt();
		}
	}
	
	public static void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
