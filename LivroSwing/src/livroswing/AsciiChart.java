/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livroswing;

/**
 *
 * @author Décio
 */
public class AsciiChart {

    public static void main(String[] args) {

        for (int i = 32; i < 127; i++) {
            System.out.write(i);
            // break line after every eight characters.
            if (i % 8 == 7) {
                System.out.write('\n');
            } else {
                System.out.write('\t');
            }
        }
        System.out.write('\n');
    }
}
