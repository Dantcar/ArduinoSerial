/**
 * Sao Paulo 20-12-2017
 * Class TabbedPaneFrame.java
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author decio_000
 */
public class TabbedPaneFrame {
    
    public static void main(String[] args){
        
        JFrame frame = new JFrame("TabbedPaneFrame v1.0");
        JTabbedPane tabby = new JTabbedPane();
        
        //create the controls pane
        JPanel controls = new JPanel();
        controls.add(new JLabel("Service:"));
        
        JList list = new JList(
            new String[] {"Web server", "FTP server"});
        
        list.setBorder(BorderFactory.createEtchedBorder());
        controls.add(list);
        controls.add(new JButton("Start"));
        
        //create an image pane
        String filename = "D:\\images\\teste4.png";
        
        JLabel image = new JLabel( new ImageIcon(filename));
        JComponent picture = new JScrollPane(image);
        
        tabby.addTab("Controls", controls);
        tabby.addTab("Picture", picture);
        
        frame.getContentPane().add(tabby);
        
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
    }//final metodo main
    
}//final classe TabbedPaneFrame
