/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buff;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CreateImage {
     public static void main(String[] argv) throws Exception {
    Image  img = new ImageIcon("test.png").getImage();

    BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
    BufferedImage.TYPE_INT_RGB);

    Graphics g = bufferedImage.createGraphics();
    g.drawImage(img, 0, 0, null);
    g.dispose();

    ImageIO.write(bufferedImage, "png", new File("a.png"));
  }
}
