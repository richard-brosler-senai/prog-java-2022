package br.com.finch.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class AppOrientacao {

	private JFrame frmSistemaDeOrientacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppOrientacao window = new AppOrientacao();
					window.frmSistemaDeOrientacao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppOrientacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeOrientacao = new JFrame();
		frmSistemaDeOrientacao.setTitle("Sistema de Orienta\u00E7\u00E3o");
		frmSistemaDeOrientacao.setBounds(100, 100, 700, 500);
		frmSistemaDeOrientacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeOrientacao.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmOrientacao = new JMenuItem("Orienta\u00E7\u00E3o");
		mnCadastros.add(mntmOrientacao);
		
		JSeparator separator = new JSeparator();
		mnCadastros.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
	}

}
