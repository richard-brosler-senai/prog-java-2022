package br.com.common.classes;

import java.util.List;

public class ClasseBase {
	
	protected List<Object> listaObjetos;
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
	
	public void adicionar() {
		int intId = pesqItem(getId());
		if (intId==-1) {
			//Criar o objeto cliente para adicionar as informações
			ClasseBase item = (ClasseBase) Class.forName(getClass().getName()).getConstructor(String.class).newInstance();
			//Setando os dados para o novo objeto
			item.setId(getId());
			base2Item(item);
			listaObjetos.add(item);
		} else {
			System.out.println("Já existe esse Objeto!");
		}		
	}

	protected void base2Item(ClasseBase item) {
		
	}

	private int pesqItem(int id2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
