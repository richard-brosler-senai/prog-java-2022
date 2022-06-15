package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//cli.importarArquivo("C:\\Users\\richa\\Downloads\\convertcsv.csv", TipoArquivo.CSV);
		cli.importarArquivo("C:\\Users\\richa\\Downloads\\data.json", TipoArquivo.JSON);
		for (Object obj[] : cli.getLstClientes()) {
			System.out.println(obj[0]);
		}
	}

}
