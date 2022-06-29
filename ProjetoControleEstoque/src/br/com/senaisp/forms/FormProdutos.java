package br.com.senaisp.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.senaisp.classes.Produto;

public class FormProdutos extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private Produto prod;
	private DefaultTableModel tblMdProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutos frame = new FormProdutos();
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
	public FormProdutos() {
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		JButton btnAdicionar = new JButton("Adicionar");
		pnlBotoes.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		pnlBotoes.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		pnlBotoes.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		pnlBotoes.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		prod = new Produto();
		
		tblMdProdutos = prod.getListaProdutos();
		
		tblProdutos = new JTable(tblMdProdutos);
		
		scrollPane.setViewportView(tblProdutos);
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton ob = (JButton) e.getSource();
			switch (ob.getText()) {
			case "Adicionar" :
			case "Consultar" :
			case "Alterar" :
			case "Excluir" :
			}
		}
		
	}
}
