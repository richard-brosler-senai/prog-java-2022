package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.com.senaisp.aula28.classes.FormCliente.EstadoCivil;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class FormClienteManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField fmtTelefone;
	private JFormattedTextField fmtCodigo;
	private JFormattedTextField fmtDtNasc;
	private DefaultTableModel tblMdCli;
	private int linhaSelecionada;
	private int tipoOperacao; //1 - criar, 2-consultar, 3-alterar, 4 -excluir
	private DateFormat fmtDt;
	private JButton btnConfirmar;
	private JComboBox<EstadoCivil> cmbEstadoCivil;
	private DefaultComboBoxModel<EstadoCivil> modCombo;
	private JFormattedTextField fmtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormClienteManutencao frame = new FormClienteManutencao();
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
	public FormClienteManutencao() {
		EventoClick evt = new EventoClick();
		
		setTitle("Manuten\u00E7\u00E3o Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 422);
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
		
		JPanel pnlCorpo = new JPanel();
		contentPane.add(pnlCorpo, BorderLayout.NORTH);
		pnlCorpo.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel pnlCodigo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlCodigo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		pnlCodigo.add(lblCodigo);
		
		NumberFormat fmtNm = NumberFormat.getInstance();
		NumberFormatter fmtNmt = new NumberFormatter(fmtNm);
		
		fmtNmt.setValueClass(Integer.class);
		fmtNmt.setMinimum(0);
		fmtNmt.setMaximum(Integer.MAX_VALUE);
		fmtNmt.setAllowsInvalid(false);
		
		fmtCodigo = new JFormattedTextField(fmtNmt);
		fmtCodigo.setColumns(10);
		pnlCodigo.add(fmtCodigo);
		fmtCodigo.setValue(0);
		
		JPanel pnlNome = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlNome.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlNome);
		
		JLabel lblNome = new JLabel("Nome");
		pnlNome.add(lblNome);
		
		txtNome = new JTextField();
		pnlNome.add(txtNome);
		txtNome.setColumns(30);
		
		JPanel pnlTelefone = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlTelefone.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlTelefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		pnlTelefone.add(lblTelefone);
		
		try {
			MaskFormatter fmtFone = new MaskFormatter("(##) *#####-####");
			fmtTelefone = new JFormattedTextField(fmtFone);
			pnlTelefone.add(fmtTelefone);
			fmtTelefone.setColumns(10);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel pnlDtNasc = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlDtNasc.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlDtNasc);
		
		JLabel lblDtNasc = new JLabel("Dt. Nascimento");
		pnlDtNasc.add(lblDtNasc);
		
		fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter fmtDtt = new DateFormatter(fmtDt);
		
		fmtDtt.setAllowsInvalid(false);
		//Se esquecer isso, o Usuário vai lembrar da sua arvore genealógica
		fmtDtt.setOverwriteMode(true); 
		
		fmtDtNasc = new JFormattedTextField(fmtDtt);
		fmtDtNasc.setColumns(10);
		pnlDtNasc.add(fmtDtNasc);
		fmtDtNasc.setValue(new Date());
		
		JPanel pnlEstadoCivil = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlEstadoCivil.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlEstadoCivil);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		pnlEstadoCivil.add(lblEstadoCivil);
		
		modCombo = new DefaultComboBoxModel<EstadoCivil>(EstadoCivil.values());
		
		cmbEstadoCivil = new JComboBox<EstadoCivil>(modCombo);
		pnlEstadoCivil.add(cmbEstadoCivil);
		
		JPanel pnlCPF = new JPanel();
		FlowLayout fl_pnlCPF = (FlowLayout) pnlCPF.getLayout();
		fl_pnlCPF.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlCPF);
		
		JLabel lblCPF = new JLabel("CPF");
		pnlCPF.add(lblCPF);
		
		try {
			MaskFormatter fmtDoc = new MaskFormatter("###.###.###-##");
			fmtCPF = new JFormattedTextField(fmtDoc);
			fmtCPF.setColumns(15);
			pnlCPF.add(fmtCPF);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void setTblMdCli(DefaultTableModel tblMdCli) {
		this.tblMdCli = tblMdCli;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		switch(tipoOperacao) {
		case 2:
		case 3:
		case 4:
			fmtCodigo.setEnabled(false);
			txtNome.setEnabled(tipoOperacao==3);
			fmtTelefone.setEnabled(tipoOperacao==3);
			fmtDtNasc.setEnabled(tipoOperacao==3);
			btnConfirmar.setEnabled(tipoOperacao!=2);
			
			fmtCodigo.setValue(tblMdCli.getValueAt(linhaSelecionada, 0));
			txtNome.setText((String)tblMdCli.getValueAt(linhaSelecionada, 1));
			fmtTelefone.setText((String)tblMdCli.getValueAt(linhaSelecionada, 2));
			try {
				Date dtNasc =fmtDt.parse((String)tblMdCli.getValueAt(linhaSelecionada, 3));
				fmtDtNasc.setValue(dtNasc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modCombo.setSelectedItem(tblMdCli.getValueAt(linhaSelecionada, 4));
			fmtCPF.setValue(tblMdCli.getValueAt(linhaSelecionada, 5));
		}
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			switch ( ((JButton) cmp).getText() ) {
			case "Confirmar" :
				Date dtNasc = (Date) fmtDtNasc.getValue();
				switch (tipoOperacao) {
				case 1 :
					Object it[] = {
							fmtCodigo.getValue(),
							txtNome.getText(),
							fmtTelefone.getText(),
							fmtDt.format(dtNasc),
							modCombo.getSelectedItem(),
							fmtCPF.getValue() //aqui
					};
					tblMdCli.addRow(it);
					break;
				case 3 :
					tblMdCli.setValueAt(txtNome.getText(),linhaSelecionada, 1);
					tblMdCli.setValueAt(fmtTelefone.getText(),linhaSelecionada, 2);
					tblMdCli.setValueAt(fmtDt.format(dtNasc),linhaSelecionada, 3);
					tblMdCli.setValueAt(modCombo.getSelectedItem(), linhaSelecionada, 4);
					tblMdCli.setValueAt(fmtCPF.getValue(), linhaSelecionada, 5);//aqui
					break;
				case 4 :
					tblMdCli.removeRow(linhaSelecionada);
					break;
				}
			case "Cancelar":
				dispose();
			}
		}
		
	}
}
