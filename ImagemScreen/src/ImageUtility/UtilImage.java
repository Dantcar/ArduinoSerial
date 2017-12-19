/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageUtility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author decio_000
 */


public class UtilImage {

    
    /**
     * Metodo loadImage
     * @param ref
     * @return 
     */
    public static BufferedImage loadImage(String ref){
        BufferedImage bimg = null;
        try{
          bimg = ImageIO.read(new File(ref));  
        }
        catch(Exception e){
           e.printStackTrace(); 
        }
        return bimg;
    }//final metodo loadImage
    
    public void loadAndDisplayImage(JFrame frame){
        //Load the img
        BufferedImage loadImage = UtilImage.loadImage("D:/Images/1sol.png");
        frame.setBounds(0, 0, loadImage.getWidth(), loadImage.getHeight());
        //Set the panel visible and add it to the frame
        frame.setVisible(true);
        //Get the surfaces Graphics object
        Graphics2D g = (Graphics2D) frame.getRootPane().getGraphics();
        //Now draw the image
        g.drawImage(loadImage, null, 0, 0);
    }//final metodo loadAndDisplayImage
    
    public static void main(String[] args){
        UtilImage ua = new UtilImage();
        JFrame frame = new JFrame("Tutoriais");
        ua.loadAndDisplayImage(frame);
    }
    
}//final classe UtilImage
