/**
 * Praia Grande 01-01-2018
 * Class Clock.java
 * Relogio analogico
 * 
 *
 * @author Decio A Carvalho
 * @serial 0.2
 * @since Dezembro-2017
 *
 * Retomada dos Estudos com manipulacao de imagens utilizando:
 * Java.awt.Graphcs2d, Java.awt.Graphics, Java.awt.image, Java.awt.Color,
 * Java.awt.Robot, Java.awt.geom, Java.io, Java.net, Java.util, Java.imageio,
 * Java.swing, Java.text, Java.awt.AWTException Java.awt.Rectangle,
 */
package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author decio_000
 */
public class Clock extends JComponent{
    
    private static final double TWO_PI = 2.0 * Math.PI;
    private static final int UPDATE_INTERVAL = 100; //Millisecs
    
    private Calendar _now =  Calendar.getInstance(); //Current time.
    
    private int _diameter; //Height and width of clock face.
    private int _centerX; //x coord of middle of clock.
    private int _centerY; //y coord of middle of clock.
    private BufferedImage _clockImage; //Saved image of the clock face.
    
    private javax.swing.Timer _timer; //Fires to update clock.

    public Clock() {
        
        this.setPreferredSize(new Dimension(300,300));
        
        _timer = new javax.swing.Timer(UPDATE_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
                repaint();
            }

            
        });
        start();
    }// final metodo construtor.
    
    /**
     * Metodo start
     */
    public void start(){
        _timer.start();
    }//final metodo start.
    
    /**
     * Metodoo stop
     */
    public void stop(){
        _timer.stop();
    }//final metodo stop.
    
    /**
     * Metodo para atualizar o horario
     */
    private void updateTime() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        _now.setTimeInMillis(System.currentTimeMillis());
        
    }//final metodo updateTime
    
    @Override
    public void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        //The panel may have been resized, get current dimensions
        int w = getWidth();
        int h = getHeight();
        
        _diameter = (( w < h) ? w : h);
        _centerX = _diameter / 2;
        _centerY = _diameter /2;
        
        //Create the clock face background image if this is the first time,
        // or if the size of the panel has changed
        if( _clockImage == null
             || _clockImage.getWidth()!= w
             || _clockImage.getHeight() != h){
            
            _clockImage = (BufferedImage)(this.createImage(w,h));
            
            // Get a graphics context from this image
            Graphics2D g2a = _clockImage.createGraphics();
            g2a.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            drawClockFace(g2a);
            
        }//final if _clockImage
        
        // Draw the clock face from the precomputed image.
        g2.drawImage(_clockImage, null, 0, 0);
        
        // Draw the clock hands dynamically each time.
        drawClockHands(g2);
        
    }// final metodo paintComponent.

    /**
     *  Metodo que desenha a face do relogio.
     * @param g2
     */
    private void drawClockFace(Graphics2D g2a) {
        // Draw the clock face. Probably into a buffer.
        g2a.setColor( Color.PINK);
        g2a.fillOval(0, 0, _diameter, _diameter);
        
        g2a.setColor(Color.BLACK);
        g2a.drawOval(0, 0, _diameter, _diameter);
        
        int radius = _diameter / 2;
        
        //Draw the tick marks around the circunference.
        
        for( int sec = 0;sec < 60; sec++){
            int tickStart;
            
            if (sec%5 == 0){
                tickStart = radius - 10; // Draw long tick mark every 5. 
            }else{
                tickStart = radius - 5; // Short tick mark.
            }
            
            drawRadius(g2a, sec/60.0, tickStart, radius);
        }//final for sec
        
    }//final metodo drawClockFace.

    /**
     * Metodo desenha os ponteiros
     * @param g2 
     */
    private void drawClockHands(Graphics2D g2) {
        //Get the various time elements from the Calendar object.
        int hours = _now.get(Calendar.HOUR);
        int minutes = _now.get(Calendar.MINUTE);
        int seconds = _now.get(Calendar.SECOND);
        int millis = _now.get(Calendar.MILLISECOND);
        
        // seccond hand
        int handMin = _diameter /8; // Second hand doesn't start in middle.
        int handMax = _diameter / 2; //Second hand extends to outer rim.
        double fseconds = (seconds + (double) millis/1000 ) / 60.0;
        drawRadius(g2, fseconds, 0, handMax);
        
        // minute hand
        handMin = 0; //Minute hand starts in middle.
        handMax = _diameter / 3;
        
        double fminutes = (minutes + fseconds) / 60.0;
        drawRadius(g2, fminutes, 0, handMax);
        
        // hour hand
        handMin = 0;
        handMax = _diameter / 4;
        
        drawRadius(g2, (hours + fminutes)/12.0, 0, handMax);
        
        
    }// final metodo drawClockHands

    /**
     * Metodo que desenha os ponteiros do relogio
     * By changing the parameters, it can be used to draw tick marks,
     * as well as the hands.
     * @param g2
     * @param fseconds
     * @param i
     * @param handMax 
     */
    private void drawRadius(Graphics2D g2, double percent, int minRadius, int maxRadius) {
        // percent parameter is the fraction (0.0 - 1.0) of the way
        // clcokwise from 12. Because the Graphics2D methods use radians
        // counterclockwise from 3, a little conversion is necessary.
        // it took a little experimentation to get this right.
        
        double radians = (0.5 - percent) * TWO_PI;
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        
        int dxmin = _centerX + (int) (minRadius * sine);
        int dymin = _centerY + (int) (minRadius * cosine);
        
        int dxmax = _centerX + (int) (maxRadius * sine);
        int dymax = _centerY + (int) (maxRadius * cosine);
        
        g2.drawLine(dxmin, dymin, dxmax, dymax);
        
    }//final metodo drawRadius.
    
    public static void main(String [] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Relogio Analogico");
        window.setContentPane(new Clock());
        window.pack(); //Layout components
        window.setLocationRelativeTo(null); //Center window.
        window.setVisible(true);
    }
    
}//final Classe Clock
