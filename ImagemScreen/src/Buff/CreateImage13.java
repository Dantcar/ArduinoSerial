/*
 * Flip the image horizontally : 
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
public class CreateImage13 {
    public static void main(String[] argv) throws Exception {
    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);

    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
    tx.translate(-bufferedImage.getWidth(null), 0);
    AffineTransformOp op = new AffineTransformOp(tx,
        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    bufferedImage = op.filter(bufferedImage, null);
  }
}
