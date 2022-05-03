package br.com.senaisp.aula10;

import java.util.Scanner;

public class Aula10Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Variáveis
		int intCodigoVen, intQtdePc;
		double dblPrecoUn, dblPrecoTot;
		String strNome;
		//Variáveis de controle dos maiores e menores
		int intQtdPcMenor=Integer.MAX_VALUE;
		int intQtdPcMaior=Integer.MIN_VALUE;
		double dblTotMenor = Double.MAX_VALUE;
		double dblTotMaior = Double.MIN_VALUE;
		String strNomeQtdMenor="", strNomeQtdMaior="", 
			   strNomeTotMenor="", strNomeTotMaior="";
		// Scanner
		Scanner sc = new Scanner(System.in);
		do {
			// Entrada do código do vendedor com tratamento
			do {
				System.out.println("Sistema de controle de vendas de peças");
				System.out.println("Digite codigo vendedor: (0-Fim)");
				intCodigoVen = sc.nextInt();
			} while (intCodigoVen < 0);
			// Só posso digitar os dados da venda se o vendedor for maior que zero
			if (intCodigoVen > 0) {
				sc.nextLine();// para retirar o enter do comando anterior
				// Entrada de nome
				do {
					System.out.println("Digite o nome do vendedor:");
					strNome = sc.nextLine();
				} while (strNome.isEmpty() || strNome.length() < 3);

				// Entrada da quantidade de itens
				do {
					System.out.println("Digite a quantidade de peças:");
					intQtdePc = sc.nextInt();
				} while (intQtdePc <= 0);

				// Entrando com o preço unitário
				do {
					System.out.println("Digite o preço unitário:");
					dblPrecoUn = sc.nextDouble();
				} while (dblPrecoUn <= 0);
				dblPrecoTot = dblPrecoUn * intQtdePc;
				System.out.println("Total da venda: R$ " + dblPrecoTot);
				//Verificações de maiores e menores
				//Testando Quantidades
				//Verificando menores quantidades
				if (intQtdePc<intQtdPcMenor) {
					intQtdPcMenor = intQtdePc;
					strNomeQtdMenor = strNome;
				}
				//Verificando maiores quantidades
				if (intQtdePc>intQtdPcMaior) {
					intQtdPcMaior = intQtdePc;
					strNomeQtdMaior = strNome;
				}
				//Testando valores
				//Testando menor valor de venda
				if (dblPrecoTot<dblTotMenor) {
					dblTotMenor = dblPrecoTot;
					strNomeTotMenor = strNome;
				}
				//Testando maior valor de venda
				if (dblPrecoTot>dblTotMaior) {
					dblTotMaior = dblPrecoTot;
					strNomeTotMaior = strNome;
				}
			}
		} while (intCodigoVen != 0);
		//Mostrando os resultados
		System.out.println("Maior Quantidade Vendida:" + intQtdPcMaior);
		System.out.println("                Vendedor:" + strNomeQtdMaior);
		System.out.println();
		System.out.println("Menor Quantidade Vendida:" + intQtdPcMenor);
		System.out.println("                Vendedor:" + strNomeQtdMenor);
		System.out.println("----------------------------------------------");
		System.out.println("Maior Valor de venda:" + dblTotMaior);
		System.out.println("            Vendedor:" + strNomeTotMaior);
		System.out.println();
		System.out.println("Menor Valor Venda:" + dblTotMenor);
		System.out.println("         Vendedor:" + strNomeTotMenor);		
		//Finalizando o recurso do scanner
		sc.close();
	}

}
