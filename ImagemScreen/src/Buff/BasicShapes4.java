/*
 * Drawing on a Buffered Image : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class BasicShapes4 {
    public static void main(String[] args) {
    BufferedImage bimage = new BufferedImage(200, 200,
    BufferedImage.TYPE_BYTE_INDEXED);

    Graphics2D g2d = bimage.createGraphics();

    g2d.setColor(Color.red);
    g2d.fill(new Ellipse2D.Float(0, 0, 200, 100));
    g2d.dispose();
  }
}
