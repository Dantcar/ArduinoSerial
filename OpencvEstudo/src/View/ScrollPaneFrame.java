/**
 * Sao Paulo 20-12-2017
 * Class ScrollPaneFrame.java
 * LearnigJava - cap.17
 * To hold the image, we have used a JLabel and ImageIcon.
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author decio_000
 */
public class ScrollPaneFrame {
    
    public static void main (String[] args){
        String filename = "D:\\images\\teste4.png";
        
        if (args.length > 0){
            filename = args[0];
        }
        
        //montando as telas
        JFrame frame = new JFrame("ScrollPaneFrame v1.0");
        JLabel image = new JLabel( new ImageIcon(filename));
        frame.getContentPane().add( new JScrollPane(image));
        
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }//final main
    
}//final classe ScrollPaneFrame
