/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacaoarduino;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class ControlePorta {
  private OutputStream serialOut;
  private int taxa;
  private String portaCOM;

  /**
   * Construtor da classe ControlePorta
   * @param portaCOM - Porta COM que será utilizada para enviar os dados para o arduino
   * @param taxa - Taxa de transferência da porta serial geralmente é 9600
   */
  public ControlePorta(String portaCOM, int taxa) {
    this.portaCOM = portaCOM;
    this.taxa = taxa;
    this.initialize();
  }     
 
  /**
   * Médoto que verifica se a comunicação com a porta serial está ok
   */
  private void initialize() {
    try {
      //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
      CommPortIdentifier portId = null;
      try {
        //Tenta verificar se a porta COM informada existe
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
      }catch (NoSuchPortException npe) {
        //Caso a porta COM não exista será exibido um erro 
        JOptionPane.showMessageDialog(null, "Porta COM não encontrada.",
                  "Porta COM", JOptionPane.PLAIN_MESSAGE);
      }
      //Abre a porta COM 
      SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
    }catch (Exception e) {
      e.printStackTrace();
    }
}

  /**
   * Método que fecha a comunicação com a porta serial
   */
  public void close() {
    try {
        serialOut.close();
    }catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Não foi possível fechar porta COM.",
                "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * @param opcao - Valor a ser enviado pela porta serial
   */
  public void enviaDados(int opcao){
    try {
      serialOut.write(opcao);//escreve o valor na porta serial para ser enviado
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
    }
  }
  
  public void enviaTexto(byte[] texto){
      try{
      serialOut.write(texto);//escreve o valor na porta serial para ser enviado
      }catch(IOException ex){
          JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
      }
  }
  
}//Final class ControlePorta

/*
public void write(byte[] bytes) throws IOException {
            // <editor-fold defaultstate="collapsed" desc="Compiled Code">
            /* 0: aload_0
             * 1: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 4: invokestatic  gnu/io/RXTXPort.access$1000:(Lgnu/io/RXTXPort;)I
             * 7: ifne          11
             * 10: return
             * 11: aload_0
             * 12: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 15: getfield      gnu/io/RXTXPort.monThreadisInterrupted:Z
             * 18: iconst_1
             * 19: if_icmpne     23
             * 22: return
             * 23: aload_0
             * 24: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 27: invokestatic  gnu/io/RXTXPort.access$1100:(Lgnu/io/RXTXPort;)I
             * 30: ifne          41
             * 33: new           java/io/IOException
             * 36: dup
             * 37: invokespecial java/io/IOException."<init>":()V
             * 40: athrow
             * 41: aload_0
             * 42: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 45: getfield      gnu/io/RXTXPort.IOLockedMutex:Ljava/lang/Object;
             * 48: dup
             * 49: astore_2
             * 50: monitorenter
             * 51: aload_0
             * 52: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 55: dup
             * 56: getfield      gnu/io/RXTXPort.IOLocked:I
             * 59: iconst_1
             * 60: iadd
             * 61: putfield      gnu/io/RXTXPort.IOLocked:I
             * 64: aload_2
             * 65: monitorexit
             * 66: goto          74
             * 69: astore_3
             * 70: aload_2
             * 71: monitorexit
             * 72: aload_3
             * 73: athrow
             * 74: aload_0
             * 75: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 78: invokevirtual gnu/io/RXTXPort.waitForTheNativeCodeSilly:()V
             * 81: aload_0
             * 82: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 85: aload_1
             * 86: iconst_0
             * 87: aload_1
             * 88: arraylength
             * 89: aload_0
             * 90: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 93: getfield      gnu/io/RXTXPort.monThreadisInterrupted:Z
             * 96: invokevirtual gnu/io/RXTXPort.writeArray:([BIIZ)V
             * 99: aload_0
             * 100: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 103: getfield      gnu/io/RXTXPort.IOLockedMutex:Ljava/lang/Object;
             * 106: dup
             * 107: astore_2
             * 108: monitorenter
             * 109: aload_0
             * 110: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 113: dup
             * 114: getfield      gnu/io/RXTXPort.IOLocked:I
             * 117: iconst_1
             * 118: isub
             * 119: putfield      gnu/io/RXTXPort.IOLocked:I
             * 122: aload_2
             * 123: monitorexit
             * 124: goto          134
             * 127: astore        4
             * 129: aload_2
             * 130: monitorexit
             * 131: aload         4
             * 133: athrow
             * 134: goto          180
             * 137: astore        5
             * 139: aload_0
             * 140: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 143: getfield      gnu/io/RXTXPort.IOLockedMutex:Ljava/lang/Object;
             * 146: dup
             * 147: astore        6
             * 149: monitorenter
             * 150: aload_0
             * 151: getfield      gnu/io/RXTXPort$SerialOutputStream.this$0:Lgnu/io/RXTXPort;
             * 154: dup
             * 155: getfield      gnu/io/RXTXPort.IOLocked:I
             * 158: iconst_1
             * 159: isub
             * 160: putfield      gnu/io/RXTXPort.IOLocked:I
             * 163: aload         6
             * 165: monitorexit
             * 166: goto          177
             * 169: astore        7
             * 171: aload         6
             * 173: monitorexit
             * 174: aload         7
             * 176: athrow
             * 177: aload         5
             * 179: athrow
             * 180: return
             * Exception table:
             * from    to  target type
             * 51    66    69   any
             * 69    72    69   any
             * 109   124   127   any
             * 127   131   127   any
             * 74    99   137   any
             * 150   166   169   any
             * 169   174   169   any
             * 137   139   137   any
             *  */
            // </editor-fold>
      