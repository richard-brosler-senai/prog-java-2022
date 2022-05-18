package br.com.senaisp.aula18;

import br.com.senaisp.aula17.classes.Imposto;
import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.ImpostoIrrf;

public class TesteImposto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpostoInss imp = new ImpostoInss();
		ImpostoIrrf impir = new ImpostoIrrf();
		//Usando um constructor com valores iniciais nele
		Imposto impap=null;
		try {
			impap = new Imposto(4000,15);
			System.out.println(impap.calcularImposto());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Ocorreu um erro na criação da classe");
		}

		double dblSalario = 10125.00;
		
		try {
			imp.setBaseCalculo(dblSalario);
			System.out.println("Inss: " + imp.calcularImposto());
		
			impir.setBaseCalculo(dblSalario - imp.calcularImposto());
			System.out.println("Irrf: " + impir.calcularImposto());
			
			System.out.println("Salario Líquido do coitado:" +
			( dblSalario - imp.calcularImposto() - impir.calcularImposto() )
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
