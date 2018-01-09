/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import view.TelaAbout;
import view.TelaCliente;

/**
 *
 * @author Décio
 */
public class Cadastro {
    private static String titulo;
    private static String tituloCliente;
    
    public static void montaTelaCliente(){
        Cadastro.tituloCliente = "Cadastro de Clientes";
        
        TelaCliente telaC = new TelaCliente();
        telaC.setTitle(Cadastro.tituloCliente);
        telaC.setVisible(true);
        telaC.setLocation(50, 50);
       
    }
    public static void montaTelaAbout(){
        
        TelaAbout telaA;
        telaA = new TelaAbout();
        telaA.setTitle(Cadastro.tituloCliente);
        telaA.setVisible(true);
        telaA.setLocation(50, 50);
        //telaA.setBackground(Color.yellow);
    }
}
