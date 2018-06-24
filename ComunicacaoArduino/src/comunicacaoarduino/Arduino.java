/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacaoarduino;

import javax.swing.JButton;

/**
 * @author klauder
 */
public class Arduino {
  private ControlePorta arduino;
  private String str ="";
  /**
   * Construtor da classe Arduino
   */
  public Arduino(){
      arduino = new ControlePorta("COM4",9600);//Windows - porta e taxa de transmissão
      //arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
  }    

  /**
   * Envia o comando para a porta serial
   * @param button - Botão que é clicado na interface Java
   */
  public void comunicacaoArduino(JButton button) {        
    if("Ligar".equals(button.getActionCommand())){
      arduino.enviaDados(1);
      System.out.println(button.getText());//Imprime o nome do botão pressionado
    }
    else if("Desligar".equals(button.getActionCommand())){
        arduino.enviaDados(2);
      System.out.println(button.getText());
    }
    else if("Texto".equals(button.getActionCommand())){
        arduino.enviaDados(4);//limpar LCD
        str ="DECIO";   
        byte[] byteArr = str.getBytes(); 
        arduino.enviaTexto(byteArr);
      System.out.println(button.getText());
    }
    else if("Piscar".equals(button.getActionCommand())){
        arduino.enviaDados(4);//limpar LCD
        str ="PISCAR";   
        byte[] byteArr = str.getBytes(); 
        arduino.enviaTexto(byteArr);
      System.out.println(button.getText());
    }
    
    else if("Limpar".equals(button.getActionCommand())){
        arduino.enviaDados(4);//limpar LCD
      System.out.println(button.getText());
    }
    
    else{
        arduino.enviaDados(3);
        //arduino.enviaDados(4);
        str ="Shutdown";   
        byte[] byteArr = str.getBytes(); 
        arduino.enviaTexto(byteArr);
        arduino.close();
      System.out.println(button.getText()+"\n"+"Shutdown");//Imprime o nome do botão pressionado
    }
  }
}