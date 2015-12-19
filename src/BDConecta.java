import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class BDConecta {
	
	private static Connection connexion=null;
	private static String url ="jdbc:mysql://localhost:3306/";
	private static String dbName ="database";
	private static String driver="com.mysql.jdbc.Driver";
	private static String userName="root";
	private static String password ="";

	public DadosCliente RecuperaCliente(int ID) {
		return null;		
	}
	
	public void ApagaCliente(int ID) {
		
	}
	public void AtualizaCliente(DadosCliente cliente){
		
	}

	public BDConecta(String arquivo) {
		super();
		
	}
	public static void connect(){
		try {
          
            Class.forName(driver);
            connexion= DriverManager.getConnection(url + dbName, userName, password);
		}
		catch(Exception e){
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "Mount DB and Try","Cuidado", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public static void discconnect(){
		try{
			Class.forName(driver);
			connexion.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Log out impossible","Cuidado", JOptionPane.ERROR_MESSAGE);
		}
    }
	
	public static Connection getConnexion() {
		return connexion;
	}
}
