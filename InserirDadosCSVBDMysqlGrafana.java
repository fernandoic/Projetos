/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MysqlGrafana;


import java.sql.Timestamp;    
import java.util.Date;  
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DecimalFormat; 
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import TesteGrafico.Grafico;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import DaoGrafana.LogDAO;
import java.sql.SQLException;
/**
 *
 * @author SempreIT
 */
public class InserirDadosCSVBDMysqlGrafana {

private static int contador=0;
private static String id_pedido_cliente_barra_progresso="";
private static int totallinhas=0;
private static int numero_pedido=0;
private static String str;
private static String[] virgula;
private static int contaencontrados=0;
public static int teste;
public static int pedido_encontrado=0;
public static int pedido_c_encontrado=0;



public static int prosseguir_inclusao_item=0;



public static void main(String[] args) throws IOException, InterruptedException, NullPointerException, ParseException,ArrayIndexOutOfBoundsException, SQLException, ClassNotFoundException, NumberFormatException {

LogDAO inserir=new LogDAO();

         
 System.out.println("ABRINDO CAMINHO DO ARQUIVO...");
    
    
  
  	
  
    JFileChooser abrindoArquivo = new JFileChooser();  
    int resultado = abrindoArquivo.showOpenDialog(null);  
    if (resultado != JFileChooser.APPROVE_OPTION){
       
         
        return;  
    }  
    

  File abreArquivoEscolhido = abrindoArquivo.getSelectedFile();  
  
int arquivo_valido=0;
  
  if(abreArquivoEscolhido.getName().contains(".csv")||abreArquivoEscolhido.getName().contains(".CSV")||abreArquivoEscolhido.getName().contains(".Csv")||abreArquivoEscolhido.getName().contains(".CsV")||abreArquivoEscolhido.getName().contains(".cSV")||abreArquivoEscolhido.getName().contains(".CSv")||abreArquivoEscolhido.getName().contains(".csV")){
      
      System.out.println("OK ARQUIVO VALIDO!");
   arquivo_valido=1;
  }
  
  if(arquivo_valido==0){
      
   System.out.println("FORMATO DO ARQUIVO INVALIDO!\nFAVOR SELECIONAR UM ARQUIVO .CSV ...");
    
    System.exit(0);
    
  }
  
 
  
  
  
  
      

System.out.println("ABRINDO NA PASTA..." + abreArquivoEscolhido);
  
    FileReader arquivo=new FileReader(abreArquivoEscolhido);
    



System.out.println( "VERIFICANDO ARQUIVO : " + abreArquivoEscolhido + " ...");
        //  System.out.println("VERIFICANDO ARQUIVO : " + arquivos[i].getName() + " ...");
    

    
 
        FileReader file =new FileReader(abreArquivoEscolhido);

        BufferedReader in=new BufferedReader(file);

 while(in.ready()){
       totallinhas++;//CONTA TOTAL DE LINHAS
	
     for (int i = 0; i <= totallinhas; i++) {
     
  
    

     str=in.readLine();
     
   
      if(totallinhas>=1){
          
try{
          

            
        virgula =  str.concat(";1").replaceAll(",", ".").split(";");
 
         
  

                //CAMPOS CLIENTES 
 try{
             //CAMPOS PLANILHA
            String funcional=virgula[0];
            String gerencia=virgula[1];
            String colaborador=virgula[2];
            String comunidade=virgula[3];
            String squad=virgula[4];
            String numero_solicitacao=virgula[5];
            String PR=virgula[6];
            String status_solicitacao=virgula[7];
            String billables=virgula[8];
            String elegeveis=virgula[9];            
            String um=virgula[10];
            String dois=virgula[11];
            String tres=virgula[12];
            String quatro=virgula[13];
            String cinco=virgula[14];
            String seis=virgula[15];
            String sete=virgula[16];             
            String oito=virgula[17];
            String nove=virgula[18];
            String dez=virgula[19];
            String onze=virgula[20];
            String doze=virgula[21];
            
            
                        if(um.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                um="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + um);

           
                       if(dois.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                dois="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + dois);

           
                       if(tres.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                tres="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + tres);

           
                       if(quatro.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                quatro="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + quatro);

           
                       if(cinco.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                cinco="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + cinco);

           
                       if(seis.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                seis="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + seis);

           
                       if(sete.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                sete="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + sete);

           
                       if(oito.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                oito="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + oito);

           
                       if(nove.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                nove="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + nove);

           
                       if(dez.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                dez="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + dez);

           
                       if(onze.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                onze="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + onze);

            if(doze.equals("")){
                
                System.out.println("Campo vazio! Alterando para zero...");
                doze="0.00";
            }
           System.out.println(gerencia+" Campo 21 щ :"  + doze);


            System.out.println("Dados : " + virgula[10]);
             System.out.println("Dados : " + virgula[12]);
            System.out.println("Dados : " +str);

try{
    
    


    
    inserir.inserirArquivoCarregado(Integer.parseInt(funcional),gerencia,colaborador,comunidade,squad,numero_solicitacao,PR,status_solicitacao,billables,elegeveis,Float.parseFloat(um),Float.parseFloat(dois),Float.parseFloat(tres),Float.parseFloat(quatro),Float.parseFloat(cinco),Float.parseFloat(seis),Float.parseFloat(sete),Float.parseFloat(oito),Float.parseFloat(nove),Float.parseFloat(dez),Float.parseFloat(onze),Float.parseFloat(doze));
contador++;
}catch(NumberFormatException e){
     
       // JOptionPane.showMessageDialog(null,"Campo vazio para converчуo!");
 }

 }catch(ArrayIndexOutOfBoundsException e){
                
            }


}catch(NullPointerException e)
        {

        }

                        }
      
                                                }
     
   
 

     
                    }

 JOptionPane.showMessageDialog(null,contador+ " Registros incluidos com sucesso!");
                                                                                }

}
    

