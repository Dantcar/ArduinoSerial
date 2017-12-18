/*
 * Converting a Buffered Image (BufferedImage) from an Image : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage6 {
  public static void main(String[] argv) throws Exception {
    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_3BYTE_BGR);
    Image img = Toolkit.getDefaultToolkit().createImage(
        bufferedImage.getSource());
  } 
}
