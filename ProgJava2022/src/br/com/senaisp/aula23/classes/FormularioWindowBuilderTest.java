package br.com.senaisp.aula23.classes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senaisp.aula21.classes.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormularioWindowBuilderTest extends JFrame {

	private JPanel contentPane;
	private JTextField textSKU;
	private JTextField txtNomeProduto;
	private Cliente cli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioWindowBuilderTest frame = new FormularioWindowBuilderTest();
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
	public FormularioWindowBuilderTest() {
		cli = new Cliente();
		cli.setCodigo(10);
		cli.setNome("Richard");
		cli.setEndereco("Endereco");
		cli.adicionar();
		
		setTitle("Pesquisa de Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SKU Produto");
		lblNewLabel.setBounds(23, 11, 84, 14);
		contentPane.add(lblNewLabel);
		
		textSKU = new JTextField();
		textSKU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
					cli.setCodigo(Integer.parseInt(textSKU.getText()));
					cli.consultar();
					txtNomeProduto.setText(cli.getNome());					
				}
			}
		});
		textSKU.setBounds(93, 8, 231, 20);
		contentPane.add(textSKU);
		textSKU.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto");
		lblNewLabel_1.setBounds(10, 37, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(103, 36, 231, 20);
		contentPane.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cli.setCodigo(Integer.parseInt(textSKU.getText()));
				cli.consultar();
				txtNomeProduto.setText(cli.getNome());
			}
		});
		btnNewButton.setBounds(334, 7, 89, 23);
		contentPane.add(btnNewButton);
	}
}
