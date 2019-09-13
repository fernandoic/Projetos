package DaoGrafana;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	
	public Connection getConexao() throws ClassNotFoundException{
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/grafana","root","mysql");
			
		}catch (SQLException e){
			throw new RuntimeException("Erro 1 ERRO DE CONEXÃO!!!" + e);
			
		}
	}

}
