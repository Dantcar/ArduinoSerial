/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


/**
 *
 * @author decio_000
 */
public class HelloWordOPCV extends JPanel{

   private static Color fundo = new Color(200,200,200);

    public HelloWordOPCV() {        
        System.out.println("Library: " + Core.NATIVE_LIBRARY_NAME);
        System.out.println("Version: " + Core.VERSION);
        
        //Mat m = Mat.eye(3, 3, CvType.CV_16UC1); //nao funcionou
        //System.out.println("Content of the matriz m is:");
        //System.out.println(m.dump());
    
    }
    
    public void paint(Graphics g) {
    BufferedImage bimage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);
    Graphics2D g2d = bimage.createGraphics();

    Color transparent = new Color(0, 0, 0, 0);
    g2d.setColor(transparent);
    g2d.setComposite(AlphaComposite.Src);
    g2d.fill(new Rectangle2D.Float(20, 20, 100, 20));
    g2d.dispose();

  }
    
    public static void main(String[] args) {
    JFrame frame = new JFrame("HelloWord OpenCV");
    Icon icon = new ImageIcon("D://images//icon.png");
    JButton button = new JButton(icon);
    button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    button.setText("Apagar");
     button.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("Urp!");
            }
            
        });
     
    frame.setSize(640, 480);
    frame.getContentPane().add( button );
    frame.pack();
    frame.setBackground(fundo);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   
    frame.getContentPane().add( button );
    
   
    frame.add(new HelloWordOPCV());

    //frame.pack();
    frame.setVisible(true);
  }
}
