package br.com.senaisp.aula30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExemploArrayList {
	private List<String> listaFilmes;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExemploArrayList ex = new ExemploArrayList();
		ex.listaFilmes = new ArrayList<String>();
		
		System.out.println("Exemplo de uso de interface List");
		System.out.println();
		
		ex.insereInicio("Blade Runner - O caçador de androides");
		ex.insereInicio("O exterminador do futuro 2");

		ex.insereFim("Apocalipse Now");
		ex.insereFim("Star Wars IV - Uma nova esperança");

		ex.insereInicio("Curtindo a vida adoidado");
		ex.insereFim("Drácula - De Bram Stocker");
		ex.insereInicio("2001 - Uma odisséia no espaço");
		
		ex.imprimirLista();
		
		ex.removeInicio();
		ex.removeFim();
		
		ex.imprimirLista();
	}
	
	public void insereInicio(String strTitulo) {
		listaFilmes.add(0,strTitulo);
	}
	
	public void insereFim(String strTitulo) {
		listaFilmes.add(strTitulo);
	}
	
	public void removeInicio() {
		listaFilmes.remove(0);
	}
	
	public void removeFim() {
		int intUlt = listaFilmes.size() - 1;
		listaFilmes.remove(intUlt);
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
