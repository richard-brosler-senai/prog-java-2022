package br.com.senaisp.aula29.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class TesteRadioButton extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteRadioButton frame = new TesteRadioButton();
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
	public TesteRadioButton() {
		EventoClick evt = new EventoClick();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JRadioButton rdgMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rdgMasculino);
		panel.add(rdgMasculino);
		rdgMasculino.addActionListener(evt);
		
		JRadioButton rdgFeminino = new JRadioButton("Feminino");
		buttonGroup.add(rdgFeminino);
		panel.add(rdgFeminino);
		rdgFeminino.addActionListener(evt);
		
		JRadioButton rdgNaoInformado = new JRadioButton("N\u00E3o Informado");
		buttonGroup.add(rdgNaoInformado);
		panel.add(rdgNaoInformado);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"a", "a", "a"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(list);
		rdgNaoInformado.addActionListener(evt);
	}
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton cmp = (JRadioButton) e.getSource();
			if (cmp.isSelected()) {
				JOptionPane.showMessageDialog(null, 
						cmp.getText() + " foi selecionado!");
			}
		}
		
	}
}
