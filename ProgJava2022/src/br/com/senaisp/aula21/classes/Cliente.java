package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Cliente> listaClientes;
	private int codigo;
	private String nome;
	private String endereco;
	
	public Cliente() {
		super();
		listaClientes = new ArrayList<Cliente>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void adicionar() {
		int intId = pesqCliente(this.codigo);
		if (intId==-1) {
			listaClientes.add(this);
		} else {
			System.out.println("Já existe esse cliente!");
		}
	}

	private int pesqCliente(int codigo2) {
		int intRet = -1;
		for (int intI=0;intI<listaClientes.size();intI++) {
			if (listaClientes.get(intI).getCodigo()==codigo2) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}
}
