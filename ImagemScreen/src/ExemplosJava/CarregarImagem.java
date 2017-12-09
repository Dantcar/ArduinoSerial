

package ExemplosJava;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class CarregarImagem extends Component {
          
    BufferedImage img;
    String sfile;
    
    public static void montarTela(String sfile){
    JFrame f = new JFrame("Imagem Carregada: " + sfile);
            
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        f.add(new CarregarImagem(sfile));
        f.pack();
        f.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public CarregarImagem(String cfile) {
        
       try {
           img = ImageIO.read(new File(cfile));
       } catch (IOException e) {
       }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

    public static void main(String[] args) {
        
        CarregarImagem.montarTela("D://images//AFoto18.png");
    }
    
} //final CarregarImagem

