package br.com.senaisp.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senaisp.classes.Produto;

public class FormProdutosManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textDescricao;
	private JTextField textLocalEstoque;
	private int tipoOperacao; //1-criar,2-consultar,3-alterar,4-excluir
	private Produto prod;
	private JFormattedTextField fmtSaldo;
	private JFormattedTextField fmtPreco;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutosManutencao frame = new FormProdutosManutencao();
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
	public FormProdutosManutencao() {
		setTitle("Manuten\u00E7\u00E3o Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		btnConfirmar = new JButton("Confirmar");
		pnlBotoes.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		pnlBotoes.add(btnCancelar);
		
		JPanel pnlMeio = new JPanel();
		contentPane.add(pnlMeio, BorderLayout.NORTH);
		pnlMeio.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel pnlId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlId);
		
		JLabel lblId = new JLabel("Id");
		pnlId.add(lblId);
		
		textId = new JTextField();
		pnlId.add(textId);
		textId.setColumns(10);
		
		JPanel pnlDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		pnlDescricao.add(lblDescricao);
		
		textDescricao = new JTextField();
		pnlDescricao.add(textDescricao);
		textDescricao.setColumns(30);
		
		JPanel pnlSaldo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlSaldo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlSaldo);
		
		JLabel lblSaldo = new JLabel("Saldo");
		pnlSaldo.add(lblSaldo);
		
		fmtSaldo = new JFormattedTextField();
		fmtSaldo.setColumns(10);
		pnlSaldo.add(fmtSaldo);
		
		JPanel pnlPreco = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlPreco.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		pnlPreco.add(lblPreco);
		
		fmtPreco = new JFormattedTextField();
		fmtPreco.setColumns(15);
		pnlPreco.add(fmtPreco);
		
		JPanel pnlLocalEstoque = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlLocalEstoque.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlMeio.add(pnlLocalEstoque);
		
		JLabel lblLocalEstoque = new JLabel("Local Estoque");
		pnlLocalEstoque.add(lblLocalEstoque);
		
		textLocalEstoque = new JTextField();
		pnlLocalEstoque.add(textLocalEstoque);
		textLocalEstoque.setColumns(20);
	}

	public int getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		switch (tipoOperacao) {
		case 1 : //adicionar
		case 3 : //alterar
			textId.setEnabled(false);
			textDescricao.setEnabled(true);
			fmtPreco.setEnabled(true);
			fmtSaldo.setEnabled(true);
			textLocalEstoque.setEnabled(true);
			break;
		case 2://consultar
		case 4://excluir
			textId.setEnabled(false);
			textDescricao.setEnabled(false);
			fmtPreco.setEnabled(false);
			fmtSaldo.setEnabled(false);
			textLocalEstoque.setEnabled(false);
			break;			
		}
		//Só não libera no caso da consulta
		btnConfirmar.setEnabled(tipoOperacao!=2);
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

}
