package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FormListarProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private Produto prod;
	private DefaultTableModel tblMdProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListarProduto frame = new FormListarProduto();
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
	public FormListarProduto() {
		setTitle("Listagem Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 552);
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnFechar = new JButton("Fechar");
		panelBotoes.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrTabela = new JScrollPane();
		contentPane.add(scrTabela, BorderLayout.CENTER);
		String cabecalho[] = { "Código","Descrição","Preço" };
		
		tblMdProd = new DefaultTableModel(cabecalho,0); 
		
		tblProdutos = new JTable(tblMdProd){
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		        Component returnComp = super.prepareRenderer(renderer, row, column);
		        Color alternateColor = new Color(192,192,192);
		        Color whiteColor = Color.WHITE;
		        if (!returnComp.getBackground().equals(getSelectionBackground())){
		            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
		            returnComp.setBackground(bg);
		            //Alinhando usando o evento de renderização
		            if (column==0 || column==2) {
		              ((JLabel) returnComp).
		                  setHorizontalAlignment(SwingConstants.RIGHT);
		            } else {
			              ((JLabel) returnComp).
		                  setHorizontalAlignment(SwingConstants.LEFT);
		            }
		            //Colocando espaço na celula
		            ((JLabel) returnComp).
		            	setBorder(
		            		BorderFactory.createEmptyBorder(0, 5, 0, 5));
		            bg = null;
		        }
		        return returnComp;
		    }
		};

		//DefaultTableCellRenderer alinhaDireita =  new DefaultTableCellRenderer();
		//alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
		//tblProdutos.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
		//tblProdutos.getColumnModel().getColumn(2).setCellRenderer(alinhaDireita);
		
		//tblProdutos.setIntercellSpacing(new Dimension(10,0));
		
		scrTabela.setViewportView(tblProdutos);
	}

	public void setProd(Produto prod) {
		this.prod = prod;
		for(int intLin=0;intLin<prod.getListaSize();intLin++) {
			Produto it = prod.getListaProdutos().get(intLin);
			Object item[] = {  ("0000000"+it.getCodigo()), 
							  it.getDescricao(),
							  it.getPreco() 
							};
			
			tblMdProd.addRow(item);
		}
	}

}
