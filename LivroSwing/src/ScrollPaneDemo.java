
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/*
 * Livro java Swing - jan 2017
 */
/**
 *
 * @author Décio
 */

public class ScrollPaneDemo extends JFrame{
    public ScrollPaneDemo() {
super("JScrollPane Demo");
ImageIcon ii = new ImageIcon("me.jpg");
JScrollPane jsp = new JScrollPane(new JLabel(ii));
getContentPane().add(jsp);
setSize(300,250);
setVisible(true);

/*
//JScrollPane somente vertical
jsp.setHorizontalScrollBarPolicy(      
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //JScrollPane somente VERTICAL

*/

jsp.setVerticalScrollBarPolicy(
ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);//JScrollPane somente HORIZONTAL

int mlocalHorizontal = jsp.getHorizontalScrollBarPolicy();

System.out.println(mlocalHorizontal);
}
public static void main(String[] args) {
new ScrollPaneDemo();
}
}
