package br.com.senaisp.aula12;

import java.util.Scanner;

public class Aula12Exe01 {
	public static final int TOTAL_COLUNAS = 9; //constante
	public static final int TOTAL_LINHAS = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strCinema[][] = new String[TOTAL_LINHAS][TOTAL_COLUNAS];
		Scanner sc = new Scanner(System.in);
		limpezaCinema(strCinema);
		do {
			mostrarCinema(strCinema);
			System.out.println("Bem vindo ao Cinema 3");
			System.out.println("Digite a fileira desejada:");
			int intFil = sc.nextInt();
			System.out.println("Digite a poltrona desejada:");
			int intPol = sc.nextInt();
			if (strCinema[intFil-1][intPol-1].equals("-")) {
				System.out.println("Poltrona Reservada com sucesso!");
				strCinema[intFil-1][intPol-1] = "*";
			} else {
				System.out.println("Sentimos muito, mas a poltrona está reservada!");
			}
		} while (true);
	}

	public static void limpezaCinema(String[][] strAss) {
		for (int intLin = 0; intLin < TOTAL_LINHAS; intLin++) {
			for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
				strAss[intLin][intCol] = "-";
			}
		}
	}

	public static void mostrarCinema(String[][] strAss) {
		System.out.print("  ");
		for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
			System.out.print((intCol + 1) + " " + ( intCol<9 ? " " : "" ));
		}
		System.out.println();
		for (int intLin = 0; intLin < TOTAL_LINHAS; intLin++) {
			System.out.print((intLin + 1) + " ");
			for (int intCol = 0; intCol < TOTAL_COLUNAS; intCol++) {
				System.out.print(strAss[intLin][intCol] + "  ");
			}
			System.out.println();
		}
	}
}
