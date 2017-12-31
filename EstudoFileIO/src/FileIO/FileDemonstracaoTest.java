/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

import java.util.Scanner;

/**
 *
 * @author decio_000
 */
public class FileDemonstracaoTest {
    
    public static void main( String args[]){
        Scanner input = new Scanner(System.in);
        FileDemonstracao application = new FileDemonstracao();
        System.out.print("Entre aqui com nome de um Arquivo ou Diretorio :");
        application.analyzePath(input.nextLine() );
    }// fim de main
    
}// fim da classe FileDemonstracaoTest
