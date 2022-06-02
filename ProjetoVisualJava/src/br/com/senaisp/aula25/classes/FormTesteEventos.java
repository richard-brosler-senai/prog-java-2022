package br.com.senaisp.aula25.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;

public class FormTesteEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JPasswordField passwordField;
	private JMenuItem mntmCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTesteEventos frame = new FormTesteEventos();
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
	public FormTesteEventos() {
		EventoClick evtClk = new EventoClick();
		EventoFocus evtFoc = new EventoFocus();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		mnProdutos.addActionListener(evtClk);
		mnProdutos.addFocusListener(evtFoc);
		
		mntmCadastrar = new JMenuItem("Cadastrar");
		mnProdutos.add(mntmCadastrar);
		mntmCadastrar.addActionListener(evtClk);
		mntmCadastrar.addFocusListener(evtFoc);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnProdutos.add(mntmConsultar);
		mntmConsultar.addActionListener(evtClk);
		mntmConsultar.addFocusListener(evtFoc);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnProdutos.add(mntmAlterar);
		mntmAlterar.addActionListener(evtClk);
		mntmAlterar.addFocusListener(evtFoc);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnProdutos.add(mntmExcluir);
		mntmExcluir.addActionListener(evtClk);
		mntmExcluir.addFocusListener(evtFoc);
		
		JSeparator separator = new JSeparator();
		mnProdutos.add(separator);
		
		JMenu mnListar = new JMenu("Listar");
		mnProdutos.add(mnListar);
		mnListar.addActionListener(evtClk);
		mnListar.addFocusListener(evtFoc);
		
		JMenuItem mntmListaAlfabetica = new JMenuItem("Listagem Ordem Alfab\u00E9tica");
		mnListar.add(mntmListaAlfabetica);
		mntmListaAlfabetica.addActionListener(evtClk);
		mntmListaAlfabetica.addFocusListener(evtFoc);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		mnCliente.addActionListener(evtClk);
		mnCliente.addFocusListener(evtFoc);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTopo = new JPanel();
		contentPane.add(panelTopo, BorderLayout.NORTH);
		panelTopo.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panelCodigo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCodigo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTopo.add(panelCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panelCodigo.add(lblCodigo);
		lblCodigo.addFocusListener(evtFoc);
		
		
		textCodigo = new JTextField();
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		//textCodigo.addFocusListener();
		textCodigo.addActionListener(evtClk);
		textCodigo.addFocusListener(evtFoc);
		
		panelCodigo.add(textCodigo);
		textCodigo.setColumns(10);
		
		JPanel panelDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTopo.add(panelDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		panelDescricao.add(lblDescricao);
		lblDescricao.addFocusListener(evtFoc);
		
		textDescricao = new JTextField();
		textDescricao.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent evt) {
			}
		});
		panelDescricao.add(textDescricao);
		textDescricao.setColumns(40);
		textDescricao.addActionListener(evtClk);
		textDescricao.addFocusListener(evtFoc);
		
		JPanel panelPreco = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPreco.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelTopo.add(panelPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		panelPreco.add(lblPreco);
		lblPreco.addFocusListener(evtFoc);
		
		textPreco = new JTextField();
		panelPreco.add(textPreco);
		textPreco.setColumns(10);
		textPreco.addActionListener(evtClk);
		textPreco.addFocusListener(evtFoc);
		
		JPanel panelDiversos = new JPanel();
		panelTopo.add(panelDiversos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"}));
		panelDiversos.add(comboBox);
		comboBox.addFocusListener(evtFoc);
		
		comboBox.addActionListener(evtClk);
		
		JButton btnNewButton = new JButton("New button");
		panelDiversos.add(btnNewButton);
		btnNewButton.addFocusListener(evtFoc);
		
		btnNewButton.addActionListener(evtClk);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panelDiversos.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(evtClk);
		chckbxNewCheckBox.addFocusListener(evtFoc);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panelDiversos.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(evtClk);
		rdbtnNewRadioButton.addFocusListener(evtFoc);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panelDiversos.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(evtClk);
		tglbtnNewToggleButton.addFocusListener(evtFoc);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(20);
		panelDiversos.add(formattedTextField);
		formattedTextField.addActionListener(evtClk);
		formattedTextField.addFocusListener(evtFoc);
		
		JPanel panel = new JPanel();
		panelTopo.add(panel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel.add(passwordField);
		passwordField.addActionListener(evtClk);
		passwordField.addFocusListener(evtFoc);
		
		JEditorPane editorPane = new JEditorPane();
		panel.add(editorPane);
		editorPane.addFocusListener(evtFoc);
		
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.SOUTH);
		textArea.addFocusListener(evtFoc);
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			System.out.println(obj.getClass().getName() + " Foi Clicado!");
			if (obj == mntmCadastrar) {
				System.out.println("Escolhi o menu cadastrar");
			}
			if (obj instanceof JMenuItem && 
					((JMenuItem)obj).getText()=="Consultar") {
				System.out.println("Escolhi o menu Consultar");
			}
		}
		
	}
	
	class EventoFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			Object obj = e.getSource();
			System.out.println(obj.getClass().getName() + " Recebeu focus");
		}

		@Override
		public void focusLost(FocusEvent e) {
			Object obj = e.getSource();
			System.out.println(obj.getClass().getName() + " Perdeu focus");
		}
		
	}

}
