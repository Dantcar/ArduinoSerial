/**
 * Praia Grande 30-12-2017
 * Class FileDemonstracao.java
 * Java Como Programar Deitel 6a edicao  - cap.14
 * OpenCV estudo
 * To hold: uses two JLabels containing ImageIcons.
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
package FileIO;

import java.io.File;

/**
 *
 * @author decio_000
 */
public class FileDemonstracao {
    // exibe informaçoes sobre o arquivo que o usuario especifica
    public void analyzePath(String path){
        //cria o objeto File com base na entrada de usuario
        File name = new File( path );
        
        // se o nome existir, gera saida das informacoes sobre ele.
        if ( name.exists()){
           //exibe informacoes sobre o arquivo (ou diretorio)
           System.out.printf( "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s",
                   name.getName(), " exists",
                   (name.isFile() ? "is a file" : "is not a file"),
                   (name.isDirectory() ? "is a directory" :
                           "is not a directory" ),
                   (name.isAbsolute() ? "is absolute path" :
                           "is not absolute path" ),
                   "Last modified: ",
                   name.lastModified(), "Length: ", name.length(),
                   "Path: ", name.getPath(), "Absolute path: ",
                   name.getAbsolutePath(), "Parent: ", name.getParent() );      
        
        
            // listagem de diretório de saida
            if ( name.isDirectory() ) {
                String directory[] = name.list();
                System.out.println( "\n\nDirectory contents:\n");
            
                for( String directoryName : directory){
                    System.out.printf( "%s\n", directoryName);
                }
            
            }// finaal if name.isDirectory
            
        } // final if name.exists                        
        else{
            System.out.printf("%s %s", path, "does not exist.");
        } //final else   
                
    }//final metodo analyzePath
   
}//final da classe FileDemonstracao
