package br.com.finch.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.finch.classes.Orientacao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormOrientacao extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisa;
	private JTable tblOrientacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormOrientacao frame = new FormOrientacao();
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
	public FormOrientacao() {
		EventoClick evt = new EventoClick();
		setTitle("Manuten\u00E7\u00E3o de Orienta\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(evt);
		pnlBotoes.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(evt);
		pnlBotoes.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(evt);
		pnlBotoes.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(evt);
		pnlBotoes.add(btnExcluir);
		
		JPanel pnlPesquisa = new JPanel();
		contentPane.add(pnlPesquisa, BorderLayout.NORTH);
		
		JLabel lblPesquisa = new JLabel("Palavra Chave a pesquisar:");
		pnlPesquisa.add(lblPesquisa);
		
		txtPesquisa = new JTextField();
		pnlPesquisa.add(txtPesquisa);
		txtPesquisa.setColumns(15);
		
		JButton btnPesquisa = new JButton("Pesquisar Palavra");
		btnPesquisa.addActionListener(evt);
		pnlPesquisa.add(btnPesquisa);
		
		JButton btnTodos = new JButton("Carregar Tudo");
		btnTodos.addActionListener(evt);
		pnlPesquisa.add(btnTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblOrientacao = new JTable();
		scrollPane.setViewportView(tblOrientacao);
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			Orientacao or = new Orientacao();
			FormOrientacaoManutencao frmMan = null;
			
			switch (btn.getText()) {
			case "Adicionar": 
			case "Consultar": 
			case "Alterar":
			case "Excluir": 
				frmMan = new FormOrientacaoManutencao();
				frmMan.setOr(or);
				break;
			}
			
			switch (btn.getText()) {
			case "Adicionar": frmMan.setTipoOperacao(1); break;
			case "Consultar": frmMan.setTipoOperacao(2); break;
			case "Alterar": frmMan.setTipoOperacao(3); break;
			case "Excluir": frmMan.setTipoOperacao(4); break;
			case "Pesquisar Palavra":
				tblOrientacao.setModel(or.readByKeyWords(txtPesquisa.getText()));
				break;
			case "Carregar Tudo":
				tblOrientacao.setModel(or.getListaOrientacao());
				break;
			}
			
			if (frmMan != null) {
				frmMan.setVisible(true);
				frmMan.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						tblOrientacao.setModel(or.getListaOrientacao());
						super.windowClosed(e);
					}
				});
			}
		}
		
	}
}
