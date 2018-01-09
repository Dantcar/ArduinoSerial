
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Décio
 */
public class ScrollableDemo extends JFrame {

    public ScrollableDemo() {
        super("JScrollPane Demo");
        ImageIcon ii = new ImageIcon("me.jpg");
        JScrollPane jsp = new JScrollPane(new MyScrollableLabel(ii));
        getContentPane().add(jsp);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScrollableDemo();
    }
}

