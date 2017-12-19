/**
 * Sao Paulo 19-12-2017
 * Class JImagePanel.java
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

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author decio_000
 */
public class JImagePanel extends JPanel{
    private BufferedImage image;
    int x, y;
    
    /**
     * Metodo Sub classe de JPanel para acomodar imagem
     * @param image imagem a ser carregada
     * @param x posicao horizontal do ponto esquerdo superior
     * @param y posicao vertical do ponto esquerdo superior
     */
    public JImagePanel(BufferedImage image, int x, int y){
        super();
        this.image = image;
        this.x = x;
        this.y = y;
        
    }//final metodo construtor JImagePanel
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, x, y, null);
    }//final paintComponent
    
}//final classe JImagePanel
