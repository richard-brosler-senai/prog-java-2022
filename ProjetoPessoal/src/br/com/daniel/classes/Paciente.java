package br.com.daniel.classes;

import br.com.common.classes.ClasseBase;

public class Paciente extends ClasseBase {

	private String nome;
	private String endereco;
	private String email;
	private int idade;
	
	@Override
	public void novo() {
		super.novo();
		nome = "";
		endereco = "";
		email = "";
		idade = 0;
	}
	@Override
	public void mostrar() {
		super.mostrar();
		System.out.println("Nome.....: "+getNome());
		System.out.println("Endereco.: "+getEndereco());
		System.out.println("E-mail...: "+getEmail());
		System.out.println("Idade....: "+getIdade());
	}
	
	@Override
	protected void listaCabecalhoLista() {
		System.out.println("Listagem de Itens");
		System.out.println("---------------------------");
		System.out.println("# - Id - Idade - Nome");
	}
	
	@Override
	protected void listaItem(ClasseBase it) {
		Paciente pac = (Paciente) it;
		System.out.print(pac.getId() + " - ");
		System.out.print(pac.getIdade() + " - ");
		System.out.println(pac.getNome() + " - " + pac.toString());
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

	@Override
	protected void base2Item(ClasseBase item) {
		Paciente pac = (Paciente) item; 
		pac.setEmail(email);
		pac.setEndereco(endereco);
		pac.setIdade(idade);
		pac.setNome(nome);
	}

	@Override
	protected void item2Base(ClasseBase item) {
		Paciente pac = (Paciente) item; 
		email = pac.getEmail();
		endereco = pac.getEndereco();
		idade = pac.getIdade();
		nome = pac.getNome();
	}
}
