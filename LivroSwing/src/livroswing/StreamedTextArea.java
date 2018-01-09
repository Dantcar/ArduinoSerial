/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livroswing;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.OutputStream;
import javax.swing.JFrame;

/**
 *
 * @author Décio
 */
public class StreamedTextArea extends TextArea {

    OutputStream theOutput = new TextAreaOutputStream();

    public StreamedTextArea() {
        this("", 0, 0, SCROLLBARS_BOTH);
    }

    public StreamedTextArea(String text) {
        this(text, 0, 0, SCROLLBARS_BOTH);
    }

    public StreamedTextArea(int rows, int columns) {
        this("", rows, columns, SCROLLBARS_BOTH);
    }

    public StreamedTextArea(String text, int rows, int columns) {
        this(text, rows, columns, SCROLLBARS_BOTH);
    }

    public StreamedTextArea(String text, int rows, int columns, int scrollbars) {
        super(text, rows, columns, scrollbars);
        setEditable(false);
    }

    public OutputStream getOutputStream() {
        return theOutput;
    }

    class TextAreaOutputStream extends OutputStream {

        @Override
        public synchronized void write(int b) {
            // recall that the int should really just be a byte
            b &= 0x000000FF;
            // must convert byte to a char in order to append it
            char c = (char) b;
            append(String.valueOf(c));
        }

        @Override
        public synchronized void write(byte[] data, int offset, int length) {
            append(new String(data, offset, length));
        }
    }
    
     public static void main(String args[]) {
        StreamedTextArea STA = new StreamedTextArea();
       // mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        frame.setTitle("Scrolling Programmatically");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(STA);
        frame.setVisible(true);
    }
}
