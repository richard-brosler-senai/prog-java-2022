package br.com.senaisp.aula30.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

	public boolean exportarArquivo(String strArquivo, TipoArquivo tpArq) {
		boolean ret = false;
		switch (tpArq) {
		case CSV: ret = escreverCSV(strArquivo); break;
		case JSON: ret = escreverJSON(strArquivo); break;
		case XML: ret = escreverXML(strArquivo); break;
		}
		return ret;
	}
	
	private boolean escreverCSV(String strArquivo) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(strArquivo);
			OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
			BufferedWriter buf = new BufferedWriter(osw);
			//Gravando o cabeçalho do arquivo csv
			buf.write("nome,idade,cpf,rg,data_nasc\r\n");
			//Usando o foreach para pegar os itens da lista
			for (Object it[] : lstClientes) {
				buf.write(it[0]+","); //nome
				buf.write(it[1]+","); //idade
				buf.write(it[2]+","); //cpf
				buf.write(it[3]+","); //rg
				buf.write(dtFmt.format(it[4])); //data_nasc
				buf.write("\r\n");//quebra de linha
			}
			buf.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private boolean escreverJSON(String strArquivo) {
		boolean ret = false;
		try {
			FileOutputStream fos = new FileOutputStream(strArquivo);
			OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
			BufferedWriter buf = new BufferedWriter(osw);
			//Criando o objeto JSON Array
			JSONArray itens = new JSONArray();
			for (Object objs[] : lstClientes) {
				//Criando o objeto JSON para colocar os campos nele
				JSONObject item = new JSONObject();
				item.put("nome", objs[0]);
				item.put("idade", objs[1]);
				item.put("cpf", objs[2]);
				item.put("rg", objs[3]);
				item.put("data_nasc", dtFmt.format(objs[4]));
				//Adicionando item ao vetor
				itens.put(item);
			}
			//Gravando o JSON String
			buf.write(itens.toString());
			buf.close();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private boolean escreverXML(String strArquivo) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean lerXML(String strArquivo) {
		boolean ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			DocumentBuilderFactory fact =  DocumentBuilderFactory.newInstance();
			DocumentBuilder build = fact.newDocumentBuilder();
			//Transformando o arquivo em objeto xml (DOM)
			Document doc = build.parse(fis);
			//obtendo o elemento raiz
			Element noRoot = doc.getDocumentElement();
			//Obtendo os elementos row
			NodeList listaNos = noRoot.getElementsByTagName("row");
			//Percorrendo os elementos
			for (int intI=0; intI<listaNos.getLength(); intI++) {
				Node item = listaNos.item(intI);
				//Verificando se o item é um elemento (nó de item)
				if (item instanceof Element) {
					Element itt = (Element) item;
					nome = itt.getElementsByTagName("nome").item(0).getTextContent();
					idade = Integer.parseInt(itt.getElementsByTagName("idade").
								item(0).getTextContent());
					cpf = itt.getElementsByTagName("cpf").item(0).getTextContent();
					rg = itt.getElementsByTagName("rg").item(0).getTextContent();
					dtNascimento = dtFmt.parse(itt.getElementsByTagName("data_nasc").
										item(0).getTextContent());
					Object obj[] = {
						nome,
						idade,
						cpf,
						rg,
						dtNascimento
					};
					lstClientes.add(obj);
				}
			}
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	private boolean lerJSON(String strArquivo) {
		boolean ret = false;
		lstClientes.clear();
		try {
			FileInputStream fis = new FileInputStream(strArquivo);
			InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
			BufferedReader buf = new BufferedReader(isr);
			StringBuilder stb = new StringBuilder();
			String linha;
			//Lendo a partir da 2ª linha
			while ( (linha=buf.readLine()) != null) {
				stb.append(linha);
			}
			buf.close();
			//Criando objeto vetor JSON a partir do texto JSON
			JSONArray itens = new JSONArray(stb.toString());
			for (int intI=0;intI<itens.length();intI++) {
				JSONObject it = itens.getJSONObject(intI);
				Object obj[] = {
					it.getString("nome"),
					it.getInt("idade"),
					it.getString("cpf"),
					it.getString("rg"),
					dtFmt.parse(it.getString("data_nasc"))
				};
				lstClientes.add(obj);
			}
			ret = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;	
	}

	private boolean lerCSV(String strArquivo) {
		boolean ret = false;
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
			ret = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
