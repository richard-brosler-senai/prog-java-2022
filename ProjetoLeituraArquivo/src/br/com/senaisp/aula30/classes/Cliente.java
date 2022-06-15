package br.com.senaisp.aula30.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Cliente {
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private Date dtNascimento;
	
	private List<Object[]> lstClientes;
	private DateFormat dtFmt;
	
	public Cliente() {
		lstClientes = new ArrayList<Object[]>();
		nome = "";
		idade = 0;
		cpf = "";
		rg = "";
		dtFmt = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dtNascimento = dtFmt.parse("30/12/1899");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Object[]> getLstClientes() {
		return lstClientes;
	}
	
	public enum TipoArquivo {
		CSV,
		JSON,
		XML
	}
	
	public boolean importarArquivo(String strArquivo, TipoArquivo tpArq) {
		boolean ret = false;
		switch (tpArq) {
		case CSV:
			ret = lerCSV(strArquivo);
			break;
		case JSON:
			ret = lerJSON(strArquivo);
			break;
		case XML:
			ret = lerXML(strArquivo);
			break;
		}
		return ret;
	}

	private boolean lerXML(String strArquivo) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean lerJSON(String strArquivo) {
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader buf = new BufferedReader(isr);
			//Retirando a primeira linha
			StringBuffer strBuff = new StringBuffer();
			String linha;
			//Lendo a partir da 2ª linha
			while ( (linha=buf.readLine()) != null) {
				strBuff.append(linha);
			}
			buf.close();
			JSONArray vetJS = new JSONArray(strBuff.toString());
			for (int i=0;i<vetJS.length();i++) {
				JSONObject itens = vetJS.getJSONObject(i);
				dtNascimento = dtFmt.parse(itens.getString("data_nasc"));
				Object obj[] = { //nome,idade,cpf,rg,data_nasc,sexo,signo,
					itens.getString("nome"), //nome 	
					itens.getInt("idade"), //idade	
					itens.getString("cpf"),//cpf	
					itens.getString("rg"),//rg	
					dtNascimento//data_nasc	
				};
				lstClientes.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	}

	private boolean lerCSV(String strArquivo) {
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader buf = new BufferedReader(isr);
			//Retirando a primeira linha
			String linha = buf.readLine();
			//Lendo a partir da 2ª linha
			while ( (linha=buf.readLine()) != null) {
				List<String> itens = Arrays.asList(linha.split("\\s*,\\s*"));
				dtNascimento = dtFmt.parse(itens.get(4));
				Object obj[] = { //nome,idade,cpf,rg,data_nasc,sexo,signo,
					itens.get(0), //nome 	
					Integer.parseInt(itens.get(1)), //idade	
					itens.get(2),//cpf	
					itens.get(3),//rg	
					dtNascimento//data_nasc	
				};
				lstClientes.add(obj);
			}
			buf.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
