/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * All rights reserved. Software written by Ian F. Darwin and others.
 * $Id: LICENSE,v 1.8 2004/02/09 03:33:38 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * Java, the Duke mascot, and all variants of Sun's Java "steaming coffee
 * cup" logo are trademarks of Sun Microsystems. Sun's, and James Gosling's,
 * pioneering role in inventing and promulgating (and standardizing) the Java 
 * language and environment is gratefully acknowledged.
 * 
 * The pioneering role of Dennis Ritchie and Bjarne Stroustrup, of AT&T, for
 * inventing predecessor languages C and C++ is also gratefully acknowledged.
 */
package View;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * A simple Clock
 */
public class Clock extends javax.swing.JComponent {

    protected DecimalFormat tflz, tf;
    protected String clock = null;
    protected boolean done = false;
    public String resp = "";
    
    public Clock() {
        new Thread(new Runnable() {
            public void run() {
                while (!done) {
                    Clock.this.repaint(); // request a redraw
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        /* do nothing */
                    }
                }
            }
        }).start();
        tf = new DecimalFormat("#0");
        tflz = new DecimalFormat("00");
    }

    

    public void stop() {
        done = true;
    }

    /* paint() - get current time and draw (centered) in Component. */
    public void paint(Graphics g) {
        Calendar myCal = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(tf.format(myCal.get(Calendar.HOUR)));
        sb.append(':');
        sb.append(tflz.format(myCal.get(Calendar.MINUTE)));
        sb.append(':');
        sb.append(tflz.format(myCal.get(Calendar.SECOND)));
        String s = sb.toString();
        FontMetrics fm = getFontMetrics(getFont());
        int x = (getSize().width - fm.stringWidth(s)) / 2;
        // System.out.println("Size is " + getSize());
        g.drawString(s, x, 10);
    }

    public Dimension getPreferredSize() {
        return new Dimension(100, 30);
    }

    public Dimension getMinimumSize() {
        return new Dimension(50, 10);
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Clock");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        Clock component = new Clock();
        f.add(component);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        //Clock clock = new Clock();
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);

    }//final main
}//final classe Clock
