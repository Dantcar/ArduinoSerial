/**
 * Praia Grande 30-12-2017
 * Class BuffToImage.java
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
package ImageJava;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author decio_000
 */
public class BuffToImage {
    
    public static void main(String[] argv) throws Exception {
    BufferedImage img = toBufferedImage(new ImageIcon("D:\\images\\1sol.png").getImage());
  }
   
    /**
     * Metodo transforma Image em BufferedImage
     * @param image
     * @return 
     */
    public static BufferedImage toBufferedImage(Image image) {
    image = new ImageIcon(image).getImage();

    BufferedImage bimage = new BufferedImage(image.getWidth(null), image
        .getHeight(null), BufferedImage.TYPE_INT_ARGB);

    Graphics g = bimage.createGraphics();

    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bimage;
  }//final metodo toBufferedImage
    
}//final Classe BuffToImage
