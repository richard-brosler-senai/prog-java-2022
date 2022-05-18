package br.com.senaisp.aula18.classes;

import br.com.senaisp.aula17.classes.Imposto;

public class ImpostoIrrf extends Imposto {
	//Criando uma constante para o valor de dedução por dependente
	public static final double DEDUCAO_DEP = 189.59;
	
	private int nrDependentes;
	@Override
	public double calcularImposto() {
		double dblRet=0, dblBC= getBaseCalculo();
		
		//Metodo mais longo
		if (dblBC>=0 && dblBC<=1903.98) {
			dblRet = ( dblBC - nrDependentes * DEDUCAO_DEP ) * 0.00;
		} else if (dblBC>=1903.99 && dblBC<=2826.65) {
			dblRet = ( dblBC - nrDependentes * DEDUCAO_DEP ) * 7.50 / 100.00 - 142.80;
		} else if (dblBC>=2826.66 && dblBC<= 3751.05) {
			dblRet = ( dblBC - nrDependentes * DEDUCAO_DEP ) * 15.00 / 100.00 - 354.80;
		} else if (dblBC>=3751.06 && dblBC<= 4664.68) {
			dblRet = ( dblBC - nrDependentes * DEDUCAO_DEP ) * 22.50 / 100.00 - 636.13;
		} else {
			dblRet = ( dblBC - nrDependentes * DEDUCAO_DEP ) * 27.50 / 100.00 - 869.36;
		}
		
		return dblRet;
	}
	public int getNrDependentes() {
		return nrDependentes;
	}
	public void setNrDependentes(int nrDependentes) throws Exception {
		if (nrDependentes<0) {
			throw new Exception("Número não pode ser negativo!");
		}
		this.nrDependentes = nrDependentes;
	}
}
