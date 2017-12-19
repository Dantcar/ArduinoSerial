/*
 * Creates and returns a buffered version of the specified image. : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage23 {
    /**
   * Creates and returns a buffered version of the specified image.
   *
   * @param image the image to create a buffered image for
   * @return a buffered image based on the specified image
   */
  public static BufferedImage getBufferedImage(Image image) {
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
        BufferedImage.TYPE_INT_ARGB);

    Graphics g = bufferedImage.getGraphics();

    g.drawImage(image, 0, 0, null);

    return bufferedImage;
  }
}
