/**
 * Sao Paulo 21-12-2017
 * Class DriveThrough.java
 * LearnigJava - cap.17
 * 
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
package View;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author decio_000
 */
public class DriveThrough {
    public static int PEDIDO = 0;
    
    public static void main(String[] args){
        //Container principal
        JFrame frame = new JFrame("Lister v1.0");
        
        //Container painel Botoes (escolha unica)
        JPanel entreePanel = new JPanel();
        
         //Agrupamento de botoes
        final ButtonGroup entreeGroup = new ButtonGroup();
        //Criacao de botoes
        JRadioButton radioButton;
        //Button Beef
        entreePanel.add(radioButton = new JRadioButton("Beef"));
        radioButton.setActionCommand("Beff");
        entreeGroup.add(radioButton);
        //Button Chicken
        entreePanel.add(radioButton = new JRadioButton("Chicken"));
        radioButton.setActionCommand("Chicken");
        entreeGroup.add(radioButton);
        //Button Veggie
        entreePanel.add(radioButton = new JRadioButton("Veggie"));
        radioButton.setActionCommand("Veggie");
        entreeGroup.add(radioButton);
        
        //Container painel Botoes (escolha unica)
        JPanel breadPanel = new JPanel();
        
        //Agrupamento de botoes: paes
        final ButtonGroup breadGroup = new ButtonGroup();
        //Criacao de botoes paes
        JRadioButton radioButtonBread;
        //Button baguette
        breadPanel.add(radioButtonBread = new JRadioButton("Baguette"));
        radioButtonBread.setActionCommand("Baguette");
        breadGroup.add(radioButtonBread);
        //Button breadBurger
        breadPanel.add(radioButtonBread = new JRadioButton("Bread Burger"));
        radioButtonBread.setActionCommand("Bread Burger");
        breadGroup.add(radioButtonBread);
        //Button Ciabatta
        breadPanel.add(radioButtonBread = new JRadioButton("Ciabatta"));
        radioButtonBread.setActionCommand("Ciabatta");
        breadGroup.add(radioButtonBread);
        //Pullman Loaf
        breadPanel.add(radioButtonBread = new JRadioButton("Pullman Loaf"));
        radioButtonBread.setActionCommand("Pullman Loaf");
        breadGroup.add(radioButtonBread);
        
       
        
        //Container painel Condimentos (multipla escolha)
        final JPanel condimentsPanel = new JPanel();
        
        condimentsPanel.add(new JCheckBox("Ketchup"));
        condimentsPanel.add(new JCheckBox("Mustard"));
        condimentsPanel.add(new JCheckBox("Pickles"));
        condimentsPanel.add(new JCheckBox("mayonnaise"));
        
        //Container painel Order
        JPanel orderPanel = new JPanel();
        JButton orderButton = new JButton("Place Order");
        orderPanel.add(orderButton);
        
        Container content = frame.getContentPane(); //unnecessary in 5.0+
        content.setLayout(new GridLayout(4, 1)); //Layout coluna/linha
        //Adicionando os paineis: entreePanel, condimentsPanel, orderPanel
        content.add(entreePanel);
        content.add(breadPanel);     
        content.add(condimentsPanel);
        content.add(orderPanel);
        
        
        //Escutando o button para finalizar o pedido
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //Escolha do Ingrediente 
            String entree = 
                    entreeGroup.getSelection().getActionCommand();
            //Escolha do pao (bread)
            String bread = 
                    breadGroup.getSelection().getActionCommand();
            System.out.println("PEDIDO N. " + PEDIDO );
            PEDIDO = PEDIDO + 1;
            System.out.println(entree + " sandwich in " + bread);
            Component[] components = condimentsPanel.getComponents();
            
            for( Component c : components){
                JCheckBox cb = (JCheckBox)c;
                
                if(cb.isSelected()){
                    System.out.println("With " + cb.getText());
                }
            }
                   System.out.println("\n");
                   cleanupScreen();
            }
            
            
            
        });//final ActionListener
        
        //Finalizando configurando e mostrando o painel principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,200);
        frame.setVisible(true);
        
    }//final metodo main
    
    public static void cleanupScreen(){
        //
    }
    
}//final classe DriveThrough
