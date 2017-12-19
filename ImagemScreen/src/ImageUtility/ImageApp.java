/**
 * Sao Paulo 19-12-2017
 * Class ImageApp.java
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
package ImageUtility;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author decio_000
 */
public class ImageApp {
    
    public void loadAndDisplayImage(JFrame frame){
        BufferedImage loadImg = UtilImage.loadImage("D:/images/1sol.png");
        frame.setBounds(0, 0, loadImg.getWidth(), loadImg.getHeight());
        JImagePanel panel = new JImagePanel(loadImg,0,0);
        frame.add(panel);
        frame.setVisible(true);  
    }//final metodo loadAndDisplayImage
    
    public static void main(String[] args){
        ImageApp ia =  new ImageApp();
        JFrame frame = new JFrame("Tutorials");
        ia.loadAndDisplayImage(frame);
    }//final metodo main
    
}//final classe ImageApp

