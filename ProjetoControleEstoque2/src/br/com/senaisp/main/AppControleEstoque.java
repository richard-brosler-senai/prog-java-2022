package br.com.senaisp.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import br.com.senaisp.forms.FormProdutos;

public class AppControleEstoque {

	private JFrame frmControleDeEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppControleEstoque window = new AppControleEstoque();
					window.frmControleDeEstoque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppControleEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EventoClick evt = new EventoClick();
		
		frmControleDeEstoque = new JFrame();
		frmControleDeEstoque.setTitle("Controle de Estoque");
		frmControleDeEstoque.setBounds(100, 100, 700, 400);
		frmControleDeEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControleDeEstoque.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmControleDeEstoque.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnCadastros.add(mntmProdutos);
		mntmProdutos.addActionListener(evt);
		
		JSeparator separator = new JSeparator();
		mnCadastros.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
		mntmSair.addActionListener(evt);
	}
	
	class EventoClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem it = (JMenuItem) e.getSource();
			switch (it.getText()) {
			case "Sair" : frmControleDeEstoque.dispose(); break;
			case "Produtos" : 
				FormProdutos fmpro = new FormProdutos();
				fmpro.setVisible(true);
				break;
			}
		}
		
	}

}
