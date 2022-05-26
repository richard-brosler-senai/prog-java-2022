package br.com.daniel.classes;

import br.com.common.classes.ClasseBase;

public class Paciente extends ClasseBase {
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private int idade;
	
	public void adicionar() {
		
	}
	
	public int pesqId(int id) {
		int intRet = -1;
		for (int intI=0;intI<listaObjetos.size();intI++) {
			Paciente pac =(Paciente) listaObjetos.get(intI);
			if (pac.getId()==id) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
	
	public void consultar() {
		
	}
	
	public void alterar() {
		
	}
	
	public void excluir() {
		
	}
	
	public void listarPacientes() {
		
	}
	
	public void mostrarPaciente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
