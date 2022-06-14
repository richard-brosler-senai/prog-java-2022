package br.com.senaisp.aula29.classes;

public class Cliente {
	private int codigo;
	private String nome;
	private String cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void mostrarCliente() {
		System.out.println(codigo + " - " + nome);
	}
	public static void testarCliente() {
		System.out.println("Olá Clientes");
	}
}
