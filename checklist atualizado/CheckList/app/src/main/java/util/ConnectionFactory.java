package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/**

 */
public class ConnectionFactory {
    
	public ConnectionFactory() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/todoapp";
			
			return;
			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
  /*  public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "admin"; */
    
  /*  public static java.sql.Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }*/
    
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
    }
    
    public static void main (String[] args) {
		try	{
			@SuppressWarnings("unused")
			Connection conn = ConnectionFactory.getConnection();
			JOptionPane.showMessageDialog(null, "DB Conectado");
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void closeConnection(Connection conn, PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}
}
	
