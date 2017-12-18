/*
 * Getting and Setting Pixels in a Buffered Image : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage7 {
    public static void main(String[] argv) throws Exception {

    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_INT_RGB);

    int rgb = bufferedImage.getRGB(1, 1);

    int w = bufferedImage.getWidth(null);
    int h = bufferedImage.getHeight(null);
    int[] rgbs = new int[w * h];
    bufferedImage.getRGB(0, 0, w, h, rgbs, 0, w);

    rgb = 0xFF00FF00; // green
    bufferedImage.setRGB(1, 1, rgb);
  }
}
