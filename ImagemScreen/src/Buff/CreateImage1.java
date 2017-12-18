/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buff;

import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage1 {
    public static void main(String[] argv) throws Exception {

    int width = 100;
    int height = 100;

    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

  }
}
