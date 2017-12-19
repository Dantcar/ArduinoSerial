/*
 * Converting a Colored Buffered Image to Gray : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */
package Buff;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

/**
 *
 * @author decio_000
 */
public class CreateImage15 {
    public static void main(String[] argv) throws Exception {

    ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
    ColorConvertOp op = new ColorConvertOp(cs, null);

    BufferedImage bufferedImage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);
    bufferedImage = op.filter(bufferedImage, null);
  }
}
