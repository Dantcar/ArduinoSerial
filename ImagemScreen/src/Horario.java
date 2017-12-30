
/**
 * Sao Paulo 26-12-2017
 * Class Horario.java
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
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * A simple Clock
 */
public class Horario extends Thread implements Runnable {


    public volatile Thread horarioThread = null;
    public static volatile boolean done = false;
    public static volatile String clock = "";
    protected DecimalFormat tflz, tf;

    public void init() {

    }

    public void start() {
        if (horarioThread == null) {
            horarioThread = new Thread(this, "Horario");
            horarioThread.start();

        }
    }

    public void run() {
        Thread myThread = Thread.currentThread();
        tf = new DecimalFormat("#0");
        tflz = new DecimalFormat("00");
        while (!done) {
            //repaint();
            Calendar myCal = Calendar.getInstance();
            StringBuffer sb = new StringBuffer();
            sb.append(tf.format(myCal.get(Calendar.HOUR)));
            sb.append(':');
            sb.append(tflz.format(myCal.get(Calendar.MINUTE)));
            sb.append(':');
            sb.append(tflz.format(myCal.get(Calendar.SECOND)));
            if(myCal.get(Calendar.AM)==0){
               sb.append(" AM"); 
            }else{
               sb.append(" PM");
            }
            String s = sb.toString();
            //System.out.println(s);
            clock = s;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            
        }
        
    }
    
    public void eita() {
        done = true;
    }
    
}//final classe Horario
