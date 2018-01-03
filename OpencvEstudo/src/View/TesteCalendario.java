/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author decio_000
 */
public class TesteCalendario extends JFrame {

    public TesteCalendario() {
        
        
    }
    
     /**
     * For testing, a main program
     */
    public static void main(String[] av) {
        CalendarioMes cp = new CalendarioMes();
        ClockVerde clock = new ClockVerde();
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        //panel1.add(cp);
        panel2.add(clock);
        //frame.add(panel2);
        frame.add(panel2);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 180);
        frame.setVisible(true);
    }//final metodo main
    
    
}
