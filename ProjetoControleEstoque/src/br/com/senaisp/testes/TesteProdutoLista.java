package br.com.senaisp.testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.senaisp.classes.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TesteProdutoLista extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteProdutoLista frame = new TesteProdutoLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteProdutoLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		Produto prod = new Produto();
		DefaultTableModel tblCli = prod.getListaProdutos();
		
		if (tblCli!=null) {
			table = new JTable(tblCli);
			scrollPane.setViewportView(table);			
		} else {
			JOptionPane.showMessageDialog(null, 
					"Ocorreu um erro:" + prod.getMsgErro());
		}		
	}

}
