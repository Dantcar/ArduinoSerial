package src;

import view.TelaCadastro;
import view.TelaCliente;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Décio
 */
public class Cadastro {

    private static String titulo;
    private static String tituloCliente;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         DBDerby db = new DBDerby();
        montaTelaPrincipal();  
    }
    
    /**
     * 
     * Método construtor
     *  
     * @param titulo
     */
    public Cadastro(String titulo) {
        Cadastro.titulo = titulo;
    
    }
    
    
    
    /**
     * método para criar a tela inicial
     */
    public static void montaTelaPrincipal(){
        Cadastro.titulo = "Cadastro Geral";
        
        TelaCadastro tela = new TelaCadastro();
        tela.setTitle(Cadastro.titulo);
       
        //tela.setLocation(300, 200);
       
        tela.setVisible(true);
        if (DBDerby.acesso)
        tela.lblConexao.setText("Conectado");
        else
        tela.lblConexao.setText("Desconectado");  
    }
     /**
     * método para criar a tela inicial
     */
    public static void montaTelaCliente(){
        Cadastro.tituloCliente = "Cadastro de Clientes";
        
        TelaCliente telaC = new TelaCliente();
        telaC.setTitle(Cadastro.tituloCliente);
        telaC.setVisible(true);
        telaC.setLocation(50, 50);
       
    }
    
}
