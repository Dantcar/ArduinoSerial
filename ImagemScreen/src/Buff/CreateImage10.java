/*
 * Translating a Buffered Image : 
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
public class CreateImage10 {
     public static void main(String[] argv) throws Exception {
    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);

    AffineTransform tx = new AffineTransform();
    tx.translate(2, 1);

    AffineTransformOp op = new AffineTransformOp(tx,
        AffineTransformOp.TYPE_BILINEAR);
    bufferedImage = op.filter(bufferedImage, null);
  }
}
