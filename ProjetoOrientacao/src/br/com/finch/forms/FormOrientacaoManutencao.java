package br.com.finch.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import br.com.finch.classes.Orientacao;

public class FormOrientacaoManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPalavraChave;
	private JTextField txtTitulo;
	
	private int tipoOperacao; //1-create,2-read,3-update,4-delete
	private Orientacao or;
	private JEditorPane edPnlTexto;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormOrientacaoManutencao frame = new FormOrientacaoManutencao();
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
	public FormOrientacaoManutencao() {
		EventoClick evt = new EventoClick();
		setTitle("Manuten\u00E7\u00E3o Orienta\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
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
		pnlCampos.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel pnlId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlId);
		
		JLabel lblId = new JLabel("Id");
		pnlId.add(lblId);
		
		txtId = new JTextField();
		pnlId.add(txtId);
		txtId.setColumns(10);
		
		JPanel pnlPalavraChave = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlPalavraChave.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlPalavraChave);
		
		JLabel lblPalavraChave = new JLabel("Palavras Chave");
		pnlPalavraChave.add(lblPalavraChave);
		
		txtPalavraChave = new JTextField();
		pnlPalavraChave.add(txtPalavraChave);
		txtPalavraChave.setColumns(20);
		
		JPanel pnlTitulo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlTitulo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCampos.add(pnlTitulo);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		pnlTitulo.add(lblTitulo);
		
		txtTitulo = new JTextField();
		pnlTitulo.add(txtTitulo);
		txtTitulo.setColumns(20);
		
		JPanel pnlEditor = new JPanel();
		contentPane.add(pnlEditor, BorderLayout.CENTER);
		pnlEditor.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEditorLabel = new JPanel();
		pnlEditor.add(pnlEditorLabel, BorderLayout.NORTH);
		
		JLabel lblEditor = new JLabel("Texto da Orienta\u00E7\u00E3o");
		pnlEditorLabel.add(lblEditor);
		
		JScrollPane scrollPane = new JScrollPane();
		pnlEditor.add(scrollPane, BorderLayout.CENTER);
		
		edPnlTexto = new JEditorPane();
		edPnlTexto.setContentType("text/rtf");
		scrollPane.setViewportView(edPnlTexto);
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		txtId.setEditable(false);
		txtPalavraChave.setEditable(tipoOperacao==1 || tipoOperacao==3);
		txtTitulo.setEditable(txtPalavraChave.isEditable());
		edPnlTexto.setEditable(txtPalavraChave.isEditable());
		btnConfirmar.setEnabled(tipoOperacao!=2);
		
		txtId.setText(Integer.toString(or.getId()));
		txtPalavraChave.setText(or.getPalavraChave());
		txtTitulo.setText(or.getTitulo());
		Document doc = edPnlTexto.getDocument();
		try {
			doc.insertString(0, or.getTexto(), null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setOr(Orientacao or) {
		this.or = or;
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn.getText().equals("Confirmar")) {
				boolean haErro = false;
				if (tipoOperacao==1 || tipoOperacao==3) {
					or.setPalavraChave(txtPalavraChave.getText());
					or.setTitulo(txtTitulo.getText());
					//Obtendo o código RTF do texto digitado para poder armazenar no banco de dados
					RTFEditorKit rtf = new RTFEditorKit();
					Document doc = edPnlTexto.getDocument();
					ByteArrayOutputStream str = new ByteArrayOutputStream();
					try {
						rtf.write(str, doc, 0, doc.getLength());
						or.setTexto(str.toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (tipoOperacao==1) {
						haErro = or.create();
					} else {
						haErro = or.update();
					}
				} else { //excluir
					if (JOptionPane.showConfirmDialog(null, "Confirma exclusão?","Confirmação",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
						haErro = or.delete();
					}
				}
				if (haErro) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro! Erro:" + or.getMsgErro());
				}
				dispose();
			} else {
				dispose();
			}
		}
		
	}
}
