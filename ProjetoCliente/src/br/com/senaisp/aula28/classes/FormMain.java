package br.com.senaisp.aula28.classes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FormMain {

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain window = new FormMain();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		EventoClick evt = new EventoClick();
		
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 682, 425);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setMnemonic('C');
		menuBar.add(mnCadastros);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnCadastros.add(mntmCliente);
		mntmCliente.addActionListener(evt);
		
		JSeparator separator = new JSeparator();
		mnCadastros.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
		mntmSair.addActionListener(evt);
	}
  class EventoClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object cmp = e.getSource();
		switch ( ((JMenuItem) cmp).getText() ) {
		case "Cliente" :
			FormCliente fmtCli = new FormCliente();
			fmtCli.setVisible(true);
			break;
		case "Sair" :
			frmMenuPrincipal.dispose();
			break;
		}
	}
	  
  }
}
