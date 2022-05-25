package br.com.senaisp.aula19;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.Funcionario;
import br.com.senaisp.aula18.classes.ImpostoIrrf;
import br.com.senaisp.aula19.classes.FolhaPagamento;

public class GestaoRH {
	public static final int LIMITE_FUNCIONARIOS = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		int intOpc=0;
		Funcionario listaFuncionario[] = new Funcionario[LIMITE_FUNCIONARIOS];
		FolhaPagamento listaFolha[] = new FolhaPagamento[LIMITE_FUNCIONARIOS];
		
		do {
			System.out.println("Menu de opções");
			System.out.println("1 - Cadastramento Funcionários");
			System.out.println("2 - Lista de Funcionários");
			System.out.println("3 - Alteração de Funcionários");
			System.out.println("4 - Exclusão de Funcionários");
			System.out.println("5 - Lançamento na Folha");
			System.out.println("6 - Listagem da Folha");
			System.out.println("7 - Exclusão Lançamento da Folha");
			System.out.println("9 - Fim");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch (intOpc) {
			case 1: 
				cadastrarFuncionario(listaFuncionario,sc);
				break;
			case 2:
				listagemFuncionario(listaFuncionario);
				break;
			case 3:
				alteracaoFuncionario(listaFuncionario,sc);
				break;
			case 4:
				exclusaoFuncionario(listaFuncionario,sc);
				break;
			case 5:
				lancamentoFolha(listaFolha, listaFuncionario, sc);
				break;
			case 6:
				listagemFolha(listaFolha);
				break;
			case 7:
				exclusaoFolha(listaFolha, sc);
				break;
			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();
		} while(intOpc != 9);

	}
	private static void exclusaoFolha(FolhaPagamento[] listaFolha, 
				Scanner sc) {
		int intIdFunc=-1;
		do {
			System.out.println("Digite a chapa do funcionário:");
			int intChapa=sc.nextInt();
			sc.nextLine();
			//Funcionário deve existir para lançá-lo na folha
			intIdFunc=pesqLancto(listaFolha, intChapa);
			if (intIdFunc>-1) {
				System.out.println("Deseja mesmo excluir? (1-sim, 2-não)");
				int intResp = sc.nextInt();
				sc.nextLine();
				if (intResp==1) {
					listaFolha[intIdFunc]=null;
				}
				break;
			} else {
				System.out.println("Lançamento não encontrado!");
			}
		}while (true);
	}
	/**
	 * Método de listagem da folha de pagamento
	 * @param listaFolha Deve ser informada a lista da folha de pagamento
	 */
	private static void listagemFolha(FolhaPagamento[] listaFolha) {
		System.out.println("Listagem da folha");
		System.out.println("# - Chapa - Salário Líquido");
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]!=null) {
				System.out.println(intI + " - " +
						listaFolha[intI].getChapaFuncionario() + " - " + 
						listaFolha[intI].valorSalarioLiquido());
			}
		}
	}
	/**
	 * Método que fará o lançamento na folha de pagamento
	 * @param listaFolha Deve ser informada a lista da folha de pagamento
	 * @param listaFuncionario Deve ser informada a lista de funcionários para pesquisa de funcionários
	 * @param sc Deve ser informado o objeto scanner para digitação via teclado.
	 */
	private static void lancamentoFolha(FolhaPagamento[] listaFolha, Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Lançamento na folha");
		//pesquisando o item disponivel
		int intDisp = -1;
		for (int intI=0; intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]==null) {
				intDisp = intI;
				break;
			}
		}
		if (intDisp>-1) {
			listaFolha[intDisp] = new FolhaPagamento();
			manutencaoFolhaPagamento(listaFolha[intDisp],sc,
						listaFuncionario, listaFolha);
		} else {
			System.out.println("Folha de pagamento cheia!");
		}
	}
	/**
	 * Método auxiliar para cadastramento na folha de pagamento
	 * @param folhaPagamento Deve ser informado o objeto da folha de pagamento para manutenção
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados via teclado
	 * @param listaFuncionario Deve ser informada a lista de funcionários para pesquisa do funcionário
	 * @param listaFolha Deve ser informada a lista da folha para pesquisa se existe lançamento do funcionário na
	 * listagem da folha
	 */
	private static void manutencaoFolhaPagamento(FolhaPagamento folhaPagamento, Scanner sc,
			Funcionario[] listaFuncionario, FolhaPagamento[] listaFolha) {
		int intIdFunc=-1;
		do {
			System.out.println("Digite a chapa do funcionário:");
			int intChapa=sc.nextInt();
			sc.nextLine();
			//Funcionário deve existir para lançá-lo na folha
			intIdFunc = pesqFunc(listaFuncionario, intChapa);
			if (intIdFunc==-1) {
				System.out.println("Funcionário não existe!");
				continue;
			}
			if (pesqLancto(listaFolha, intChapa)>-1) {
				System.out.println("Lançamento da folha do funcionário já existe!");
				continue;
			}
			try {
				folhaPagamento.setChapaFuncionario(intChapa);
				//Colocando o salário bruto através do salário do funcionário
				//cadastrado
				folhaPagamento.setSalarioBruto(listaFuncionario[intIdFunc].getSalario());
				//Criando os objetos de impostos para serem calculados
				ImpostoInss inss = new ImpostoInss();
				ImpostoIrrf irrf = new ImpostoIrrf();
				//Setando a base de calculo do inss pelo salário bruto informado
				inss.setBaseCalculo(folhaPagamento.getSalarioBruto());
				//Setando o valor do inss na folha de pagamento
				folhaPagamento.setValorInss(inss.calcularImposto());
				//Setando a base de calculo do IRRF através do salário
				//bruto na folha - o valor do inss calculado
				irrf.setBaseCalculo(folhaPagamento.getSalarioBruto() - 
									folhaPagamento.getValorInss());
				//Informando o numero de dependentes do funcionário.
				irrf.setNrDependentes(
						listaFuncionario[intIdFunc].getNrDependentes());
				//setando o irrf calculado na folha
				folhaPagamento.setValorIrrf(irrf.calcularImposto());
				//mostrando o salário líquido
				System.out.println("Salário Líquido: " + 
						folhaPagamento.valorSalarioLiquido());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
	}
	/**
	 * Função para pesquisa do lançamento na folha
	 * @param listaFolha Deve ser informada a lista da folha para ser pesquisada
	 * @param intChapa Deve ser informada a chapa do funcionário para ser pesquisada
	 * na lista da folha
	 * @return Retorna o id de lançamento na lista da folha
	 */
	private static int pesqLancto(FolhaPagamento[] listaFolha, int intChapa) {
		int intRet = -1;
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]!=null && 
				listaFolha[intI].getChapaFuncionario() == intChapa) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
	/**
	 * Método de exclusão de funcionários da lista de funcionários.
	 * @param listaFuncionario Deve ser informada a lista de funcionários
	 * para que possa ser pesquisado e excluído o funcionário.
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados
	 * via teclado.
	 */
	private static void exclusaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Exclusão do Funcionário");
		int intFun = pesquisarFuncionario(listaFuncionario,sc);
		if (intFun>-1) {
			mostrarCliente(listaFuncionario[intFun]);
			System.out.println("-----------------------------");
			System.out.println("Deseja mesmo excluir? 1-sim, 2-não");
			int intOpc=sc.nextInt();
			if (intOpc==1) { 
				listaFuncionario[intFun] = null;
			}
			sc.nextLine();
		} else {
			System.out.println("Funcionário não encontrado!");
		}
	}
	/**
	 * Método de alteração de funcionários
	 * @param listaFuncionario Deve ser informada a lista de funcionários
	 * para ser pesquisada e alterado o funcionário.
	 * @param sc Deve ser informado o objeto Scanner para que possa ser
	 * dado entrada de dados via teclado.
	 */
	private static void alteracaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Alteração do Funcionário");
		int intFun = pesquisarFuncionario(listaFuncionario,sc);
		if (intFun>-1) {
			mostrarCliente(listaFuncionario[intFun]);
			System.out.println("-----------------------------");
			manutencaoFuncionario(listaFuncionario[intFun], sc, listaFuncionario);
		} else {
			System.out.println("Funcionário não encontrado!");
		}
	}
	/**
	 * Mostra os dados do funcionário
	 * @param funcionario Deve ser informado o objeto funcionário a ser
	 * impresso os dados.
	 */
	private static void mostrarCliente(Funcionario funcionario) {
		System.out.println("Chapa do funcionário....: " +funcionario.getChapa());
		System.out.println("Nome do funcionário.....: " +funcionario.getNome());
		System.out.println("Endereço do funcionário.: " +funcionario.getEndereco());
		System.out.println("Nr. Dep. do funcionário.: " +funcionario.getNrDependentes());
		System.out.println("Salário do funcionário..: " +funcionario.getSalario());
	}
	/**
	 * Método de pesquisa de funcionários
	 * @param listaFuncionario Deve ser informada a lista de funcionários para ser pesquisada.
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados via teclado.
	 * @return Retorna o id de lançamento na lista de funcionários ou -1 se não encontrou.
	 */
	private static int pesquisarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Digite o número da chapa ser pesquisada:");
		int intChapa=sc.nextInt();
		sc.nextLine();
		return pesqFunc(listaFuncionario, intChapa);
	}
	/**
	 * Função para pesquisar se encontra uma chapa na lista de funcionários
	 * @param listaFuncionario Deve-se passar a lista de funcionários
	 * @param intChapa Deve-se passar a chapa a ser pesquisada
	 * @return Retorna o índice onde se encontra a chapa ou -1 se não
	 * encontrou o funcionário com a chapa informada
	 */
	private static int pesqFunc(Funcionario[] listaFuncionario, 
									int intChapa) {
		int intRet = -1;
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFuncionario[intI]!=null && 
					listaFuncionario[intI].getChapa() == intChapa) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
	
	private static void listagemFuncionario(Funcionario[] listaFuncionario) {
		System.out.println("Listagem de Funcionários");
		System.out.println("# - Chapa - Nome");
		System.out.println("----------------------------------");
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFuncionario[intI]!=null) {
				System.out.print(intI+" - ");
				System.out.print(listaFuncionario[intI].getChapa()+ " - ");
				System.out.println(listaFuncionario[intI].getNome());
			}
		}	
	}

	private static void cadastrarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		//Encontrando o item livre da lista para cadastrar o funcionário
		int intDisp=-1;
		for (int intI=0;intI<listaFuncionario.length;intI++) {
			if (listaFuncionario[intI]==null) {
				intDisp = intI;
				break;
			}
		}
		//Início do cadastro
		System.out.println("Cadastramento do Funcionário");
		if (intDisp>-1) {
			//Criando o objeto do funcionário
			listaFuncionario[intDisp] = new Funcionario();
			//Chamando o método de cadastramento
			manutencaoFuncionario(listaFuncionario[intDisp],sc,listaFuncionario);
		} else {
			System.out.println("Não há espaço para cadastrar funcionário");
		}
	}

	private static void manutencaoFuncionario(Funcionario funcionario, Scanner sc, 
											  Funcionario[] listaFuncionario) {
		do {
			System.out.println("Digite a Chapa do funcionário:");
			try {
				int intNrChapa = sc.nextInt();
				//se a chapa digitada for diferente da chapa que o funcionário
				//tem no objeto posicionado, tenho que pesquisar
				//se já existe um funcionário com essa chapa
				//Se existir, deverá usar outra chapa
				if (intNrChapa!=funcionario.getChapa()) {
					if (pesqFunc(listaFuncionario, intNrChapa)!=-1) {
						System.out.println("Chapa já existe para um funcionário! Redigite.");
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
		//Nome do funcionário
		do {
			System.out.println("Digite o nome do funcionário:");
			try {
				funcionario.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//Endereço do funcionário
		do {
			System.out.println("Digite o endereço do funcionário:");
			try {
				funcionario.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//Número de dependentes do funcionário
		do {
			System.out.println("Digite o Número de dependentes do funcionário:");
			try {
				funcionario.setNrDependentes(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) 
					sc.nextLine();
			}
		}while (true);
		//Salário do Funcionário
		do {
			System.out.println("Digite o Salário do funcionário:");
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

}
