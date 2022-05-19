package br.com.senaisp.aula19.classes;

public class FolhaPagamento {
	private int chapaFuncionario;
	private double salarioBruto;
	private double valorInss;
	private double valorIrrf;
	
	public double valorSalarioLiquido() {
		return salarioBruto - valorInss - valorIrrf;
	}

	public int getChapaFuncionario() {
		return chapaFuncionario;
	}

	public void setChapaFuncionario(int chapaFuncionario) throws Exception {
		if (chapaFuncionario <= 0) {
			throw new Exception("Chapa deve ser maior que zero!");
		}
		this.chapaFuncionario = chapaFuncionario;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) throws Exception {
		if (salarioBruto<=0) {
			throw new Exception("Salário Bruto deve ser maior que zero!");
		}
		this.salarioBruto = salarioBruto;
	}

	public double getValorInss() {
		return valorInss;
	}

	public void setValorInss(double valorInss) throws Exception {
		if (valorInss<0) {
			throw new Exception("Valor do Inss não pode ser negativo!");
		}
		this.valorInss = valorInss;
	}

	public double getValorIrrf() {
		return valorIrrf;
	}

	public void setValorIrrf(double valorIrrf) throws Exception {
		if (valorIrrf<0) {
			throw new Exception("Valor do Irrf não pode ser negativo!");
		}
		this.valorIrrf = valorIrrf;
	}
}
