package br.com.finch.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import br.com.finch.forms.FormOrientacao;

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
		EventoClick evt = new EventoClick();
		frmSistemaDeOrientacao = new JFrame();
		frmSistemaDeOrientacao.setTitle("Sistema de Orienta\u00E7\u00E3o");
		frmSistemaDeOrientacao.setBounds(100, 100, 700, 500);
		frmSistemaDeOrientacao.setLocationRelativeTo(null);
		frmSistemaDeOrientacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeOrientacao.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmOrientacao = new JMenuItem("Orientação");
		mnCadastros.add(mntmOrientacao);
		mntmOrientacao.addActionListener(evt);
		
		JSeparator separator = new JSeparator();
		mnCadastros.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
		mntmSair.addActionListener(evt);
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem it = (JMenuItem) e.getSource();
			switch(it.getText()) {
			case "Orientação":
				FormOrientacao fo = new FormOrientacao();
				fo.setVisible(true);
				break;
			case "Sair":
				frmSistemaDeOrientacao.dispose();
				break;
			}
			
		}
		
	}
}
