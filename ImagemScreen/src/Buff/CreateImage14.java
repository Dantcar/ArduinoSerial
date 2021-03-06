/*
 * Flip the image vertically and horizontally, 
 * equivalent to rotating the image 180 degrees : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage14 {
    public static void main(String[] argv) throws Exception {
    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);

    AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
    tx.translate(-bufferedImage.getWidth(null), -bufferedImage.getHeight(null));
    AffineTransformOp op = new AffineTransformOp(tx,
        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    bufferedImage = op.filter(bufferedImage, null);

  }
}
