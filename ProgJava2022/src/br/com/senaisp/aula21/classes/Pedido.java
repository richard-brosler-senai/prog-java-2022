package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String documento;
	private List<Produto> listaItens;
	
	public Pedido(String documento) throws Exception {
		setDocumento(documento);
		listaItens = new ArrayList<Produto>();
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) throws Exception {
		if (documento.length()<3)
			throw new Exception("Documento deve ter pelo menos 3 caracteres");
		this.documento = documento;
	}
	
	public void adicionarProduto(Produto prod) {
		listaItens.add(prod);
	}
	
	public void removerProduto(Produto prod) {
		listaItens.remove(prod);
	}
	
	public void removerProduto(int indiceProd) {
		listaItens.remove(indiceProd);
	}

	
	public double totalPedido() {
		double dblTot=0;
		for (int intI=0;intI<listaItens.size();intI++) {
			dblTot += listaItens.get(intI).precoTotal();
		}
		return dblTot;
	}
	
	public void listarItens() {
		System.out.println("Listagem de Itens");
		System.out.println("# - Descrição       -  Qtde - Preço - Preço Total");
		System.out.println("-------------------------------------------------");
		for (int intI=0;intI<listaItens.size();intI++) {
			Produto prod = listaItens.get(intI);
			System.out.print(intI);
			System.out.print(" - "+ String.format("%15s", prod.getNome()));
			System.out.print(" - " + 
					String.format("%5d",prod.getQtde()));
			System.out.print(" - " + 
					String.format("%5.2f",prod.getPreco()));
			System.out.println(" - " + 
					String.format("%11.2f",prod.precoTotal()));
		}
	}
	
}
