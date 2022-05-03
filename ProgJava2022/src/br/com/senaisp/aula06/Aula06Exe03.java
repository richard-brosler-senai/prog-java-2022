package br.com.senaisp.aula06;

import java.util.Scanner;

public class Aula06Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp = 1;
		Scanner sc = new Scanner(System.in);
		while (intResp != 2) {
			System.out.println("Verificação de número primo");
			System.out.println("Digite um número a ser verificado:");
			int intNr = sc.nextInt();
			int intContDivisores = 1; // contar os divisores
			int intContador = 1; // contar até o número
			while (intContador < intNr) {
				intContador++;
				if (intNr % intContador == 0)
					intContDivisores++;
			}//While do contador
			if (intContDivisores > 2)
				System.out.println("O número não é primo!");
			else
				System.out.println("O número é primo");
			System.out.println("Deseja continuar? (1-sim,2-não):");
			intResp = sc.nextInt();
		}//Fechamento While SIM/Não
	}

}
