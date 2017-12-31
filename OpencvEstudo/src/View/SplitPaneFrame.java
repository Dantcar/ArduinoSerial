/**
 * Sao Paulo 20-12-2017
 * Class SplitPaneFrame.java
 * LearnigJava - cap.17
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author decio_000
 */
public class SplitPaneFrame {
    
    public static void main(String[] args){
        String fileOne = "D:\\images\\teste4.png";
        String fileTwo = "D:\\images\\novidade.png";
        if (args.length >0) fileOne = args[0];
        if (args.length >1) fileTwo = args[1];
        
        JFrame frame = new JFrame("SplitPaneFrame v1.0");
        
        //Imagem da esquerda
        JLabel leftImage = new JLabel( new ImageIcon( fileOne));
        Component left = new JScrollPane(leftImage);
        
        //Imagem da direita
        JLabel rightImage = new JLabel( new ImageIcon( fileTwo));
        Component right = new JScrollPane(rightImage);
        
        //Criacao do split
        JSplitPane split =
                new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, left, right);
        
        split.setDividerLocation(100);
        frame.getContentPane().add(split);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        
    }//final metodo main
    
}//final classe SplitPaneFrame
