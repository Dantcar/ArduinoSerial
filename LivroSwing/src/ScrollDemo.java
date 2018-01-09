
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Décio
 */
public class ScrollDemo extends JFrame {

    public ScrollDemo() {
        super("JScrollBar Demo");
        setSize(300, 250);
        ImageIcon ii = new ImageIcon("earth.jpg");
        CustomScrollPane sp = new CustomScrollPane(new JLabel(ii));
        getContentPane().add(sp);
    }

    public static void main(String[] args) {
        ScrollDemo frame = new ScrollDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CustomScrollPane
        extends JPanel {

    protected JScrollBar m_vertSB;
    protected JScrollBar m_horzSB;
    protected CustomViewport m_viewport;
    protected JComponent m_comp;
    protected JButton m_btUp;
    protected JButton m_btDown;
    protected JButton m_btLeft;
    protected JButton m_btRight;

    public CustomScrollPane(JComponent comp) {
        if (comp == null) {
            throw new IllegalArgumentException(
                    "Component cannot be null");
        }
        setLayout(null);
        m_viewport = new CustomViewport();
        m_viewport.setLayout(null);
        add(m_viewport);
        m_comp = comp;
        m_viewport.add(m_comp);
        m_vertSB = new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, 0);
        m_vertSB.setUnitIncrement(5);
        add(m_vertSB);
        m_horzSB = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 0);
        m_horzSB.setUnitIncrement(5);
        add(m_horzSB);
        AdjustmentListener lst = new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                m_viewport.doLayout();
            }
        };
        m_vertSB.addAdjustmentListener(lst);
        m_horzSB.addAdjustmentListener(lst);
        m_btUp = new JButton(new ImageIcon("Up16.gif"));
        m_btUp.setMargin(new Insets(0, 0, 0, 0));
        m_btUp.setBorder(new EmptyBorder(1, 1, 1, 1));
        m_btUp.setToolTipText("Go top");
        add(m_btUp);
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_vertSB.setValue(m_vertSB.getMinimum());
                validate();
            }
        };
        m_btUp.addActionListener(listener);
        m_btDown = new JButton(new ImageIcon("Down16.gif"));
        m_btDown.setMargin(new Insets(0, 0, 0, 0));
        m_btDown.setBorder(new EmptyBorder(1, 1, 1, 1));
        m_btDown.setToolTipText("Go bottom");
        add(m_btDown);
        ActionListener l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_vertSB.setValue(m_vertSB.getMaximum());
                validate();
            }
        };
        m_btDown.addActionListener(listener);
        m_btLeft = new JButton(new ImageIcon("Back16.gif"));
        m_btLeft.setMargin(new Insets(0, 0, 0, 0));
        m_btLeft.setBorder(new EmptyBorder(1, 1, 1, 1));
        m_btLeft.setToolTipText("Go left");
        add(m_btLeft);
        l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_horzSB.setValue(m_horzSB.getMinimum());
                validate();
            }
        };
        m_btLeft.addActionListener(listener);
        m_btRight = new JButton(new ImageIcon("Forward16.gif"));
        m_btRight.setMargin(new Insets(0, 0, 0, 0));
        m_btRight.setBorder(new EmptyBorder(1, 1, 1, 1));
        m_btRight.setToolTipText("Go right");
        add(m_btRight);
        l = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_horzSB.setValue(m_horzSB.getMaximum());
                validate();
            }
        };
        m_btRight.addActionListener(l);
    }

    public void doLayout() {
        Dimension d = getSize();
        Dimension d0 = m_comp.getPreferredSize();
        Dimension d1 = m_vertSB.getPreferredSize();
        Dimension d2 = m_horzSB.getPreferredSize();
        int w = Math.max(d.width - d1.width - 1, 0);
        int h = Math.max(d.height - d2.height - 1, 0);
        m_viewport.setBounds(0, 0, w, h);
        int btW = d1.width;
        int btH = d2.height;
        m_btUp.setBounds(w + 1, 0, btW, btH);
        m_vertSB.setBounds(w + 1, btH + 1, btW, h - 2 * btH);
        m_btDown.setBounds(w + 1, h - btH + 1, btW, btH);
        m_btLeft.setBounds(0, h + 1, btW, btH);
        m_horzSB.setBounds(btW + 1, h + 1, w - 2 * btW, btH);
        m_btRight.setBounds(w - btW + 1, h + 1, btW, btH);
        int xs = Math.max(d0.width - w, 0);
        m_horzSB.setMaximum(xs);
        m_horzSB.setBlockIncrement(xs / 5);
        m_horzSB.setEnabled(xs > 0);
        int ys = Math.max(d0.height - h, 0);
        m_vertSB.setMaximum(ys);
        m_vertSB.setBlockIncrement(ys / 5);
        m_vertSB.setEnabled(ys > 0);
        m_horzSB.setVisibleAmount(m_horzSB.getBlockIncrement());
        m_vertSB.setVisibleAmount(m_vertSB.getBlockIncrement());
    }

    public Dimension getPreferredSize() {
        Dimension d0 = m_comp.getPreferredSize();
        Dimension d1 = m_vertSB.getPreferredSize();
        Dimension d2 = m_horzSB.getPreferredSize();
        Dimension d = new Dimension(d0.width + d1.width,
                d0.height + d2.height);
        return d;
    }

    class CustomViewport
            extends JPanel {

        public void doLayout() {
            Dimension d0 = m_comp.getPreferredSize();
            int x = m_horzSB.getValue();
            int y = m_vertSB.getValue();
            m_comp.setBounds(-x, -y, d0.width, d0.height);
        }
    }
}
