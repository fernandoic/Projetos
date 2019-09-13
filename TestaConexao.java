package DaoGrafana;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class TestaConexao {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionFactory().getConexao();
            JOptionPane.showMessageDialog(null, "conexão aberta!!!");
        }
		
		

	}


