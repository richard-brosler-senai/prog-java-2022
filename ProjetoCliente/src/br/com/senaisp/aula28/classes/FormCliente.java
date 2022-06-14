package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private DefaultTableModel tblMdCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
		EventoClick evt = new EventoClick();
		
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 719, 430);
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
		btnAlterar.addActionListener(evt);
		pnlBotoes.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		pnlBotoes.add(btnExcluir);
		btnExcluir.addActionListener(evt);
		
		JScrollPane scrClientes = new JScrollPane();
		contentPane.add(scrClientes, BorderLayout.CENTER);
		
		String titulos[] = { "Código", "Nome", "Telefone", "Dt.Nascimento", "Estado Civil", "CPF" };
		
		tblMdCli = new DefaultTableModel(titulos,0) {
			//Desabilitando a edição das celulas
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblClientes = new JTable(tblMdCli) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				//Só não aplicamos a cor quando a linha está selecionada
				if ( !isCellSelected(row, column) ) {
					cmp.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
				}
				//Alinhando a coluna do código
				if (column==0) {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.RIGHT);
				} else {
					((JLabel) cmp).setHorizontalAlignment(SwingConstants.LEFT);
				}
				//Colocando o espaçamento entre a borda da celula e o conteúdo
				((JLabel) cmp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
				
				return cmp; 
			}
		};
		
		tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(5).setPreferredWidth(100);



		
		scrClientes.setViewportView(tblClientes);
		//Obtendo o objeto de calendário para utilizar datas
		Calendar cal = Calendar.getInstance();
		//Obtendo o objeto formatador de datas
		DateFormat fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		cal.set(1980, 0, 18);
		Random rdm = new Random();
		for (int lin=1;lin<=100;lin++) {
			cal.add(Calendar.DATE, 1);
			//Colocando a data para dia(variando de 1 a 5), mês 1 e ano 1980
			Date dtNasc = cal.getTime();
			Object item[] = { lin, "Cliente " + lin, 
							  "14 9999-8833", 
							  fmtDt.format(dtNasc),
							  EstadoCivil.values()[rdm.nextInt(5)],
							  "000.000.000-00"
							  };
			//Adicionando o item à linha conjunto de dados
			tblMdCli.addRow(item);
		}
	}
	
  class EventoClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object cmp = e.getSource();
		FormClienteManutencao fmtCli = new FormClienteManutencao();
		fmtCli.setTblMdCli(tblMdCli);
		switch ( ((JButton)cmp).getText() ) {
		case "Adicionar" : 
			fmtCli.setTipoOperacao(1);
			break;
		case "Consultar" :
			fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
			fmtCli.setTipoOperacao(2);
			break;
		case "Alterar" :
			fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
			fmtCli.setTipoOperacao(3);
			break;
		case "Excluir" :
			fmtCli.setLinhaSelecionada(tblClientes.getSelectedRow());
			fmtCli.setTipoOperacao(4);
			break;
		}
		fmtCli.setVisible(true);
	}
	  
  }
  
  public enum EstadoCivil {
	  Solteiro,
	  Casado,
	  Separado,
	  Divorciado,
	  Viuvo
  }
}
