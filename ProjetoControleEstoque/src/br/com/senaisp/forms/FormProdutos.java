package br.com.senaisp.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import br.com.senaisp.classes.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class FormProdutos extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private Produto prod;

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
		EventoClick evt = new EventoClick();
		setTitle("Manuten\u00E7\u00E3o Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);

		JButton btnAdicionar = new JButton("Adicionar");
		pnlBotoes.add(btnAdicionar);
		btnAdicionar.addActionListener(evt);

		JButton btnConsultar = new JButton("Consultar");
		pnlBotoes.add(btnConsultar);
		btnConsultar.addActionListener(evt);

		JButton btnAlterar = new JButton("Alterar");
		pnlBotoes.add(btnAlterar);
		btnAlterar.addActionListener(evt);

		JButton btnExcluir = new JButton("Excluir");
		pnlBotoes.add(btnExcluir);
		btnExcluir.addActionListener(evt);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		prod = new Produto();
		DefaultTableModel tblMdProdutos = prod.getListaProdutos();

		tblProdutos = new JTable(tblMdProdutos) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component ret = super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row)) {
					ret.setBackground(row % 2 != 1 ? Color.WHITE : Color.LIGHT_GRAY);
				}
				return ret;
			}
		};
		scrollPane.setViewportView(tblProdutos);
	}

	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			FormProdutosManutencao fmProd = new FormProdutosManutencao();
			fmProd.setProd(prod);
			// Pegando qual a linha que está selecionada
			int linha = tblProdutos.getSelectedRow();
			if (!btn.getText().equals("Adicionar") && linha == -1) {
				JOptionPane.showMessageDialog(null, "Favor Selecionar um registro!");
			} else {
				if (!btn.getText().equals("Adicionar")) {
					DefaultTableModel tblmd = (DefaultTableModel) tblProdutos.getModel();
					prod.setId((int) tblmd.getValueAt(linha, 0));
					prod.read();
				} else {
					prod.novo();
				}
				switch (btn.getText()) {
				case "Adicionar": fmProd.setTipoOperacao(1); break;
				case "Consultar": fmProd.setTipoOperacao(2); break;
				case "Alterar": fmProd.setTipoOperacao(3); break;
				case "Excluir": fmProd.setTipoOperacao(4); break;
				}
				fmProd.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						super.windowClosed(e);
						System.out.println("Fechei a janela!");
						tblProdutos.setModel(prod.getListaProdutos());
					}
				});
				fmProd.setVisible(true);
			}
		}

	}
}
