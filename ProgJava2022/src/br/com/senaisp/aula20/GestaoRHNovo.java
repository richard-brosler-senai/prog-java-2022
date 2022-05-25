package br.com.senaisp.aula20;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.Funcionario;
import br.com.senaisp.aula18.classes.ImpostoIrrf;
import br.com.senaisp.aula19.classes.FolhaPagamento;

public class GestaoRHNovo {
	//Definindo objetos Globais
	private static List<Funcionario> listaFuncionario;
	private static List<FolhaPagamento> listaFolha;
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Inicializando objetos
		listaFuncionario = new ArrayList<Funcionario>();
		listaFolha = new ArrayList<FolhaPagamento>();
		sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		int intOpc;
		
		do {
			System.out.println("Menu de op��es");
			System.out.println("1 - Cadastramento Funcion�rios");
			System.out.println("2 - Lista de Funcion�rios");
			System.out.println("3 - Altera��o de Funcion�rios");
			System.out.println("4 - Exclus�o de Funcion�rios");
			System.out.println("5 - Lan�amento na Folha");
			System.out.println("6 - Listagem da Folha");
			System.out.println("7 - Exclus�o Lan�amento da Folha");
			System.out.println("9 - Fim");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch (intOpc) {
			case 1: 
				cadastrarFuncionario(); //Terminado
				break;
			case 2:
				listagemFuncionario();// Terminado
				break;
			case 3:
				alteracaoFuncionario(); //terminado
				break;
			case 4:
				exclusaoFuncionario(); //terminado
				break;
			case 5:
				lancamentoFolha();
				break;
			case 6:
				listagemFolha();
				break;
			case 7:
				exclusaoFolha();
				break;
			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();
		} while(intOpc != 9);		
		
	}

	private static void exclusaoFolha() {
		System.out.println("Exclus�o Lan�amento Folha");
		int intChapa=pesquisarFuncionario();
		if (intChapa>-1) {
			Funcionario fun = listaFuncionario.get(intChapa);
			int intFol = pesqLancto(fun.getChapa());
			if (intFol>-1) {
				System.out.println("Deseja mesmo excluir Lan�amento? 1-Sim, 2-N�o");
				int intResp=sc.nextInt();
				sc.nextLine();
				if (intResp==1) {
					listaFolha.remove(intFol);
				}
			} else {
				System.out.println("Lan�amento n�o encontrado!");
			}
		} else {
			System.out.println("Funcion�rio n�o existe!");
		}
		
	}

	private static void listagemFolha() {
		System.out.println("Listagem de Folha");
		System.out.println("Codigo - Salario");
		System.out.println("----------------------------");
		for (int intI=0; intI< listaFolha.size(); intI++) {
			FolhaPagamento fol = listaFolha.get(intI);
			System.out.println(fol.getChapaFuncionario()+" - "+
								fol.valorSalarioLiquido());
		}
	}

	private static void lancamentoFolha() {
		System.out.println("Lan�amento na Folha");
		int intChapa=pesquisarFuncionario();
		if (intChapa>-1) {
			Funcionario fun = listaFuncionario.get(intChapa);
			int intLan=pesqLancto(fun.getChapa());
			if (intLan==-1) {
				FolhaPagamento fol = new FolhaPagamento();
				try {
					fol.setChapaFuncionario(fun.getChapa());
					fol.setSalarioBruto(fun.getSalario());
					
					ImpostoInss inss = new ImpostoInss();
					ImpostoIrrf irrf = new ImpostoIrrf();
					
					inss.setBaseCalculo(fun.getSalario());
					fol.setValorInss(inss.calcularImposto());
					
					irrf.setBaseCalculo(fun.getSalario());
					irrf.setNrDependentes(fun.getNrDependentes());
					fol.setValorIrrf(irrf.calcularImposto());
					//adicionando � lista da folha
					listaFolha.add(fol);
					System.out.println("Sal�rio l�quido: " + 
							fol.valorSalarioLiquido());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}

	private static int pesqLancto(int intChapa) {
		int intRet=-1;
		for(int intI=0;intI < listaFolha.size();intI++) {
			if (listaFolha.get(intI).getChapaFuncionario()==intChapa) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}

	private static void exclusaoFuncionario() {
		System.out.println("Exclus�o de Funcion�rio");
		int intPesq = pesquisarFuncionario();
		if (intPesq>-1) {
			Funcionario fun = listaFuncionario.get(intPesq);
			mostrarFuncionario(fun);
			System.out.println("Deseja excluir? 1-sim, 2-n�o");
			int intResp=sc.nextInt();
			sc.nextLine();
			if (intResp==1) {
				listaFuncionario.remove(intPesq);
			}
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}
	}

	private static void alteracaoFuncionario() {
		System.out.println("Altera��o de Funcion�rio");
		int intPesq = pesquisarFuncionario();
		if (intPesq>-1) {
			Funcionario fun = listaFuncionario.get(intPesq);
			mostrarFuncionario(fun);
			manutencaoFuncionario(fun);
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}
	}

	private static void mostrarFuncionario(Funcionario funcionario) {
		System.out.println("Chapa do funcion�rio....: " +funcionario.getChapa());
		System.out.println("Nome do funcion�rio.....: " +funcionario.getNome());
		System.out.println("Endere�o do funcion�rio.: " +funcionario.getEndereco());
		System.out.println("Nr. Dep. do funcion�rio.: " +funcionario.getNrDependentes());
		System.out.println("Sal�rio do funcion�rio..: " +funcionario.getSalario());
	}

	private static int pesquisarFuncionario() {
		System.out.println("Digite a chapa do funcion�rio a pesquisar:");
		int intChapa=sc.nextInt();
		sc.nextLine();
		return pesqFunc(intChapa);
	}

	private static void listagemFuncionario() {
		System.out.println("Listagem de Funcion�rios");
		System.out.println("Codigo - Nome");
		System.out.println("----------------------------");
		for (int intI=0; intI< listaFuncionario.size(); intI++) {
			Funcionario fun = listaFuncionario.get(intI);
			System.out.println(fun.getChapa()+" - "+fun.getNome());
		}
	}

	private static void cadastrarFuncionario() {
		System.out.println("Cadastramento do Funcion�rio");
		//Criando o objeto do funcion�rio
		Funcionario fun = new Funcionario();
		//Chamando o m�todo de cadastramento
		manutencaoFuncionario(fun);
		//Adicionando na lista de funcion�rios
		listaFuncionario.add(fun);
	}

	private static void manutencaoFuncionario(Funcionario funcionario) {
		do {
			System.out.println("Digite a Chapa do funcion�rio:");
			try {
				int intNrChapa = sc.nextInt();
				//se a chapa digitada for diferente da chapa que o funcion�rio
				//tem no objeto posicionado, tenho que pesquisar
				//se j� existe um funcion�rio com essa chapa
				//Se existir, dever� usar outra chapa
				if (intNrChapa!=funcionario.getChapa()) {
					if (pesqFunc(intNrChapa)!=-1) {
						System.out.println("Chapa j� existe para um funcion�rio! Redigite.");
						continue;
					}
				}
				funcionario.setChapa(intNrChapa);
				sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) sc.nextLine();
			}
		} while(true);
		//Nome do funcion�rio
		do {
			System.out.println("Digite o nome do funcion�rio:");
			try {
				funcionario.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//Endere�o do funcion�rio
		do {
			System.out.println("Digite o endere�o do funcion�rio:");
			try {
				funcionario.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//N�mero de dependentes do funcion�rio
		do {
			System.out.println("Digite o N�mero de dependentes do funcion�rio:");
			try {
				funcionario.setNrDependentes(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) 
					sc.nextLine();
			}
		}while (true);
		//Sal�rio do Funcion�rio
		do {
			System.out.println("Digite o Sal�rio do funcion�rio:");
			try {
				funcionario.setSalario(sc.nextDouble());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) 
					sc.nextLine();
			}
		}while (true);
		sc.nextLine();
		
	}

	private static int pesqFunc(int intChapa) {
		int intRet = -1;
		for (int intI=0;intI<listaFuncionario.size();intI++) {
			if (listaFuncionario.get(intI).getChapa() == intChapa) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}

}
