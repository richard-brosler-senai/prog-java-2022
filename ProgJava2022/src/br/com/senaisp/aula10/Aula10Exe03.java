package br.com.senaisp.aula10;

import java.util.Locale;
import java.util.Scanner;

public class Aula10Exe03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intRes = 1; // 1- continua, 2-não continua
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		// Relativo a venda
		int intCodProd, intQtdeProd;
		double dblPrecoUnit, dblPrecoTotal, dblTotalVenda;
		String strProdDesc;
		do { //laço para continuar s/n
			dblTotalVenda = 0;
			System.out.println("Bem vindo ao sistema de frente caixa");
			do { //laço para venda do cupom fiscal
				// Tratando a entrada de dados do produto
				do {
					System.out.println("Digite o código do produto: (0 - fim da venda)");
					intCodProd = sc.nextInt();
				} while (intCodProd < 0);
				//só posso digita descrição, preço e etc se codproduto > 0
				if (intCodProd > 0) {
					sc.nextLine(); // interceptar o enter do código do produto
					System.out.println("Digite a descrição do produto:");
					strProdDesc = sc.nextLine();
					// tratando a entrada de dados da quantidade
					do {
						System.out.println("Digite a quantidade de produto:");
						intQtdeProd = sc.nextInt();
					} while (intQtdeProd <= 0);
					// tratando o preço unitário do item
					do {
						System.out.println("Digite o preço unitário do produto:");
						dblPrecoUnit = sc.nextDouble();
					} while (dblPrecoUnit <= 0);
					// calculando o preço total
					dblPrecoTotal = intQtdeProd * dblPrecoUnit;
					//acumulando o valor
					dblTotalVenda += dblPrecoTotal;
					System.out.println("O valor total do item "+ strProdDesc +
									   " foi " + dblPrecoTotal);
				}

			} while (intCodProd != 0);
			//Mostrando o total geral da venda
			System.out.println("O valor total da venda foi " + dblTotalVenda);
			//Tratamento para continuação
			do {
				System.out.println("Deseja continuar? (1-sim,2-não)");
				intRes = sc.nextInt();
			} while (intRes != 1 && intRes != 2);
			//
		}while (intRes != 2);
		System.out.println("Nossa temperatura agora é de 36.00 Celsius");
		System.out.println("Se você estivesse nos EUA seria " + 
				Aula10Exe04.calcularTemperatura(1,2,36));
		sc.close();
		//Alterei na aula alguma coisa
	}

}
