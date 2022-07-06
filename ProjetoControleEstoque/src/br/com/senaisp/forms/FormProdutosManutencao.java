package br.com.senaisp.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import br.com.senaisp.classes.Produto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class FormProdutosManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtLocalEstoque;
	private JFormattedTextField fmtSaldo;
	private JFormattedTextField fmtPreco;
	private Produto prod;
	private int tipoOperacao; //1-create,2-read,3-update,4-delete
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
		EventoClick evt = new EventoClick();
		setTitle("Manuten\u00E7\u00E3o Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		btnConfirmar = new JButton("Confirmar");
		pnlBotoes.add(btnConfirmar);
		btnConfirmar.addActionListener(evt);
		
		JButton btnCancelar = new JButton("Cancelar");
		pnlBotoes.add(btnCancelar);
		btnCancelar.addActionListener(evt);
		
		JPanel pnlCampos = new JPanel();
		contentPane.add(pnlCampos, BorderLayout.NORTH);
		pnlCampos.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel pnlId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlId);
		
		JLabel lblId = new JLabel("Id");
		pnlId.add(lblId);
		
		txtId = new JTextField();
		pnlId.add(txtId);
		txtId.setColumns(10);
		
		JPanel pnlDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		pnlDescricao.add(lblDescricao);
		
		txtDescricao = new JTextField();
		pnlDescricao.add(txtDescricao);
		txtDescricao.setColumns(40);
		
		JPanel pnlSaldo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlSaldo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlSaldo);
		
		JLabel lblSaldo = new JLabel("Saldo");
		pnlSaldo.add(lblSaldo);
		
		NumberFormat nmFmt = NumberFormat.getInstance();
		NumberFormatter nmFmti = new NumberFormatter(nmFmt);
		nmFmti.setValueClass(Integer.class);
		nmFmti.setMinimum(0);
		nmFmti.setMaximum(Integer.MAX_VALUE);
		nmFmti.setAllowsInvalid(false);
		
		fmtSaldo = new JFormattedTextField(nmFmti);
		fmtSaldo.setColumns(10);
		fmtSaldo.setValue(0);
		pnlSaldo.add(fmtSaldo);
		
		JPanel pnlPreco = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlPreco.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		pnlPreco.add(lblPreco);
		
		NumberFormat nmFmtP = NumberFormat.getCurrencyInstance();
		NumberFormatter nmFmtPi = new NumberFormatter(nmFmtP);
		nmFmtPi.setMinimum(0.00);
		nmFmtPi.setMaximum(999999999999.99);
		nmFmtPi.setAllowsInvalid(false);
		
		fmtPreco = new JFormattedTextField(nmFmtPi);
		fmtPreco.setColumns(10);
		fmtPreco.setValue(0.00);
		pnlPreco.add(fmtPreco);
		
		JPanel pnlLocalEstoque = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlLocalEstoque.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlLocalEstoque);
		
		JLabel lblLocalEstoque = new JLabel("Local Estoque");
		pnlLocalEstoque.add(lblLocalEstoque);
		
		txtLocalEstoque = new JTextField();
		pnlLocalEstoque.add(txtLocalEstoque);
		txtLocalEstoque.setColumns(30);
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		txtId.setEnabled(false);
		//Fica habilitado só quando for inclusão ou alteração
		txtDescricao.setEnabled(tipoOperacao==1 || tipoOperacao==3);
		fmtSaldo.setEnabled(txtDescricao.isEnabled());
		fmtPreco.setEnabled(txtDescricao.isEnabled());
		txtLocalEstoque.setEnabled(txtDescricao.isEnabled());
		//Só fica habilitado quando não for consultar
		btnConfirmar.setEnabled(tipoOperacao!=2);
		//Populando os campos com os dados do produto
		txtId.setText(Integer.toString(prod.getId()));
		txtDescricao.setText(prod.getDescricao());
		fmtPreco.setValue(prod.getPreco());
		fmtSaldo.setValue(prod.getSaldo());
		txtLocalEstoque.setText(prod.getLocalEstoque());
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("Confirmar")) {
				boolean retAcao = false;
				//Se for adicionar ou alterar
				if (tipoOperacao==1 || tipoOperacao == 3) {
					prod.setDescricao(txtDescricao.getText());
					prod.setSaldo((int) fmtSaldo.getValue());
					prod.setPreco((double) fmtPreco.getValue());
					prod.setLocalEstoque(txtLocalEstoque.getText());
					if (tipoOperacao==1) {
						retAcao = prod.create();
					} else {
						retAcao = prod.update();
					}
				} else {
					if (JOptionPane.showConfirmDialog(null, 
						"Confirma exclusão?", 
						"Confirmação", 
						JOptionPane.OK_CANCEL_OPTION)==
						JOptionPane.OK_OPTION) {
						retAcao = prod.delete();
					} else {
						retAcao = true;
					}
				}
				//Verificando se ocorreu algum erro nas operações
				if (!retAcao) {
					JOptionPane.showMessageDialog(null, 
							"Ocorreu um erro na operação! Erro:" + 
					prod.getMsgErro());
				}
				//fechando o formulário
				dispose();
			} else {
				dispose();
			}
			
		}
		
	}
}
