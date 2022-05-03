package br.com.senaisp.aula09;

public class Aula09Exe01a {

	public static void main(String[] args) {
		// Utilizando o While ao invés de For
		int intLinha = 1;
		int intColuna;
		while (intLinha < 10) {
			intColuna = 1;
			while (intColuna < 10) {
				System.out.print(intLinha + "-" + intColuna + " ");
				intColuna++;
			}
			System.out.println();
			intLinha++;
		}
	}

}
