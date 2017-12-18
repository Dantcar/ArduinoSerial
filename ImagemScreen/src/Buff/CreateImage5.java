/*
 * Creating a Buffered Image from an Image : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author decio_000
 */
public class CreateImage5 {
 public static void main(String[] argv) throws Exception {
    BufferedImage img = toBufferedImage(new ImageIcon("D:\\images\\1sol.png").getImage());
  }

  public static BufferedImage toBufferedImage(Image image) {
    image = new ImageIcon(image).getImage();

    BufferedImage bimage = new BufferedImage(image.getWidth(null), image
        .getHeight(null), BufferedImage.TYPE_INT_ARGB);

    Graphics g = bimage.createGraphics();

    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bimage;
  }   
    
}
