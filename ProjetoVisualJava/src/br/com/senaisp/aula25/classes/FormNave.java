package br.com.senaisp.aula25.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormNave extends JFrame {

	private JPanel contentPane;
	private JLabel lblNave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormNave frame = new FormNave();
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
	public FormNave() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Rectangle rec = lblNave.getBounds();
				switch(e.getExtendedKeyCode()) {
				case KeyEvent.VK_LEFT : rec.x -= 10; break;
				case KeyEvent.VK_RIGHT : rec.x += 10; break;
				case KeyEvent.VK_UP : rec.y -= 10; break;
				case KeyEvent.VK_DOWN : rec.y += 10; break;
				}
				lblNave.setBounds(rec);
			}
		});
		EventoClick evt = new EventoClick();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnNewButton = new JButton("^");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(">");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("v");
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblNave = new JLabel("<+>");
		lblNave.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNave.setBounds(205, 128, 46, 14);
		panel_1.add(lblNave);
		
		btnNewButton.addActionListener(evt);
		btnNewButton_1.addActionListener(evt);
		btnNewButton_2.addActionListener(evt);
		btnNewButton_3.addActionListener(evt);	
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			Rectangle rec = lblNave.getBounds();
			switch ( ((JButton)obj).getText() ) {
			case "^" : rec.y -= 10; break;
			case "<" : rec.x -= 10; break;
			case ">" : rec.x += 10; break;
			case "v" : rec.y += 10; break;
			}
			lblNave.setBounds(rec);
		}
		
	}
}
