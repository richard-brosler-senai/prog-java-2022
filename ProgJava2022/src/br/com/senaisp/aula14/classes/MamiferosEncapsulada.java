package br.com.senaisp.aula14.classes;

import java.security.InvalidParameterException;

public class MamiferosEncapsulada {
	private String Pele;
	private String Olhos;
	private String Boca;
	private double Peso;
	public String getPele() {
		return Pele;
	}
	public void setPele(String pele) throws Exception {
		if (!pele.equalsIgnoreCase("branca") &&
			!pele.equalsIgnoreCase("parda") &&
			!pele.equalsIgnoreCase("amarela") &&
			!pele.equalsIgnoreCase("negra"))
			throw new Exception("Cor de pele inválida!");
		Pele = pele;
	}
	public String getOlhos() {
		return Olhos;
	}
	/**
	 * Setter dos Olhos. 
	 * Valores válidos: castanho, preto, azul ou verde
	 * @param olhos Informar a cor dos olhos
	 * @throws Exception Se olhos com cor inválida, ocorrerá erro
	 */
	public void setOlhos(String olhos) throws Exception {
		if (!olhos.equalsIgnoreCase("castanho") &&
			!olhos.equalsIgnoreCase("preto") &&
			!olhos.equalsIgnoreCase("azul") &&
			!olhos.equalsIgnoreCase("verde") )
			//System.out.println("Valor Inválido para os olhos");
			throw new Exception("Valor Inválido para os olhos");
		else
			Olhos = olhos;
	}
	public String getBoca() {
		return Boca;
	}
	public void setBoca(String boca) {
		Boca = boca;
	}
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}

}
