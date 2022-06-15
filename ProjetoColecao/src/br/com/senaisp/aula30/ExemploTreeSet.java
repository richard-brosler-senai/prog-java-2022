package br.com.senaisp.aula30;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ExemploTreeSet {
	private Set<String> listaFilmes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExemploTreeSet ex = new ExemploTreeSet();
		ex.listaFilmes = new TreeSet<String>();
		
		System.out.println("Exemplo de uso de interface List");
		System.out.println();
		
		ex.insere("Blade Runner - O ca�ador de androides");
		ex.insere("O exterminador do futuro 2");
		ex.insere("O exterminador do futuro 2");

		ex.insere("Apocalipse Now");
		ex.insere("Star Wars IV - Uma nova esperan�a");

		ex.insere("Curtindo a vida adoidado");
		ex.insere("Dr�cula - De Bram Stocker");
		ex.insere("2001 - Uma odiss�ia no espa�o");
		
		ex.imprimirLista();
		
		ex.remove("Apocalipse Now");
		ex.remove("2001 - Uma odiss�ia no espa�o");
		
		ex.imprimirLista();
	}
	
	public void insere(String strTitulo) {
		listaFilmes.add(strTitulo);
	}
	
	public void remove(String strTitulo) {
		listaFilmes.remove(strTitulo);
	}
	
	public void imprimirLista() {
		System.out.println();
		System.out.println();
		Iterator<String> iteratorLista = listaFilmes.iterator();
		while(iteratorLista.hasNext()) {
			System.out.println("Titulo do filme: " + iteratorLista.next());
		}
	}


}
