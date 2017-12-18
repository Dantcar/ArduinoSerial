/**
 * Classe ChromaK
 * Sao Paulo - Dezembro-2017
 *
 * @author Decio A Carvalho
 * @serial 0.2 início: 09-12-2017 ultima:
 */
package ChromaK;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class FiltrosCK {

    /**
     * Metodo 01 Metodo para aplicação do filtro chromakey1
     *
     * @param image
     * @param fundo
     * @return BufferedImage chromakey
     */
    public static BufferedImage chromakey1(BufferedImage fundo, BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color color_image, color_fundo;

        int width_fundo = fundo.getWidth();

        Color color;

        //alterar atributos da imagem de fundo para as mesmas dimensões de "image"
        if (width != width_fundo) {
            fundo = getScaledImage(fundo, width, height);
        }
        //fundo = alterarDimensoes(fundo, width, height);
        //ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("D://images//teste.png"));
        //fundo.setImage(fundo.getImage().getScaledInstance(width, height, 100));
        /*
        ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("Imagens/botões/controle/btoExcluir.png"));
        img.setImage(img.getImage().getScaledInstance(50, 50, 100));
         */
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int f_rgb = fundo.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor
                int rgb = image.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor                 

                int varR = (int) ((rgb & 0x00FF0000) >>> 16);
                int varG = (int) ((rgb & 0x0000FF00) >>> 8);
                int varB = (int) (rgb & 0x000000FF);

                int varfR = (int) ((f_rgb & 0x00FF0000) >>> 16);
                int varfG = (int) ((f_rgb & 0x0000FF00) >>> 8);
                int varfB = (int) (f_rgb & 0x000000FF);

                color_image = new Color(varR, varG, varB);
                color_fundo = new Color(varfR, varfG, varfB);

                if (varR >= 0 && varR < 35) {

                    if (varB >= 50 && varB < 190) {
                        if (varG >= 0 && varG <= 255) {
                            image.setRGB(i, j, color_fundo.getRGB());
                        } else {
                            //color = new Color(varfR, varfG, varfB);
                            image.setRGB(i, j, color_image.getRGB());
                            //System.out.println(varR + " - " + varG + " - " + varB);
                        }
                    }
                }
                //System.out.println(color_image.toString());

            } // final do for j

        } // final do for i
        //image.flush();
        return image;
    }// final metodo 01 - BufferedImage chromakey1

    /**
     * Metodo 02 Metodo para aplicação do filtro chromakey1
     *
     * @param image
     * @param fundo
     * @return BufferedImage chromakey
     */
    public static void chromakey(BufferedImage image, BufferedImage fundo) {
        int width = image.getWidth();
        int height = image.getHeight();

        int width_fundo = fundo.getWidth();

        Color color;

        //alterar atributos da imagem de fundo para as mesmas dimensões de "image"
        if (width != width_fundo) {
            fundo = getScaledImage(fundo, width, height);
        }
        //fundo = alterarDimensoes(fundo, width, height);
        //ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("D://images//teste.png"));
        //fundo.setImage(fundo.getImage().getScaledInstance(width, height, 100));
        /*
        ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("Imagens/botões/controle/btoExcluir.png"));
        img.setImage(img.getImage().getScaledInstance(50, 50, 100));
         */

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int f_rgb = fundo.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor
                int rgb = image.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor                 

                int varR = (int) ((rgb & 0x00FF0000) >>> 16);
                int varG = (int) ((rgb & 0x0000FF00) >>> 8);
                int varB = (int) (rgb & 0x000000FF);

                int varfR = (int) ((f_rgb & 0x00FF0000) >>> 16);
                int varfG = (int) ((f_rgb & 0x0000FF00) >>> 8);
                int varfB = (int) (f_rgb & 0x000000FF);

                if (varfG > 0) {
                    color = new Color(varR, varG, varB);
                } else {
                    color = new Color(varfR, varfG, varfB);
                }
                System.out.println(varfG);
                image.setRGB(i, j, color.getRGB());

            } // final do for j

        } // final do for i

    }// final metodo 02 - BufferedImage chromakey

    /**
     * Metodo 03 Metodo para aplicação do filtro chromakey3
     *
     * @param image
     * @param fundo
     * @return BufferedImage chromakey
     */
    public static BufferedImage chromakey3(BufferedImage fundo, BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color color_image, color_fundo;

        //alterar atributos da imagem de fundo para as mesmas dimensões de "image"
        //fundo = alterarDimensoes(fundo, width, height);
        //ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("D://images//teste.png"));
        //fundo.setImage(fundo.getImage().getScaledInstance(width, height, 100));
        /*
        ImageIcon img = new ImageIcon (Form.class.getClassLoader().getResource("Imagens/botões/controle/btoExcluir.png"));
        img.setImage(img.getImage().getScaledInstance(50, 50, 100));
         */
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int f_rgb = fundo.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor
                int rgb = image.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor                 

                int varR = (int) ((rgb & 0x00FF0000) >>> 16);
                int varG = (int) ((rgb & 0x0000FF00) >>> 8);
                int varB = (int) (rgb & 0x000000FF);

                int varfR = (int) ((f_rgb & 0x00FF0000) >>> 16);
                int varfG = (int) ((f_rgb & 0x0000FF00) >>> 8);
                int varfB = (int) (f_rgb & 0x000000FF);

                color_image = new Color(varR, varG, varB);
                color_fundo = new Color(varfR, varfG, varfB);

                if (varR >= 0 && varR < 35) {

                    if (varB >= 50 && varB < 190) {
                        if (varG >= 0 && varG <= 255) {
                            image.setRGB(i, j, color_fundo.getRGB());
                        } else {
                            //color = new Color(varfR, varfG, varfB);
                            image.setRGB(i, j, color_image.getRGB());
                            //System.out.println(varR + " - " + varG + " - " + varB);
                        }
                    }
                }
                //System.out.println(color_image.toString());

            } // final do for j

        } // final do for i
        //image.flush();
        return image;
    }// final metodo 03 - BufferedImage chromakey3

    /**
     * Metodo 04 - rescalonar BufferedImage Resizes an image using a Graphics2D
     * object backed by a BufferedImage.
     *
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    public static BufferedImage getScaledImage(BufferedImage src, int w, int h) {
        int finalw = w;
        int finalh = h;

        BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }// final metodo getScaledImage

    /**
     * Metodo 05 Metodo para aplicação do filtro chromakeyBlack
     *
     * @param fundo
     * @param image
     * @return
     */
    public static BufferedImage chromakeyBlack(BufferedImage fundo, BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color color_image, color_fundo;

        int width_fundo = fundo.getWidth();

        //alterar atributos da imagem de fundo para as mesmas dimensões de "image"
        if (width != width_fundo) {
            fundo = getScaledImage(fundo, width, height);
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int f_rgb = fundo.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor
                int rgb = image.getRGB(i, j);//a cor inversa é dado por 255 menos o valor da cor                 

                int varR = (int) ((rgb & 0x00FF0000) >>> 16);
                int varG = (int) ((rgb & 0x0000FF00) >>> 8);
                int varB = (int) (rgb & 0x000000FF);

                int varfR = (int) ((f_rgb & 0x00FF0000) >>> 16);
                int varfG = (int) ((f_rgb & 0x0000FF00) >>> 8);
                int varfB = (int) (f_rgb & 0x000000FF);

                color_image = new Color(varR, varG, varB);
                color_fundo = new Color(varfR, varfG, varfB);

                if (varR <= 5 && varG <= 5 && varB <= 5) {

                    if (varB >= 50 && varB < 190) {
                        image.setRGB(i, j, color_fundo.getRGB());
                    } else {
                        image.setRGB(i, j, color_image.getRGB());
                    }

                } //final if principal

            }// final do for j
        } // final do for i
        //image.flush();
        return image;
    }// final metodo 05 - BufferedImage chromakeyBlack

}// final classe FiltrosCK
