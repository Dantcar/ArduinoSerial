/*
 * Create an image that supports arbitrary levels of transparency : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author decio_000
 */
public class BasicShapes2 extends JPanel{
    public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    int width = 100;
    int height = 100;

    BufferedImage bimage = g2d.getDeviceConfiguration().createCompatibleImage(
        width, height, Transparency.TRANSLUCENT);

  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Basic Shapes");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new BasicShapes());
    frame.setSize(350, 250);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
