package br.com.senaisp.aula30;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
	private Map<Integer, String> listaFilmes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExemploMap ex = new ExemploMap();
		ex.listaFilmes = new HashMap<Integer, String>();
		
		System.out.println("Exemplo de uso de interface List");
		System.out.println();
		
		ex.insere(1,"Blade Runner - O caçador de androides");
		ex.insere(2,"O exterminador do futuro 2");

		ex.insere(3,"Apocalipse Now");
		ex.insere(4,"Star Wars IV - Uma nova esperança");

		ex.insere(5,"Curtindo a vida adoidado");
		ex.insere(6,"Drácula - De Bram Stocker");
		ex.insere(7,"2001 - Uma odisséia no espaço");
		
		ex.imprimirLista();
		
		ex.remove(3);
		ex.remove(6);
		
		ex.imprimirLista();
	}
	
	public void insere(int intChave, String strTitulo) {
		listaFilmes.put(intChave,strTitulo);
	}
	
	public void remove(int intChave) {
		listaFilmes.remove(intChave);
	}
	
	public void imprimirLista() {
		System.out.println();
		System.out.println();

		Collection<String> strTitulos = listaFilmes.values();
		for (String strTitulo : strTitulos) {
			System.out.println("Titulo do filme: " + strTitulo);
		}
		
	}
}
