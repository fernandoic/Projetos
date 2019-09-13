
package DaoGrafana;
import MysqlGrafana.Dados;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Fernando
 */
public class LogDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Dados> lista=new ArrayList<>();
    
    public LogDAO() throws ClassNotFoundException{
        
        conn= new ConnectionFactory().getConexao();
    }

    
        public void inserirArquivoCarregado(int funcional,String gerencia,String colaborador,String comunidade,String squad,String numero_solicitacao,String PR,String status_solicitacao,String billables,String elegeveis,float um,float dois,float tres,float quatro,float cinco,float seis,float sete,float oito,float nove,float dez,float onze,float doze) throws SQLException{
        String sql="INSERT INTO grafana (time,funcional,gerencia,colaborador,comunidade,squad,numero_solicitacao,PR,status_solicitacao,billables,elegeveis,um,dois,tres,quatro,cinco,seis,sete,oito,nove,dez,onze,doze) values (null,'"+funcional+"','"+gerencia+"','"+colaborador+"','"+comunidade+"','"+squad+"','"+numero_solicitacao+"','"+PR+"','"+status_solicitacao+"','"+billables+"','"+elegeveis+"','"+um+"','"+dois+"','"+tres+"','"+quatro+"','"+cinco+"','"+seis+"','"+sete+"','"+oito+"','"+nove+"','"+dez+"','"+onze+"','"+doze+"')";
   

        try{
                    
        stmt=conn.prepareStatement(sql);
        stmt.execute();
        stmt.close();
            
            
        }catch (Exception e){
			
			throw new RuntimeException("Erro inserir Dados" +e);
		}

    }
   

}
