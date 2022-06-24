package br.com.senaisp.aula32.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormGridCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormGridCliente frame = new FormGridCliente();
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
	public FormGridCliente() {
		setTitle("Grid de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		Cliente cli = new Cliente();
		try {
			DefaultTableModel tblCli = cli.listaCliente();
			tblCliente = new JTable(tblCli) {
				@Override
				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
					Component tbr = super.prepareRenderer(renderer, row, column);
					if (!isCellSelected(row, column)) {
						tbr.setBackground(row % 2 == 1 ? Color.LIGHT_GRAY : Color.WHITE);
					}
					return tbr;
				}
			};
			scrollPane.setViewportView(tblCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
