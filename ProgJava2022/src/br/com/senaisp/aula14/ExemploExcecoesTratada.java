package br.com.senaisp.aula14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploExcecoesTratada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int intNr;
		do {
			System.out.println("Digite um número:");
			//tratamento da exceção
			try {
				intNr = sc.nextInt();
			} catch(InputMismatchException erro) {
				sc.nextLine();
				intNr=-1;
				System.out.println("Entrada de dados inválida, redigite!");
			} catch(Exception e) {
				System.out.println("Ocorreu um outro erro que desconheço!" + e.getMessage());
				intNr=-1;
			}
		} while(intNr<0);
		System.out.println("Você digitou "+intNr);
		sc.close();
	}
}
