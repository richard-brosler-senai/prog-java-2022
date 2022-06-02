package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Produto produto;

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
		
		produto = new Produto();
		
		setTitle("Formul\u00E1rio Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormProduto frmPrd = new FormProduto();
				produto.novo();
				frmPrd.setProduto(produto);
				frmPrd.setOperacao(1);
				frmPrd.setVisible(true);
			}
		});
		mnProdutos.add(mntmCadastrar);
			
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnProdutos.add(mntmConsultar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnProdutos.add(mntmAlterar);
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormProduto frmPrd = new FormProduto();
				produto.novo();
				frmPrd.setProduto(produto);
				frmPrd.setOperacao(2);
				frmPrd.setVisible(true);
			}
		});
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnProdutos.add(mntmExcluir);
		
		JSeparator separator = new JSeparator();
		mnProdutos.add(separator);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormListarProduto lstPrd = new FormListarProduto();
				lstPrd.setProduto(produto);
				lstPrd.setVisible(true);
			}
		});
		mnProdutos.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
