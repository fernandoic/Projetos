/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteGrafico;
import static TesteGrafico.Grafico.GerarGrafico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author SempreIT
 */
public class Grafico {
   


   public static void  GerarGrafico(String timeStamp,String elapsed,String label,String responseCode ) {
        
        
        JOptionPane.showMessageDialog(null,"Gerando grafico...");
        
        String timeStamp2=timeStamp;
        String elapsed2=elapsed;
        String label2=label;
        String responseCode2=responseCode;        
        // Cria uma tela com uma panel vazia dentro. Usa esta panel para definir
        // o tamanho mínimo e preferencial da janela.
        JFrame frame = new JFrame("Grafico de Pizza");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel raiz = new JPanel();
        raiz.setLayout(new BorderLayout());
        Dimension tamanho = new Dimension(900, 480);
        raiz.setPreferredSize(tamanho);
        raiz.setMinimumSize(tamanho);
        frame.add(raiz);
        frame.pack();
        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((sd.width - frame.getWidth()) / 2, (sd.height - frame.getHeight()) / 2);

        // Cria o painel aonde o gráfico será mostrado.
        JPanel primeiroGrafico = new JPanel();
        Dimension tamanhoArea = new Dimension(900, 450);
        primeiroGrafico.setPreferredSize(tamanhoArea);
        primeiroGrafico.setMinimumSize(tamanhoArea);
        raiz.add(primeiroGrafico, BorderLayout.CENTER);

        // Cria o botão.
       /* JPanel areaBotoes = new JPanel();
        JButton botao = new JButton("Criar gráfico");
        areaBotoes.add(botao);
        raiz.add(areaBotoes, BorderLayout.SOUTH);
*/
        // Define o que acontece ao clicar no botão.
       // botao.addActionListener(e -> {
     //   JOptionPane.showMessageDialog(null, " Gerando grafico...");
            DefaultPieDataset dpd = new DefaultPieDataset();
            
            dpd.setValue(timeStamp2, 10);
            dpd.setValue(elapsed2, 20);
            dpd.setValue(label, 30);
            dpd.setValue(responseCode, 40);

            //JFreeChart grafico = ChartFactory.createPieChart3D("Testes Performance", dpd, true, true, true);
            JFreeChart grafico = ChartFactory.createLineChart(timeStamp2, elapsed2, label, null);
            ChartPanel chartPanel = new ChartPanel(grafico);
            primeiroGrafico.add(chartPanel);
            primeiroGrafico.validate();
       // });

        // Mostra a tela.
        frame.setVisible(true);
   //     return null;
    }
}

