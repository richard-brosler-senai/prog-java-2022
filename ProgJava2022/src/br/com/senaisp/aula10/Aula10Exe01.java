package br.com.senaisp.aula10;

import java.util.Scanner;

public class Aula10Exe01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intRes=1, intCont, intPrimo, intNrTermos, intContDiv;
		Scanner sc = new Scanner(System.in);
		do {
			//Limitando para que o usuário digite valores maiores que zero 
			// e menor ou igual 15
			do {
				System.out.println("Digite a quantidade de termos primos desejada:");
				intNrTermos = sc.nextInt();
			} while (intNrTermos<=0 || intNrTermos>15);//1 a 15 sai do laço
			// while (!(intNrTermos>0 && intNrTermos<=15)); 
			intCont = 1; 
			intPrimo = 0;
			while (intPrimo<intNrTermos) {
				intContDiv=0;
				for(int intPasso=1;intPasso<=intCont;intPasso++) {
					if (intCont % intPasso == 0) {
						intContDiv++;
					}//fim do if
				}//fim do for
				if (intContDiv<=2) {
					//if (intPrimo!=0) System.out.print(",");
					System.out.print(intCont);
					intPrimo++;
					if (intPrimo<intNrTermos) System.out.print(",");
				}//fim do if
				intCont++;
			}//fim do while
			System.out.println("."); //pular a linha depois dos termos mostrados
			//tratamento para garantir que o usuário vai digitar 1 ou 2
			do {
				System.out.println("Deseja continuar? (1-sim,2-não):");
				intRes = sc.nextInt();
			} while (intRes!=1 && intRes!=2);
		} while(intRes!=2);
		sc.close();
	}

}
