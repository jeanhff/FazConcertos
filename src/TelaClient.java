import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class TelaClient extends JFrame {
	
	GestaoBDCliente cliente = new GestaoBDCliente();
	private JPanel contentPane;

	private JTextField nomeClienteField;
	private JTextField sobrenomeClienteField;
	private JTextField CPFField;
	private JTextField nascimentoField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField CPFClientePesqField;
	private JTextField relogio;
	private JButton adicionar;
	private JButton apagar;
	private JButton modificar;
	private JButton aceitar ;
	
	private JLabel nomeCliente;
	private JLabel sobrenomeCliente;
	private JLabel CPF; 
	private JLabel nascimento;
	private JLabel Telefone;
	private JLabel CPFClientePesq;
	private JLabel email;
	
	private JTextField searchField;
	private JScrollPane scrollPane;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClient frame = new TelaClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaClient() {
		setTitle("Gestao Cliente");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(810, 420);
		setLocationRelativeTo(null);
		contentPane = new Panneau();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String cpf,nome,sobrenome,nascimento,email,telefone;
				Object source=evt.getSource();
				if(source==adicionar){
					cpf=CPFField.getText();
					nome=nomeClienteField.getText();
					sobrenome=sobrenomeClienteField.getText();
					nascimento=nascimentoField.getText();
					email=emailField.getText();
					telefone=telefoneField.getText();
					CPFField.setText("");
					nomeClienteField.setText("");
					sobrenomeClienteField.setText("");
					nascimentoField.setText("");
					emailField.setText("");
					telefoneField.setText("");
					cliente.adicionarCliente(cpf,nome,sobrenome,nascimento,email,telefone);
					pesquisar(cpf);			
				
				}
			}});
		adicionar.setBounds(10, 336, 227, 23);
		getContentPane().add(adicionar);
		
		apagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==apagar){
					JOptionPane.showMessageDialog(null,"Quere continuar?","Cuidado",JOptionPane.YES_NO_CANCEL_OPTION);
					String cpf=CPFClientePesqField.getText();
					cliente.apagarCliente(cpf);
					CPFClientePesqField.setText("");
				}
			}
		});
		apagar.setBounds(285, 39, 115, 23);
		getContentPane().add(apagar);
		
		relogio = new JTextField();
		relogio.setForeground(Color.LIGHT_GRAY);
		relogio.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 34));
		relogio.setEditable(false);
		relogio.setBounds(10, 11, 156, 36);
		getContentPane().add(relogio);
		relogio.setColumns(5);
		
		nomeCliente = new JLabel("Nome Cliente");
		nomeCliente.setBounds(10, 90, 99, 23);
		getContentPane().add(nomeCliente);
		
		sobrenomeCliente = new JLabel("Sobrenome Cliente");
		sobrenomeCliente.setBounds(10, 133, 99, 14);
		getContentPane().add(sobrenomeCliente);
		
		CPF = new JLabel("CPF Cliente");
		CPF.setBounds(10, 179, 79, 14);
		getContentPane().add(CPF);
		
		nascimento = new JLabel("Data Naissance");
		nascimento.setBounds(10, 221, 89, 14);
		getContentPane().add(nascimento);
		
		email = new JLabel("Email");
		email.setBounds(10, 263, 79, 14);
		getContentPane().add(email);
		
		Telefone = new JLabel("Telefone");
		Telefone.setBounds(11, 301, 78, 14);
		getContentPane().add(Telefone);
		
		nomeClienteField = new JTextField();
		nomeClienteField.setBounds(109, 91, 128, 20);
		getContentPane().add(nomeClienteField);
		nomeClienteField.setColumns(10);
		
		sobrenomeClienteField = new JTextField();
		sobrenomeClienteField.setBounds(109, 130, 128, 20);
		getContentPane().add(sobrenomeClienteField);
		sobrenomeClienteField.setColumns(10);
		
		CPFField = new JTextField();
		CPFField.setBounds(109, 176, 128, 20);
		getContentPane().add(CPFField);
		CPFField.setColumns(10);
		
		nascimentoField = new JTextField();
		nascimentoField.setBounds(109, 218, 128, 20);
		getContentPane().add(nascimentoField);
		nascimentoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(109, 260, 128, 20);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		telefoneField = new JTextField();
		telefoneField.setBounds(109, 298, 128, 20);
		getContentPane().add(telefoneField);
		telefoneField.setColumns(10);
		
		CPFClientePesq = new JLabel("CPF Cliente");
		CPFClientePesq.setBounds(284, 14, 79, 14);
		getContentPane().add(CPFClientePesq);
		
		CPFClientePesqField = new JTextField();
		CPFClientePesqField.setColumns(10);
		CPFClientePesqField.setBounds(363, 11, 148, 20);
		getContentPane().add(CPFClientePesqField);
		
		modificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf=CPFClientePesqField.getText();
				pesquisar(cpf);
				aceitar.setVisible(true);
				CPFClientePesqField.setText("");
				
			}
		});
		modificar.setBounds(412, 39, 99, 23);
		getContentPane().add(modificar);
		
		
		searchField = new JTextField("CPF ou Nome");
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==searchField){
					String entree=searchField.getText();
					pesquisar(entree);
				}
			}
		});
		searchField.setBounds(595, 11, 156, 23);
		searchField.setColumns(10);
		getContentPane().add(searchField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 90,539,57);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(34);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "Nome", "Sobrenome", "Data nascimento", "Email", "Telefone"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		Dimension d = table.getPreferredSize();
		table.setPreferredScrollableViewportSize(d);
		
		aceitar.setFont(new Font("Tahoma", Font.BOLD, 12));
		aceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Object source=evt.getSource();
				if(source==aceitar){
					String []tabContenu=new String[6];
					for(int i=0;i<table.getColumnCount();i++){
						Object valeur=table.getValueAt(0,i) ;
						String contenu=valeur.toString();
						tabContenu[i]=contenu;	
					}
					cliente.modificarCliente(tabContenu);
				}
			}
		});
		aceitar.setBounds(383, 154, 227, 23);
		aceitar.setVisible(false);
		getContentPane().add(aceitar);
		
		Timer t = new Timer(1000, new ClockListener());
        t.start();
       	
	}
	 class ClockListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
             relogio.setText(df.format(Calendar.getInstance().getTime()));
         }
     }
	class Panneau extends JPanel{
		public void paintComponent(Graphics g){
			try {
				super.paintComponents(g);
				Graphics2D g2d = (Graphics2D)g;
				Image image_ecran = ImageIO.read(new File("backGround.jpg"));
				g2d.drawImage(image_ecran, 0, 0,this.getWidth(),this.getHeight(),this);
				Color Snow3 =new Color(205,201,201);
				g2d.setColor(Snow3);
				g2d.fillRoundRect(3,87,240,280,15,15);
				
				g2d.setColor(Snow3);
				g2d.fillRoundRect(280,7,240,60,15,15);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void pesquisar(String entree){
		try{
			table.setModel(cliente.pesquisar(entree));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
