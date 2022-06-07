package br.com.senaisp.aula26.classes;

import java.util.List;

public class Produto {
	private int codigo;
	private String descricao;
	private double preco;
	private List<Produto> listaProduto;

	public Produto() {
		ConexaoFake fake = ConexaoFake.getInstance();
		listaProduto = fake.getListaProduto();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Produto> getListaProdutos() {
		return listaProduto;
	}
	
	public void novo() {
		codigo=0;
		descricao="";
		preco=0;
	}
	
	public void adicionar() {
		int intId = pesqProduto(this.codigo);
		if (intId==-1) {
			//Criar o objeto Produto para adicionar as informações
			Produto pro = new Produto();
			//Setando os dados para o novo objeto
			pro.setCodigo(codigo);
			pro.setDescricao(descricao);
			pro.setPreco(preco);
			//Colocando o objeto na lista
			listaProduto.add(pro);
		} else {
			System.out.println("Já existe esse Produto!");
		}
	}
	
	public boolean hasCodigo(int value) {
		return pesqProduto(value) != -1;
	}

	private int pesqProduto(int codigo2) {
		int intRet = -1;
		for (int intI=0;intI<listaProduto.size();intI++) {
			if (listaProduto.get(intI).getCodigo()==codigo2) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}
	
	public int getListaSize() {
		return listaProduto.size();
	}

	public void alterar() {
		int intId=pesqProduto(codigo);
		if (intId>-1) {
			Produto prod = listaProduto.get(intId);
			prod.setDescricao(descricao);
			prod.setPreco(preco);
		} else {
			System.out.println("Produto Não cadastrado!");
		}
	}

	public void excluir() {
		int intId=pesqProduto(codigo);
		if (intId>-1) {
			listaProduto.remove(intId);
		} else {
			System.out.println("Produto Não cadastrado!");
		}
	}
	
	public void consultar() {
		int intId=pesqProduto(codigo);
		if (intId>-1) {
			Produto prod = listaProduto.get(intId);
			descricao = prod.getDescricao();
			preco = prod.getPreco();
		} else {
			System.out.println("Produto Não cadastrado!");
		}		
	}
	public void mostrarProduto() {
		System.out.println("Codigo...: " + codigo);
		System.out.println("Descricao: " + descricao);
		System.out.println("Preço....: " + preco);
	}}
