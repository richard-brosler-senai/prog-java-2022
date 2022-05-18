package br.com.senaisp.aula18.classes;

public class Funcionario {
	private int chapa;
	private String nome;
	private String endereco;
	private double salario;
	private int nrDependentes;
	
	public int getChapa() {
		return chapa;
	}
	public void setChapa(int chapa) throws Exception {
		if (chapa<=0) {
			throw new Exception("Chapa Deve ser maior que zero!");
		}
		this.chapa = chapa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if (nome.length()<5) {
			throw new Exception("Nome deve ter mais de 5 letras!");
		}
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) throws Exception {
		if (endereco.length()<5) {
			throw new Exception("Endereço deve ter mais de 5 letras!");
		}
		this.endereco = endereco;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) throws Exception {
		if (salario<0) {
			throw new Exception("Salário deve ser positivo");
		}
		this.salario = salario;
	}
	public int getNrDependentes() {
		return nrDependentes;
	}
	public void setNrDependentes(int nrDependentes) throws Exception {
		if (nrDependentes<0) {
			throw new Exception("Número de dependentes deve ser positivo");
		}
		this.nrDependentes = nrDependentes;
	}

}
