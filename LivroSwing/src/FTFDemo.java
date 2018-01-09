/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Décio
 */
public class FTFDemo extends JFrame {

    public FTFDemo() {
        super("Formatted TextField");
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new EmptyBorder(10, 10, 10, 10));
        p.add(new JLabel("Dollar amount:"));
NumberFormat formatMoney  = NumberFormat.getCurrencyInstance(Locale.US);
        JFormattedTextField ftfMoney = new JFormattedTextField(formatMoney);
        ftfMoney.setColumns(10);
        ftfMoney.setValue(new Double(100));
        p.add(ftfMoney);
        p.add(new JLabel("Transaction date:"));
DateFormat formatDate = new SimpleDateFormat("MM / dd / yyyy");
JFormattedTextField ftfDate = new JFormattedTextField(formatDate);
        ftfDate.setColumns(10);
        ftfDate.setValue(new Date());
        p.add(ftfDate);
        JButton btn = new JButton("OK");
        p.add(btn);
        getContentPane().add(p, BorderLayout.CENTER);
        pack();
    }

    public static void main(String args[]) {
        FTFDemo mainFrame = new FTFDemo();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
