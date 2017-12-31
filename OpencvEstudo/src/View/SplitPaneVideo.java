/**
 * Praia Grande 30-12-2017
 * Class SplitPaneVideo.java
 * LearnigJava - cap.17
 * OpenCV estudo
 * To hold: uses two JLabels containing ImageIcons.
 * 
 * @author Decio A Carvalho
 * @serial 0.2
 * @since Dezembro-2017
 *
 * Retomada dos Estudos com manipulacao de imagens utilizando:
 * Java.awt.Graphcs2d, Java.awt.Graphics, Java.awt.image, Java.awt.Color,
 * Java.awt.Robot, Java.awt.geom, Java.io, Java.net, Java.util, Java.imageio,
 * Java.swing, Java.text, Java.awt.AWTException Java.awt.Rectangle,
 */
package View;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment.LEADING);
        
/**
 *
 * @author decio_000
 */
public class SplitPaneVideo {
    
    public static void main(String[] args){
        String fileOne = "D:\\images\\teste4.png";
        String fileTwo = "D:\\images\\novidade.png";
        if (args.length >0) fileOne = args[0];
        if (args.length >1) fileTwo = args[1];
        
        
        //Todas as bordas
        //Borda do painel
        Color bl = new Color(204, 23, 204);
        LineBorder lborderP = new LineBorder(bl,4);
         //Borda do painel
        Color bpb = new Color(10, 200, 200);
        LineBorder lborderPB = new LineBorder(bpb,4);
        //Borda do split
        Color bs = new Color(10, 230, 20);
        LineBorder lborderS = new LineBorder(bs,4);
        
        //Borda do leftImage
        Color bli = new Color(10, 10, 10);
        LineBorder lborderLI = new LineBorder(bli,4);
        
        //Borda do rightImage
        Color blir = new Color(10, 10, 10);
        LineBorder lborderRI = new LineBorder(blir,4);
        
        
        //Montagem do painel (Panel) principal
        
        JPanel jPanel = new javax.swing.JPanel();
        jPanel.setBorder(lborderP);
        
        JPanel jPanelBotoes = new javax.swing.JPanel();
        jPanelBotoes.setBorder(lborderPB);
        
        
        //JFrame frame principal
        JFrame frame = new JFrame("SplitPaneVideo v1.0");
        
        //JButton left
        JButton buttonLeft = new JButton();
        buttonLeft.setFont(new java.awt.Font("Arial", 1, 14));
        buttonLeft.setText("Escolher Imagem Esquerda");
        
        //JButton Right
        JButton buttonRight = new JButton();
        buttonRight.setFont(new java.awt.Font("Arial", 1, 14));
        buttonRight.setText("Escolher Imagem Direita");
        
        //Imagem da esquerda
        JLabel leftImage = new JLabel( new ImageIcon( fileOne));
        leftImage.setBorder(lborderLI);
        Component left = new JScrollPane(leftImage);
        
        //Imagem da direita
        JLabel rightImage = new JLabel( new ImageIcon( fileTwo));
        rightImage.setBorder(lborderRI);
        rightImage.setToolTipText("Imagems Carregada: " + fileTwo );
        
        Component right = new JScrollPane(rightImage);
        
        //Criacao do split
        JSplitPane split =
                new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, left, right);
        
        split.setDividerLocation(400);
        split.setBorder(lborderS);
        
        //Adicionando os componentes split e buttons ao jPanel
        jPanel.add(split);
        
        jPanelBotoes.add(buttonLeft);
        jPanelBotoes.add(buttonRight);
        jPanel.add(jPanelBotoes);
        //Adicionando o jPanel ao frame principal
        frame.getContentPane().add(jPanel);
        
        //frame.getContentPane().add(split);
        
        //configurando frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);  
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      
    }//final metodo main
    
}//final Classe SplitPaneVideo
