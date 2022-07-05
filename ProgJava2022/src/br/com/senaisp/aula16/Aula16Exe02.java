package br.com.senaisp.aula16;

import java.util.Scanner;

import br.com.senaisp.aula16.classes.Clientes;
import br.com.senaisp.aula16.classes.ParametroInvalidoException;

public class Aula16Exe02 {
	public static final int LIMITE_CLIENTE = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clientes cliVetor[] = new Clientes[LIMITE_CLIENTE];
		Scanner sc = new Scanner(System.in);
		int intOpc;
		do {
			System.out.println("Menu de Opções");
			System.out.println("1 - Cadastro");
			System.out.println("2 - Consulta");
			System.out.println("3 - Alteração");
			System.out.println("4 - Exclusão");
			System.out.println("5 - Listagem");
			System.out.println("9 - Fim");
			System.out.println("Digite sua Opção");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch(intOpc) {
			case 1: 
				cadastrarCliente(cliVetor, sc);
				break;
			case 2:
				System.out.println("Consulta de Clientes");
				consultaCliente(cliVetor, sc);
				break;
			case 3:
				alteracaoCliente(cliVetor, sc);
				break;
			case 4:
				exclusaoCliente(cliVetor, sc);
				break;
			case 5:
				listagemCliente(cliVetor, sc);
				break;
			}
			System.out.println("Tecle enter para continuar");
			sc.nextLine();
		}while (intOpc!=9);
	}
	private static void listagemCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Listagem de Clientes");
		System.out.println("#   - Cod - Nome");
		for (int intI=0;intI<LIMITE_CLIENTE;intI++) {
			if (cliVetor[intI]!=null) {
				//Mostra com 3 posições de string
				//O que faltar para 3 ele preenche com branco
				System.out.print(String.format("%-3s",intI+""));
				System.out.print(" - ");
				System.out.print(String.format("%-3s", 
							cliVetor[intI].getCodigo()+ ""));
				System.out.println(" - " + 
							cliVetor[intI].getNome());
			}
		}
	}
	private static void exclusaoCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Exclusão de Cliente");
		int intCod=consultaCliente(cliVetor, sc);
		if (intCod>-1) {
			System.out.println(
			"Tem certeza que deseja excluir?(1-sim,2-não)");
			int intRes=sc.nextInt();
			if (intRes==1) { 
				cliVetor[intCod]=null;
				System.out.println(
						"Cliente excluído com sucesso!");
			}
		}
		
	}
	private static void alteracaoCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Alteração de Cliente");
		int intCod=consultaCliente(cliVetor, sc);
		if (intCod>-1)
			efetuarCadastro(cliVetor[intCod], sc);
	}
	private static int consultaCliente(Clientes[] cliVetor, Scanner sc) {
		int intRet=-1, intCod;
		System.out.println("Digite o código a ser pesquisado:");
		intCod=sc.nextInt();
		for (int intI=0;intI<LIMITE_CLIENTE;intI++) {
			if (cliVetor[intI]!=null && 
				cliVetor[intI].getCodigo()==intCod) {
				intRet=intI;
				System.out.println("Cliente encontrado!");
				System.out.println("Codigo...:" + 
						cliVetor[intI].getCodigo());
				System.out.println("Nome.....:" + 
						cliVetor[intI].getNome());
				System.out.println("Endereço.:" + 
						cliVetor[intI].getEndereco());
				break;
			}
		}
		if (intCod==-1) {
			System.out.println("Cliente não encontrado!");
		}
		return intRet;
	}
	/**
	 * Função que retorna o índice disponível para ser
	 * cadastrado o cliente. Se não houver disponível
	 * retornará -1.
	 * @param cliVetor Informar o vetor de clientes.
	 * @return Retorna o índice disponível ou -1 se 
	 * não houver mais espaço para cadastramento.
	 */
	private static int getIdLivre(Clientes[] cliVetor) {
		int intRet = -1;
		for (int intI=0;intI<LIMITE_CLIENTE;intI++) {
			if (cliVetor[intI]==null) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}
	private static void cadastrarCliente(Clientes[] cliVetor, Scanner sc) {
		System.out.println("Cadastramento de Clientes");
		int intLivre = getIdLivre(cliVetor);
		if (intLivre>-1) {
			//Criando o objeto cliente e atribuindo ao vetor
			cliVetor[intLivre] = new Clientes();
			efetuarCadastro(cliVetor[intLivre], sc);
		} else {
			System.out.println("Sem espaço para mais cadastros!");
		}
	}
	private static void efetuarCadastro(Clientes clientes, Scanner sc) {
		//Entrada do código
		do {
			System.out.println("Digite o Código:");
			try {
				clientes.setCodigo(sc.nextInt());
				sc.nextLine();
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (Exception e1) {
				System.out.println("Ocorreu entrada inválida!");
				sc.nextLine();
			}
		} while(true);
		//Entrada do nome
		do {
			System.out.println("Digite o nome:");
			try {
				clientes.setNome(sc.nextLine());
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		//entrada do endereço
		do {
			System.out.println("Digite o endereço:");
			try {
				clientes.setEndereco(sc.nextLine());
				break;
			} catch (ParametroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while(true);
	}

}
