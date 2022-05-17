package pacoteteste;

import java.util.Scanner;

public class TesteEscolha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite sua idade:");
		int idade=sc.nextInt();
		switch(idade) {
		case 18:
		case 19:
		case 20:
		case 21:
		case 22:
		case 23:
		case 24:
			System.out.println("Você tem de 18 a 24 anos");
			break;
		case 25:
		case 27:
		case 30:
			System.out.println("Você tem 25,27,30 anos");
			break;
		}
		sc.close();
	}

}
