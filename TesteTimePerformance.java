/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetimeperformance;
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

/**
 *
 * @author SempreIT
 */
public class TesteTimePerformance {



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


/*IMPORTA OS PEDIDOS, CASO TIVER ALGUM PEDIDO COM 
MAIS DE UMA PERSONALIZAÇÃO ELE CRIA OUTRO PEDIDO COM O FINAL "C".
*/

public static void main(String[] args) throws IOException, InterruptedException, NullPointerException, ParseException,ArrayIndexOutOfBoundsException {

        

    
    
/*
FileFilter filter = new FileFilter() {   
            @Override
    public boolean accept(File file) {   
        return file.getName().endsWith(".csv");   
    }   
};  
*/
  
    /*
     Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(timestamp.getTime());

        
        
        // S is the millisecond
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm");

        JOptionPane.showMessageDialog(null,"Data TimeSTAMP : "+simpleDateFormat.format(data));
        JOptionPane.showMessageDialog(null,"Data  : "+simpleDateFormat.format(data));
*/
    
      // long =1565354967958L;

      
      
        //  JOptionPane.showMessageDialog(null,"Data : " );
         
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
      
   JOptionPane.showMessageDialog(null,"FORMATO DO ARQUIVO INVALIDO!\nFAVOR SELECIONAR UM ARQUIVO .CSV ...");
    
    System.exit(0);
    
  }
  
 
  
  
  
  
      

System.out.println("ABRINDO NA PASTA..." + abreArquivoEscolhido);


//String Caminho= "/home/fernando-rnl/NetBeansProjects/RNL/src/ATUALIZA_STATUS_PEDIDO_PANILHA/25-09-2017_ANTES_ALTERAR_EXPEDIDO.csv";
    
    FileReader arquivo=new FileReader(abreArquivoEscolhido);
    
    
// BufferedReader in=new BufferedReader(arquivo);



System.out.println( "VERIFICANDO ARQUIVO : " + abreArquivoEscolhido + " ...");
        //  System.out.println("VERIFICANDO ARQUIVO : " + arquivos[i].getName() + " ...");
    

    
 
        FileReader file =new FileReader(abreArquivoEscolhido);

        BufferedReader in=new BufferedReader(file);
        
     
                      
     JOptionPane.showMessageDialog(null, "FAVOR SELECIONAR O LOCAL PARA SALVAR OS ARQUIVOS CONVERTIDOS...");
           JFileChooser salvandoArquivo = new JFileChooser();  
    int resultado2 = salvandoArquivo.showSaveDialog(null);  
    if (resultado2 != JFileChooser.APPROVE_OPTION) {
       
         
        return;  
    }  
     
     
  File salvarArquivoEscolhido = salvandoArquivo.getSelectedFile();  

//JOptionPane.showMessageDialog(null,"SALVANDO NA PASTA..." + salvarArquivoEscolhido);
// String caminho;
    //caminho=JOptionPane.showInputDialog(null,"DIGITE O CAMINHO PARA SALVAR OS ARQUIVOS DE CLIENTES APCD \n FAVOR ADICIONAR O CAMINHO NO SEGUINTE FORMATO EX:/DIRETORIO/DIRETORIO2/");

    
    
        if(salvandoArquivo==null){
        
        JOptionPane.showMessageDialog(null,"FECHANDO...");
        System.exit(0);
        
    }
        
            
    if(salvandoArquivo.equals("")){
        
        JOptionPane.showMessageDialog(null,"CAMINHO DIGITADO INCORRETO! FECHANDO PROGRAMA...");
        System.exit(0);
        
    }
    
    
    String nome=salvarArquivoEscolhido.toString();
    String nome_arquivo=nome.replace(".csv", "_");
      //  JOptionPane.showMessageDialog(null,nome_arquivo);

      //  String nome_arquivo=salvarArquivoEscolhido.getName().replaceAll(".csv", "_");
           FileOutputStream out =new FileOutputStream(nome_arquivo+"SAIDA_ARQUIVO.csv",true);
   //FileOutputStream out =new FileOutputStream("SAIDA_ARQUIVO.csv",true);
 
    //  FileOutputStream out2 =new FileOutputStream(salvarArquivoEscolhido +"RESULTADO_IMPORTACAO_PEDIDOS_ERROS.txt",true);
 
        
         OutputStreamWriter objOut=new OutputStreamWriter(out);
        
        
        
  
 while(in.ready()){
       totallinhas++;//CONTA TOTAL DE LINHAS
     /*
              JFrame f = new JFrame("IMPORTAÇÃO DE PEDIDOS");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = f.getContentPane();
		JProgressBar progressBar = new JProgressBar();
		JLabel label = new JLabel();
                */
                 
     if(totallinhas==1){
objOut.write("timeStamp" + ","+"Data" +"," +"Hora" +"," + "elapsed" + "," +"Segundos" +"," +"Legendas" +","+ "label1" + "," + "responseCode" + "," + "responseMessage" + "," + "threadName" + "," + "dataType" + "," + "success" + "," + "failureMessage" + "," + "bytes" + "," + "sentBytes" + "," + "grpThreads" + ","+"Steps" +"," + "allThreads" + "," + "URL" + "," + "Latency" + "," + "SampleCount" + "," + "ErrorCount" + "," + "IdleTime" + "," + "Connect\n" );
     }
		
     for (int i = 1; i <= totallinhas; i++) {
     
     
     
     
     
    // OutputStreamWriter objOut=new OutputStreamWriter(out);
     
     
     /*
         System.out.println("total é : " + totallinhas);
     
     if(totallinhas>1){
         
         System.out.println("total é : " + totallinhas);
         
     }
       */
  

    // teste=0;
    

     str=in.readLine();
     
   
      if(totallinhas>1){
          
try{
          
        /*
           str=str+";1";
           
           
          System.out.println("LINHA COMPLETA ADICIONANDO (;1)\n" +str);
          
             if(str.equals("null;1")){
       
                 
                 break;
              
          }    
*/
    
            
        virgula =  str.replaceAll("r,", "r").split(",");
 
         
  

                //CAMPOS CLIENTES 
 try{
             //CAMPOS PLANILHA
            String timeStamp=virgula[0];
            String elapsed=virgula[1];
            String label1=virgula[2];
            String responseCode=virgula[3];
            String responseMessage=virgula[4];
            String threadName=virgula[5];
            String dataType=virgula[6];
            String success=virgula[7];
            String failureMessage=virgula[8];
            String bytes=virgula[9];            
            String sentBytes=virgula[10];
            String grpThreads=virgula[11];
            String allThreads=virgula[12];
            String URL=virgula[13];
            String Latency=virgula[14];
            String SampleCount=virgula[15];
            String ErrorCount=virgula[16];             
            String IdleTime=virgula[17];
           
            String Connect=virgula[18];   
           
            String dataType2="";
            String failureMessage2="";
            // JOptionPane.showMessageDialog(null, "DATA ORIGINAL : " + timeStamp);
            
            
            long timeStamp2 =Long.parseUnsignedLong(timeStamp);
                  //  long Milissegundos = 1565099973600L;// "L" no final do long quando for muito grande
           // long= String.valueOf(timeStamp);
   Date date = new Date(timeStamp2); 
   //Formatar para o padrão data hora minuto segundo
   SimpleDateFormat jdf_original = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//Formatar para o fuso horario correto , no caso Brasilia -03:00
   jdf_original.setTimeZone(TimeZone.getTimeZone("GMT-3"));
//Termina de formatar
   String java_date_original = jdf_original.format(date);
   
   
   
      SimpleDateFormat jdf_data = new SimpleDateFormat("dd/MM/yyyy");
   jdf_data.setTimeZone(TimeZone.getTimeZone("GMT-3"));
   String java_date = jdf_data.format(date);
   
   
      SimpleDateFormat jdf_minutos = new SimpleDateFormat("HH:mm");
   jdf_minutos.setTimeZone(TimeZone.getTimeZone("GMT-3"));
   String java_date_minutos = jdf_minutos.format(date);
 
   
      //  JOptionPane.showMessageDialog(null, "DATA ORIGINAL : " + java_date_original + "\nDATA FORMATADA: " + java_date+  "\nMINUTOS FORMATADO: " + java_date_minutos   );
    
            
            
            
            
            
     
       
            
            
            System.out.println("Dados" +str);
            

     //Inicio Calculo Segundos
            float segundos=0;
           segundos = Float.parseFloat(elapsed)/1000;

    //Fim Calculo Segundos
           
           
           
           //Inicio condições legenda
           
        //Formula Excel   =SE(E2 <=1;"≤ 1.0s";SE(E2 <=1,5;"≤ 1.5s";SE(E2 <=2;"≤ 2.0s";SE(E2 >2;"> 2.0s";"> 2.0"))))
           String legenda="N";
           String MI1="<=1.0s";
           String MI1E5="<=1.5s";
           String MI2="<=2.0s";
           String M2=">2.0s";
           
           
            if(segundos<=1.000){
                
               legenda=MI1;
           }
            if(segundos>=1.000&&segundos<=1.500){

               legenda=MI1E5;
           }
            if(segundos>=1.500&&segundos<=2.000){

               legenda=MI2;
           }                    
            if(segundos>2.000){
  
               legenda=M2;
           }

           //Fim condições legenda
           
            //INICIO CONDIÇÕES STEPS
//=SE(P2<=2;"4";SE(P2<=10;"20";SE(P2<=30;"60";SE(P2<=50;"100";SE(P2<=100;"200";SE(P2<=150;"300";SE(P2<=250;"500";SE(P2<=350;"700";"1000"))))))))
                int step=0;    
              /*  int step4=0;
                int step20=0;
                int step60=0;
                int step100=0;
                int step200=0;
                int step300=0;
                int step500=0;
                int step700=0;
                */
             
                //JOptionPane.showMessageDialog(null, "DATAMILES:"+ timeStamp);
              //  JOptionPane.showMessageDialog(null, "dataType ANTES:"+ dataType + "E : " +virgula[7]);
              //  JOptionPane.showMessageDialog(null, "failureMessage ANTES:"+failureMessage + "E : " +virgula[9]);
              //  JOptionPane.showMessageDialog(null, "dataType ANTES:"+ virgula[7]);
                //JOptionPane.showMessageDialog(null, "failureMessage ANTES:"+virgula[9]);
                    
if(dataType.equals("")){
    
  //  JOptionPane.showMessageDialog(null, "DataType Vazio!");
   // dataType2=String.valueOf(dataType);
    dataType="Vazio";
    
}    
    
if(failureMessage.equals("")){
    
  
   // JOptionPane.showMessageDialog(null, "failureMessage Vazio! NA LINHA :"+ totallinhas);
   // failureMessage2= String.valueOf(failureMessage);
    failureMessage="VAZIO";
    
    //JOptionPane.showMessageDialog(null, "failureMessage 100% convertido para"+ failureMessage2);
}    


//JOptionPane.showMessageDialog(null, "dataType ANTES:"+ dataType);
  //              JOptionPane.showMessageDialog(null, "failureMessage ANTES:"+failureMessage);
    if(Integer.parseInt(allThreads)<=2){
                    step=4;
                }
    if(Integer.parseInt(allThreads)>=2&&Integer.parseInt(allThreads)<=10){
                    step=20;
                }                
    if(Integer.parseInt(allThreads)>=10&&Integer.parseInt(allThreads)<=30){
                    step=60;
                }               
    if(Integer.parseInt(allThreads)>=30&&Integer.parseInt(allThreads)<=50){
                    step=100;
                }                
    if(Integer.parseInt(allThreads)>=50&&Integer.parseInt(allThreads)<=100){
                    step=200;
                }                
    if(Integer.parseInt(allThreads)>=100&&Integer.parseInt(allThreads)<=150){
                    step=300;
                }                
    if(Integer.parseInt(allThreads)>=150&&Integer.parseInt(allThreads)<=250){
                    step=500;
                }
    if(Integer.parseInt(allThreads)>=250&&Integer.parseInt(allThreads)<=350){
                    step=700;
                }    
    if(Integer.parseInt(allThreads)>350){
                    step=700;
                }  
    //FIM CONDIÇÕES STEPS
    

   //  JOptionPane.showMessageDialog(null,"Dados" + virgula[4]);
         objOut.write(timeStamp + ","+ java_date +"," + java_date_minutos  +"," + elapsed + ","+ segundos + "," + legenda + "," + label1 + "," + responseCode + "," + responseMessage + "," + threadName + "," + dataType + "," + success + "," + failureMessage + "," + bytes + "," + sentBytes + "," + grpThreads + "," +step+ "," + allThreads + "," + URL + "," + Latency + "," + SampleCount + "," + ErrorCount + "," + IdleTime + "," + Connect + "\n" );


 }catch(ArrayIndexOutOfBoundsException e){
                
            }

//JOptionPane.showMessageDialog(null, "dataType DEPOIS:"+ dataType);
              //  JOptionPane.showMessageDialog(null, "failureMessage DEPOIS:"+failureMessage);
              // JOptionPane.showMessageDialog(null, "failureMessage recebendo Vazio antes da inserção! valor:"+ failureMessage2);
           //     JOptionPane.showMessageDialog(null, "failureMessage recebendo Vazio depois da inserção! valor:"+ failureMessage);
       
   //  JOptionPane.showMessageDialog(null,"Dados" + str);
}catch(NullPointerException e)
        {
            
         //Grafico.GerarGrafico();
            
        
         //dados_grafico.GerarGrafico( virgula[0],virgula[1]);
          //  JOptionPane.showMessageDialog(null,"Importação finalizada!!!");
           // break;
         //  System.exit(0);
        }

                        }
      
                                                }
     
   
 

     
                    }
    objOut.close();
    out.close();
  Grafico.GerarGrafico(virgula[0],virgula[1], virgula[3], virgula[4]);
                                                                                }
}