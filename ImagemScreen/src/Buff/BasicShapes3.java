/**
 * use only if the component is visible on the screen. 
 * It returns buffered images that do not support transparent pixels.
 */

package Buff;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author decio_000
 */
public class BasicShapes3 {
    public static void main(String[] argv) throws Exception {

    JFrame f = new JFrame();
    f.setVisible(true);
    int width = 300;
    int height = 500;
    BufferedImage bimage = (BufferedImage) f.createImage(width, height);
    if (bimage == null) {
      System.out.println("component is not visible on the screen");
    }
  }
}
