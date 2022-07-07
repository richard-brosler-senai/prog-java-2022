package br.com.finch.testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.finch.classes.Orientacao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TesteOrientacaoForm extends JFrame {

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
					TesteOrientacaoForm frame = new TesteOrientacaoForm();
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
	public TesteOrientacaoForm() {
		setTitle("Pesquisa por palavra chave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPesquisa = new JLabel("Digite a palavra chave a ser pesquisada:");
		panel.add(lblPesquisa);
		
		txtPesquisa = new JTextField();
		panel.add(txtPesquisa);
		txtPesquisa.setColumns(20);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		panel.add(btnPesquisar);
		
		JButton btnTodos = new JButton("Todos Registros");
		panel.add(btnTodos);
		btnTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Orientacao or = new Orientacao();
				tblOrientacao.setModel(or.getListaOrientacao());
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Orientacao or = new Orientacao();
				tblOrientacao.setModel(or.readByKeyWords(txtPesquisa.getText()));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblOrientacao = new JTable();
		scrollPane.setViewportView(tblOrientacao);
	}

}
