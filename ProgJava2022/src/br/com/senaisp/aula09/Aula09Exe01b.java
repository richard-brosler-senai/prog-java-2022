package br.com.senaisp.aula09;

public class Aula09Exe01b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intLinha = 1;
		int intColuna;
		do {
			intColuna = 1;
			do {
				System.out.print(intLinha + "-" + intColuna + " ");
				intColuna++;
			}while (intColuna < 10);
			System.out.println();
			intLinha++;
		}while (intLinha < 10);
	}
}
