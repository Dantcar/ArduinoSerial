/*
 * Classe EfeitosGraficos
 * Sao Paulo - Dezembro-2017
 *
 * @author Decio A Carvalho
 * @serial 0.2 início: 16-12-2017 ultima:
 */
package Especial;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class EfeitosGraficos {

    public EfeitosGraficos() {
    
    }
    
    /**
     * Metodo to add a gradient painted sun to the current picture
     * 
     * @param x the x location for the upper left corner of the 
     * rectangle enclosing the sun
     * @param y the y location for the upper left corner of the
     * rectangle enclosing the sun
     * @param width the width of the enclosing rectangle
     * @param height the height of the enclosing rectangle
     */
    public static void drawSun(int x, int y, BufferedImage image ){
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // get the graphics2D object for this picture
        
        Graphics2D g2 = output.createGraphics();
       // Graphics g = this.getGraphics();
       // Graphics2D g2 = (Graphics2D) g;
        
        //create the gradient for painting from yellow to red with
        // yellow at the top of the sum and red at the bottom
        float xMid = (float) (width / 0.5 + x);
        
        GradientPaint gPaint = new GradientPaint(xMid, y, 
                                                Color.yellow,
                                                xMid, y + height,
                                                Color.red);
        
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, output.getWidth(), output.getHeight());
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, 100, 100);
        
        
        // set the gradient and draw the ellipse
        g2.setPaint(gPaint);
        g2.fill(new Ellipse2D.Double(x, y, width, height));
        
    }// final metodo drawSun
    
    /**
     * Metodo to add a gradient painted sun to the current picture
     * 
     * @param x the x location for the upper left corner of the 
     * rectangle enclosing the sun
     * @param y the y location for the upper left corner of the
     * rectangle enclosing the sun
     * @param width the width of the enclosing rectangle
     * @param height the height of the enclosing rectangle
     */
    public static BufferedImage drawSunB(int x, int y, BufferedImage image ){
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        // get the graphics2D object for this picture
        
        Graphics2D g2 = output.createGraphics();
       // Graphics g = this.getGraphics();
       // Graphics2D g2 = (Graphics2D) g;
        
        //create the gradient for painting from yellow to red with
        // yellow at the top of the sum and red at the bottom
        float xMid = (float) (width / 0.5 + x);
        
        GradientPaint gPaint = new GradientPaint(xMid, y, 
                                                Color.yellow,
                                                xMid, y + height,
                                                Color.red);
        
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        //RenderingHints.VALUE_ANTIALIAS_ON);
        //g2.setColor(Color.WHITE);
        //g2.fillRect(0, 0, output.getWidth(), output.getHeight());
        //g2.setColor(Color.BLUE);
        //g2.fillRect(0, 0, 100, 100);
        

        // set the gradient and draw the ellipse
        g2.setPaint(gPaint);
        g2.fill(new Ellipse2D.Double(x, y, x, y));
        g2.dispose();
         return output;
    }// final metodo drawSunB

}//Final Classe EfeitosGraficos


/**
 * 
 BufferedImage output = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);

Graphics2D g2 = output.createGraphics();
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
    RenderingHints.VALUE_ANTIALIAS_ON);
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, output.getWidth(), output.getHeight());
g2.setColor(Color.BLUE);
g2.fillRect(0, 0, 100, 100);

JOptionPane.showMessageDialog(null, new ImageIcon(output));
 */