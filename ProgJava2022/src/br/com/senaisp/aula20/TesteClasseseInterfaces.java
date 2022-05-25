package br.com.senaisp.aula20;

import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.aula20.classes.Cachorro;
import br.com.senaisp.aula20.classes.Carro;
import br.com.senaisp.aula20.classes.Gato;
import br.com.senaisp.aula20.classes.Humano;
import br.com.senaisp.aula20.classes.Mamiferos;
import br.com.senaisp.aula20.classes.Moto;
import br.com.senaisp.aula20.classes.SuperMaquina;
import br.com.senaisp.aula20.classes.Veiculo;
import br.com.senaisp.aula20.interfaces.InFalantes;

public class TesteClasseseInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Mamiferos> listaMamiferos = new ArrayList<Mamiferos>();
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		List<InFalantes> listaFalantes = new ArrayList<InFalantes>();
		
		listaMamiferos.add(new Gato("Branco",10));
		listaMamiferos.add(new Cachorro("Marrom",5));
		listaMamiferos.add(new Humano("Branca", 35));
		
		listaVeiculos.add(new SuperMaquina("Chevrolet", "Onix", 2022, "16V"));
		listaVeiculos.add(new Carro("Toyota", "Ethios", 2022, "16V"));
		listaVeiculos.add(new Moto("Honda", "Titan", 2022, "8V"));
		
		listaFalantes.add(new Gato("Malhado", 5));
		listaFalantes.add(new Cachorro("Cinza", 10));
		listaFalantes.add(new Humano("Amarelo", 50));
		listaFalantes.add(new SuperMaquina("Honda", "Civic", 2022, "16V"));
		
		for (int intI=0;intI<listaMamiferos.size();intI++) {
			Mamiferos man = listaMamiferos.get(intI);
			System.out.println(man.getClass().getName());
		}
		System.out.println("-----------------------");
		for (int intI=0;intI<listaVeiculos.size();intI++) {
			Veiculo vei = listaVeiculos.get(intI);
			System.out.println(vei.getClass().getName());
			vei.ligarVeiculo();
		}
		System.out.println("-----------------------");
		for (int intI=0;intI<listaFalantes.size();intI++) {
			InFalantes fal = listaFalantes.get(intI);
			System.out.println(fal.getClass().getName());
			fal.falar();
		}
		
	}

}
