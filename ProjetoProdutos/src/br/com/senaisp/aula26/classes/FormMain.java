package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class FormMain extends JFrame {

	private JPanel contentPane;
	private Produto prod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
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
	public FormMain() {
		//Criando o objeto de eventos de Click
		EventoClick evtClick = new EventoClick();
		
		prod = new Produto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Formulário Principal");
		setBounds(100, 100, 700, 552);
		//Centralizando a Janela
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setMnemonic('P');
		menuBar.add(mnProdutos);
		
		JMenuItem mntmAdicionar = new JMenuItem("Adicionar");
		mnProdutos.add(mntmAdicionar);
		mntmAdicionar.addActionListener(evtClick);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnProdutos.add(mntmConsultar);
		mntmConsultar.addActionListener(evtClick);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnProdutos.add(mntmAlterar);
		mntmAlterar.addActionListener(evtClick);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnProdutos.add(mntmExcluir);
		mntmExcluir.addActionListener(evtClick);
		
		JSeparator separator = new JSeparator();
		mnProdutos.add(separator);
		
		JMenu mnListar = new JMenu("Listar");
		mnListar.setMnemonic('L');
		mnProdutos.add(mnListar);
		
		JMenuItem mntmProdAsc = new JMenuItem("Produtos Ascendentes");
		mnListar.add(mntmProdAsc);
		mntmProdAsc.addActionListener(evtClick);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			
			FormManutencao fmt;
			
			switch ( ( (JMenuItem)cmp ).getText() ) 
			{
			case "Adicionar" :
				fmt = new FormManutencao();
				prod.novo();
				fmt.setProd(prod);
				fmt.setTipoEdicao(1);
				
				fmt.setVisible(true);
				break;
			case "Consultar" :
				fmt = new FormManutencao();
				prod.novo();
				fmt.setProd(prod);
				fmt.setTipoEdicao(2);
				
				fmt.setVisible(true);
				break;
			case "Alterar" :
				fmt = new FormManutencao();
				prod.novo();
				fmt.setProd(prod);
				fmt.setTipoEdicao(3);
				
				fmt.setVisible(true);
				break;
			case "Excluir" :
				fmt = new FormManutencao();
				prod.novo();
				fmt.setProd(prod);
				fmt.setTipoEdicao(4);
				
				fmt.setVisible(true);
				break;
			case "Produtos Ascendentes":
				FormListarProduto fml = new FormListarProduto();
				fml.setProd(prod);
				fml.setVisible(true);
				break;
			}
		}
		
	}
}
