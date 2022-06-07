package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class FormManutencao extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField fmtCodigo;
	private JTextField textDescricao;
	private int tipoEdicao;
	private JFormattedTextField fmtPreco;
	private Produto prod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormManutencao frame = new FormManutencao();
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
	public FormManutencao() {
		EventoClick evtClick = new EventoClick();
		
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnGravar = new JButton("Gravar");
		panelBotoes.add(btnGravar);
		btnGravar.addActionListener(evtClick);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotoes.add(btnCancelar);
		btnCancelar.addActionListener(evtClick);
		
		JPanel panelCorpo = new JPanel();
		contentPane.add(panelCorpo, BorderLayout.NORTH);
		panelCorpo.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panelCodigo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCodigo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panelCodigo.add(lblCodigo);
		
		NumberFormat fmtI = NumberFormat.getInstance();
		NumberFormatter fmttI = new NumberFormatter(fmtI);
		fmttI.setValueClass(Integer.class);
		fmttI.setMinimum(0);
		fmttI.setMaximum(Integer.MAX_VALUE);
		fmttI.setAllowsInvalid(false);
		
		fmtCodigo = new JFormattedTextField(fmttI);
		panelCodigo.add(fmtCodigo);
		fmtCodigo.setColumns(10);
		fmtCodigo.setValue(0);
		
		JPanel panelDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		panelDescricao.add(lblDescricao);
		
		textDescricao = new JTextField();
		panelDescricao.add(textDescricao);
		textDescricao.setColumns(30);
		
		JPanel panelPreco = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPreco.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		panelPreco.add(lblPreco);
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		NumberFormatter fmtt = new NumberFormatter(fmt);
		fmtt.setMinimum(0.00);
		
		fmtPreco = new JFormattedTextField(fmtt);
		fmtPreco.setColumns(10);
		fmtPreco.setValue(0.00);
		panelPreco.add(fmtPreco);
	}

	public void setTipoEdicao(int tipoEdicao) {
		this.tipoEdicao = tipoEdicao;
		//operacao 1 - Cadastrar, 2 - Consultar, 3 - Alterar, 4 - Excluir
		switch(tipoEdicao) {
		case 1 :
			fmtCodigo.setValue(prod.getCodigo());
			textDescricao.setText(prod.getDescricao());
			fmtPreco.setValue(prod.getPreco());
			break;
		}
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			if ( ((JButton)cmp).getText()=="Gravar" ) {
				prod.setCodigo((int)fmtCodigo.getValue());
				prod.setDescricao(textDescricao.getText());
				prod.setPreco((double)fmtPreco.getValue());
				
				prod.adicionar();
			} else {
				dispose();
			}
		}
		
	}
}
