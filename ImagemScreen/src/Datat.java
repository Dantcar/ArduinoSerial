
import java.text.DecimalFormat;
import java.util.Calendar;


/**
 * Praia Grande - SP 29-12-2017
 * Class Datat.java
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

/**
 * A simple Calendar Date
 */
public class Datat extends Thread implements Runnable{
    
    public volatile Thread dataThread = null;
    public static volatile boolean done = false;
    public static volatile String dateNow = "";
    protected DecimalFormat dflz, df;
     
    /**
     * Metodo init
     */
    public void init() {

    }//final metodo init

    /**
     * Metodo start
     */
    public void start() {
        if (dataThread == null) {
            dataThread = new Thread(this, "Data AGora");
            dataThread.start();
        }
    }//final metodo start
    
    /**
     * Metodo run
     */
    public void run() {
        Thread myThreadData = Thread.currentThread();
        df = new DecimalFormat("#0");
        dflz = new DecimalFormat("00");
        while (!done) {
            //repaint();
            Calendar myCal = Calendar.getInstance();
            StringBuffer sb = new StringBuffer();
            sb.append(df.format(myCal.get(Calendar.DATE)));
            sb.append('/');
            sb.append(df.format(myCal.get(Calendar.MONTH) + 1));
            sb.append('/');
            sb.append(df.format(myCal.get(Calendar.YEAR)));
            String s = sb.toString();
            //System.out.println(s);
            dateNow = s;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
        }
        
    }//final metodo run
    
    
    /**
     * Metodo finalizar
     */
    public void finalizar() {
        done = true;
    }//final metodo finalizar
    
}//final classe Datat (Thread)
