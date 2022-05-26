package br.com.daniel.classes;

import br.com.common.classes.ClasseBase;

public class Paciente extends ClasseBase {

	private String nome;
	private String endereco;
	private String email;
	private int idade;
	

		
	public void listarPacientes() {
		
	}
	
	public void mostrarPaciente() {
		
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
