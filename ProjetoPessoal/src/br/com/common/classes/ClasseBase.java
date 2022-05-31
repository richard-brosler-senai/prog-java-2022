package br.com.common.classes;

import java.util.List;

public abstract class ClasseBase {
	
	protected List<ClasseBase> listaObjetos;
	private int id;
	
	public ClasseBase() {
		ConexaoFake fake = ConexaoFake.getInstance();
		listaObjetos = fake.getListaObjetos();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void novo() {
		id = 0;
	}
	
	public void adicionar() {
		int intId = pesqItem(getId());
		if (intId==-1) {
			//Criar o objeto cliente para adicionar as informações
			ClasseBase item;
			try {
				item = this.getClass().getDeclaredConstructor().newInstance();
				//Setando os dados para o novo objeto
				item.setId(getId());
				base2Item(item);
				listaObjetos.add(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
		} else {
			System.out.println("Já existe esse Objeto!");
		}		
	}

	public void consultar() {
		int intId=pesqItem(getId());
		if (intId>-1) {
			ClasseBase item = listaObjetos.get(intId);
			item2Base(item);
		} else {
			System.out.println("Item Não cadastrado!");
		}			
	}
	
	public void alterar() {
		int intId=pesqItem(getId());
		if (intId>-1) {
			ClasseBase item = listaObjetos.get(intId);
			base2Item(item);
		} else {
			System.out.println("Item Não cadastrado!");
		}		
	}

	public void excluir() {
		int intId=pesqItem(getId());
		if (intId>-1) {
			listaObjetos.remove(intId);
		} else {
			System.out.println("Item Não cadastrado!");
		}		
	}
	
	public void listar() {
		listaCabecalhoLista();
		for (int intI=0;intI<listaObjetos.size();intI++) {
			ClasseBase it = listaObjetos.get(intI);
			System.out.print(intI + " - ");
			listaItem(it);
		}
	}
	
	public void mostrar() {
		System.out.println("Id....:" + getId());
	}
	
	protected void listaCabecalhoLista() {
		System.out.println("Listagem de Itens");
		System.out.println("---------------------------");
		System.out.println("# - Id");
	}

	protected void listaItem(ClasseBase it) {
		System.out.println(it.getId());
	}
	
	abstract protected void base2Item(ClasseBase item);

	abstract protected void item2Base(ClasseBase item);

	private int pesqItem(int id2) {
		int intRet = -1;
		for (int intI=0;intI<listaObjetos.size();intI++) {
			if (listaObjetos.get(intI).getId()==id2) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}
}
