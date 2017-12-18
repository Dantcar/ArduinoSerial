/*
 * Create a buffered image that supports transparency :
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage4 {
     public static void main(String[] argv) throws Exception {
    int width = 100;
    int height = 100;
    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  }
}
