package br.com.senaisp.aula17.classes;
/**
 * Classe Base para calculo de impostos
 * @author Richard
 * @since 2022-05-16
 * @version 1.0.0.1
 * 
 */
public class Imposto {
	private double BaseCalculo;
	private double Aliquota;
	//Constructor
	public Imposto() {
		this.BaseCalculo = 0;
		this.Aliquota = 0;
	}
	//Overload de metodos
	public Imposto(double baseCalculo, double aliquota) throws Exception {
		this.setBaseCalculo(baseCalculo);
		this.setAliquota(aliquota);
	}
	/**
	 * Metodo que retorna o valor do imposto calculado com base
	 * nos campos BaseCalculo e Aliquota
	 * @return Retorna o valor do imposto calculado
	 */
	public double calcularImposto() {
		return BaseCalculo * Aliquota / 100.00;
	}
	//Getters e Setters
	public double getBaseCalculo() {
		return BaseCalculo;
	}
	/**
	 * Setter da Base de Calculo
	 * @param baseCalculo Deverá ser informada a base de calculo para 
	 * o imposto, esta deverá ser maior que zero.
	 * 
	 * @throws Exception Ocorrerá uma exception para valores inválidos
	 */
	public void setBaseCalculo(double baseCalculo) throws Exception {
		if (baseCalculo<0) {
			throw new Exception("Base de Calculo deve ser positiva!");
		}
		BaseCalculo = baseCalculo;
	}
	public double getAliquota() {
		return Aliquota;
	}
	/**
	 * Setter de Alíquota do Imposto
	 * @param aliquota Informar a alíquota do imposto. Este deve ser maior que
	 * zero e menor que 100.
	 * @throws Exception Caso a alíquota esteja errada, ocorrerá uma Exception
	 */
	public void setAliquota(double aliquota) throws Exception {
		if (aliquota<=0 || aliquota>99) {
			throw new Exception("Alíquota deve ser maior que zero e menor que 100!");
		}
		Aliquota = aliquota;
	}
}
