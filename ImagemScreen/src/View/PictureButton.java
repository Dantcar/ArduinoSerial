/**
 * Sao Paulo 20-12-2017
 * Class PictureButton.java
 * LearnigJava - cap.17
 * 
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author decio_000
 */
public class PictureButton {
    
    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        Icon icon = new ImageIcon("D://images//icon.png");
        JButton button = new JButton(icon);
        
        button.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("Urp!");
            }
            
        });
        
        frame.getContentPane().add( button );
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//final metodo main
    
}//final classe PictureButton
