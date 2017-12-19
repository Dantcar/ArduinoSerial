/*
 * Produces a copy of the supplied image : 
 * BufferedImage « 2D Graphics « Java Tutorial
 */

/*
 *
 * Created on March 16, 2007, 4:34 PM
 *
 * Copyright 2006-2007 Nigel Hughes
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at http://www.apache.org/
 * licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package Buff;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author decio_000
 */
public class CreateImage21 {
     /**
   * Produces a copy of the supplied image
   *
   * @param image The original image
   * @return The new BufferedImage
   */
  public static BufferedImage copyImage(BufferedImage image){
      return scaledImage(image,image.getWidth(),image.getHeight());
  } 
  /**
   * Produces a resized image that is of the given dimensions
   *
   * @param image The original image
   * @param width The desired width
   * @param height The desired height
   * @return The new BufferedImage
   */
  public static BufferedImage scaledImage(BufferedImage image, int width, int height){
      BufferedImage newImage = createCompatibleImage(width,height);
      Graphics graphics = newImage.createGraphics();
      
      graphics.drawImage(image,0,0,width,height,null);
      
      graphics.dispose();
      return newImage;
  }
  /**
   * Creates an image compatible with the current display
   * 
   * @return A BufferedImage with the appropriate color model
   */
  public static BufferedImage createCompatibleImage(int width, int height) {
    GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getDefaultScreenDevice().getDefaultConfiguration();
    return configuration.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
  }
}
