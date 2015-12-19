import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestaoBDCliente {
	String query;
	Statement statement;
	ResultSet rset;
	Connection connexion;
	
	public GestaoBDCliente(){
		BDConecta.connect();
		connexion=BDConecta.getConnexion();
		rset=null;
	}
	
	public DefaultTableModel pesquisar(String entree){
		
		DefaultTableModel dt = new DefaultTableModel();
		
		try{
			dt.addColumn("CPF");
			dt.addColumn("Nome");
			dt.addColumn("Sobrenome");
			dt.addColumn("Data nasci");
			dt.addColumn("Email");
			dt.addColumn("Telefone");
			String[] tab=entree.split(" ");
			statement=connexion.createStatement();
			
			for(int i=0,longeur=tab.length;i<longeur;i++){
				query="SELECT * FROM ajout WHERE CPFCliente='"+tab[i]+"' OR nomeCliente='"+tab[i]+"' OR sobrenomeCliente='"+tab[i]+"'";
				rset=statement.executeQuery(query);
			}
			
			while(rset.next()){
				Object []tableau={rset.getString("CPFCliente"),rset.getString("nomeCliente"),rset.getString("prenomCliente"),
						rset.getString("nascimentoCliente"),rset.getString("emailCliente"),rset.getString("telefoneCliente")};
				dt.addRow(tableau);
				
				
			}
			
			
		}
		
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Cuidado",JOptionPane.ERROR_MESSAGE);	
		}	
		return dt;
	}
	
	
}
