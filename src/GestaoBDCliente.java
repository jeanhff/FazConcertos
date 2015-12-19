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
	
	public DefaultTableModel pesquisar(String pequisa){
		
		DefaultTableModel dt = new DefaultTableModel();
		
		try{
			dt.addColumn("CPF");
			dt.addColumn("Nome");
			dt.addColumn("Sobrenome");
			dt.addColumn("Data nasci");
			dt.addColumn("Email");
			dt.addColumn("Telefone");
			String[] tab=pequisa.split(" ");
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
	
	public void addCliente(String cin,String nom,String prenom,String naissance,String email,String telefone){
		try{
			statement=connexion.createStatement();
			query="INSERT INTO ajout  VALUES('"+cin+"','"+nom+"','"+prenom+"','"+naissance+"','"+email+"','"+telefone+"')";
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Successfull Add","Cuidado",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR ADD INTO DB","Cuidado",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void apagarCliente(String cpf){
		try{			
			statement=connexion.createStatement();
			query="DELETE FROM ajout WHERE CPFCliente='"+cpf+"'";
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Successfull DELETE","Cuidado",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR","Cuidado",JOptionPane.ERROR_MESSAGE);		
		}
	}
	
	public void modificarCliente(String[] contenu){
		try{
			statement=connexion.createStatement();
			query="UPDATE ajout SET nomeCliente='"+contenu[1]+"',sobrenomeCliente='"+contenu[2]+"' ,nascimentoCliente='"+contenu[3]+"',emailCliente='"+contenu[4]+"',telefoneCliente='"+contenu[5]+"'WHERE CPFCliente='"+contenu[0]+"'";
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Successfull ALTER","Cuidado",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"ERROR","Cuidado",JOptionPane.ERROR_MESSAGE);		
		}
	}
	
	public boolean verificar(String login,String password){
		boolean test=false;
		String log = null,pass=null;
		try{
			statement=connexion.createStatement();
			query="SELECT login,password FROM empregado";
			rset=statement.executeQuery(query);
			while(rset.next()|| (test==true)){
				log=rset.getString("login");
				pass=rset.getString("password");
				if(log.equals(login) && pass.equals(password))
					test=true;		
			}
		}
		catch(SQLException ex){			
		}
		return test;

	}
}
