package br.com.senaisp.aula09;

public class Aula09Exe04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int intLinha = 1; intLinha < 10; intLinha++) {
			for (int intColuna = 1; intColuna < 10; intColuna++) {
				if (intLinha == intColuna)
					System.out.print(intLinha + "-" + intColuna + " ");
				else
					System.out.print("    ");
			}
			System.out.println();
		}
	}

}
