/*
 * Create Gradient Mask : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.SwingConstants;

/**
 *
 * @author decio_000
 */
public class CreateImage17 {
    public static BufferedImage createGradientMask(int width, int height, int orientation) {
    // algorithm derived from Romain Guy's blog
    BufferedImage gradient = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = gradient.createGraphics();
    GradientPaint paint = new GradientPaint(0.0f, 0.0f,
            new Color(1.0f, 1.0f, 1.0f, 1.0f),
            orientation == SwingConstants.HORIZONTAL? width : 0.0f, 
            orientation == SwingConstants.VERTICAL? height : 0.0f,
            new Color(1.0f, 1.0f, 1.0f, 0.0f));
    g.setPaint(paint);
    g.fill(new Rectangle2D.Double(0, 0, width, height));

    g.dispose();
    gradient.flush();

    return gradient;
}
    
}
