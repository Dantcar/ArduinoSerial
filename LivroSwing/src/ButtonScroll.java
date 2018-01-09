
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Décio
 */
public class ButtonScroll extends JFrame {

    protected JViewport m_viewport;
    protected JButton m_up;
    protected JButton m_down;
    protected JButton m_left;
    protected JButton m_right;
    protected int m_pgVert;
    protected int m_pgHorz;

    public ButtonScroll() {
        super("Scrolling Programmatically");
        setSize(400, 400);
        getContentPane().setLayout(new BorderLayout());
        ImageIcon shuttle = new ImageIcon("instruments-ochestra.gif");
        m_pgVert = shuttle.getIconHeight() / 5;
        m_pgHorz = shuttle.getIconWidth() / 5;
        JLabel lbl = new JLabel(shuttle);
        m_viewport = new JViewport();
        m_viewport.setView(lbl);
        m_viewport.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                enableButtons(
                        ButtonScroll.this.m_viewport.getViewPosition());
            }
        });
        getContentPane().add(m_viewport, BorderLayout.CENTER);
        JPanel pv = new JPanel(new BorderLayout());
        m_up = createButton("up", 'u');
        ActionListener lst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePanel(0, -1);
            }
        };
        m_up.addActionListener(lst);
        pv.add(m_up, BorderLayout.NORTH);
        m_down = createButton("down", 'd');
        lst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePanel(0, 1);
            }
        };
        m_down.addActionListener(lst);
        pv.add(m_down, BorderLayout.SOUTH);
        getContentPane().add(pv, BorderLayout.EAST);
        JPanel ph = new JPanel(new BorderLayout());
        m_left = createButton("left", 'l');
        lst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePanel(-1, 0);
            }
        };
        m_left.addActionListener(lst);
        ph.add(m_left, BorderLayout.WEST);
        m_right = createButton("right", 'r');
        lst = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePanel(1, 0);
            }
        };
        m_right.addActionListener(lst);
        ph.add(m_right, BorderLayout.EAST);
        getContentPane().add(ph, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        movePanel(0, 0);
    }

    protected JButton createButton(String name, char mnemonics) {
        JButton btn = new JButton(new ImageIcon(name + "1.png"));
        btn.setPressedIcon(new ImageIcon(name + "2.png"));
        btn.setDisabledIcon(new ImageIcon(name + "3.png"));
        btn.setToolTipText("Move " + name);
        btn.setBorderPainted(false);
        btn.setMargin(new Insets(0, 0, 0, 0));
        btn.setContentAreaFilled(false);
        btn.setMnemonic(mnemonics);
        return btn;
    }

    protected void movePanel(int xmove, int ymove) {
        Point pt = m_viewport.getViewPosition();
        pt.x += m_pgHorz * xmove;
        pt.y += m_pgVert * ymove;
        pt.x = Math.max(0, pt.x);
        pt.x = Math.min(getMaxXExtent(), pt.x);
        pt.y = Math.max(0, pt.y);
        pt.y = Math.min(getMaxYExtent(), pt.y);
        m_viewport.setViewPosition(pt);
        enableButtons(pt);
    }

    protected void enableButtons(Point pt) {
        if (pt.x == 0) {
            enableComponent(m_left, false);
        } else {
            enableComponent(m_left, true);
        }
        if (pt.x >= getMaxXExtent()) {
            enableComponent(m_right, false);
        } else {
            enableComponent(m_right, true);
        }
        if (pt.y == 0) {
            enableComponent(m_up, false);
        } else {
            enableComponent(m_up, true);
        }
        if (pt.y >= getMaxYExtent()) {
            enableComponent(m_down, false);
        } else {
            enableComponent(m_down, true);
        }
    }

    protected void enableComponent(JComponent c, boolean b) {
        if (c.isEnabled() != b) {
            c.setEnabled(b);
        }
    }

    protected int getMaxXExtent() {
        return m_viewport.getView().getWidth() - m_viewport.getWidth();
    }

    protected int getMaxYExtent() {
        return m_viewport.getView().getHeight() - m_viewport.getHeight();
    }

    public static void main(String argv[]) {
        new ButtonScroll();
    }

}
