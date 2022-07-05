package br.com.senaisp.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Produto {
	private ConexaoBD conn;
	
	private int id;
	private String descricao;
	private int saldo;
	private double preco;
	private String localEstoque;

	private boolean haErro;

	private String msgErro;
	
	public Produto() {
		conn = ConexaoBD.getInstance();
	}
	
	public void novo() {
		id = 0;
		descricao = null;
		saldo = 0;
		preco = 0;
		localEstoque = null;
	}
	
	public boolean create() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "insert into produtos(descricao,saldo,preco,local_estoque) values (?,?,?,?)";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql, 
							PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, localEstoque);
			
			int rowsAff = stmt.executeUpdate();
			//log
			System.out.println("Linhas inseridas: " + rowsAff);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			id = rs.getInt(1);
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		return ret;
	}
	
	public boolean read() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "select descricao, saldo, preco, "
					+ "local_estoque from produtos where id = ?";
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				descricao = rs.getString(1);
				saldo = rs.getInt(2);
				preco = rs.getDouble(3);
				localEstoque = rs.getString(4);
				
				conn.desconectarBD();
				
				ret = true;
			} else {
				haErro = false;
				msgErro = "Registro não Encontrado!";
			}
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		
		return ret;
	}
	
	public boolean update() {
		boolean ret=false;
		
		try {
			conn.conectarBD();
			String sql = "update produtos set descricao=?, saldo=?, "
			 			+ "preco=?, local_estoque=? where id=?";
			
			PreparedStatement stmt = conn.getConector()
					.prepareStatement(sql);
			
			stmt.setString(1, descricao);
			stmt.setInt(2, saldo);
			stmt.setDouble(3, preco);
			stmt.setString(4, localEstoque);
			
			stmt.setInt(5, id);
			
			int rowsAff = stmt.executeUpdate();
			//log
			System.out.println("Registros alterados: "+ rowsAff);
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		
		return ret;
	}
	
	public boolean delete() {
		boolean ret = false;
		try {
			conn.conectarBD();
			String sql = "delete from produtos where id=?";
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			stmt.setInt(1, id);
			
			int rowsAff = stmt.executeUpdate();
			//log
			System.out.println("Linhas excluídas: " + rowsAff);
			conn.desconectarBD();
			ret = true;
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}		
		return ret;
	}
	
	public DefaultTableModel getListaProdutos() {
		DefaultTableModel ret = null;
		
		try {
			conn.conectarBD();
			String sql = "select id, descricao, saldo, preco, local_estoque "
						+ "from produtos order by id limit 100";
			PreparedStatement stmt = conn.getConector().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsm = stmt.getMetaData();
			
			String titulos[] = new String[rsm.getColumnCount()];
			for (int intI=1;intI <= rsm.getColumnCount();intI++) {
				titulos[intI-1] = rsm.getColumnName(intI);
			}
			ret = new DefaultTableModel(titulos,0);
			
			while (rs.next()) {
				Object obj[] = new Object[rsm.getColumnCount()];
				for (int intI=1;intI <= rsm.getColumnCount();intI++) {
					obj[intI-1] = rs.getObject(intI);
				}
				ret.addRow(obj);
			}
		} catch (SQLException e) {
			haErro = true;
			msgErro = e.getMessage();
		}
		
		
		return ret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getLocalEstoque() {
		return localEstoque;
	}
	public void setLocalEstoque(String localEstoque) {
		this.localEstoque = localEstoque;
	}
	public ConexaoBD getConn() {
		return conn;
	}

	public String getMsgErro() {
		return msgErro;
	}
	
	public boolean getHaErro() {
		return haErro;
	}

}
