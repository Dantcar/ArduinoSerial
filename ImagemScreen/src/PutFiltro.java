
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Décio
 */
public class PutFiltro {

    public PutFiltro() {
        try {

            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        } catch (Exception e) {
            System.out.println("class PutFiltro - Exception: " + e.getMessage());
        }

    }

    /**
     * método 0 - mainBorda função colocar uma borda na imagem
     *
     * @param source
     * @return
     */
    public static Mat mainBorda(Mat source) {
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        try {

            //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

            /*
             Mat source = Highgui.imread("D:\\teste.png",
             Highgui.CV_LOAD_IMAGE_COLOR);
             */
            int top, bottom, left, right;

            int borderType;

            //initialize arguments for the filter border
            top = (int) (0.05 * source.rows());
            bottom = (int) (0.05 * source.rows());

            left = (int) (0.05 * source.cols());
            right = (int) (0.05 * source.cols());

            destination = source;

            Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_WRAP); //borda com a imagem
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_CONSTANT); //borda preta
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_DEFAULT); //borda transparente
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_ISOLATED); // borda escura??
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_REFLECT); //borda com reflexo da própria imagem
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_REFLECT101);
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_REFLECT_101);
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_REPLICATE); //borda efeito movimento
            //Imgproc.copyMakeBorder(source, destination, top, bottom, left, right, Imgproc.BORDER_TRANSPARENT); //borda não funciona

            //Highgui.imwrite("D:\\borderWrap.jpg", destination);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return destination;
    }//final métodomainBorda

    /**
     * método 1 - mainGrayScale função transformar a imagem em tons de cinzas
     *
     * @param source
     * @return
     */
    public static Mat mainGrayScale(Mat source) {
        //Mat output = source;
        Mat output = new Mat(source.rows(), source.cols(), source.type());
        BufferedImage image = mat2Img(source);

        int width = image.getWidth();
        int heigth = image.getHeight();
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {

                Color c = new Color(image.getRGB(j, i));

                int red = (int) (c.getRed() * 0.299);

                int green = (int) (c.getGreen() * 0.587);

                int blue = (int) (c.getBlue() * 0.114);

                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);

                image.setRGB(j, i, newColor.getRGB());

            }
        }
        output = imgMat(image);

        return output;
    }

    /**
     * Método img2Mat : BufferedImage to Mat
     *
     * @param in
     * @return
     */
    public static Mat img2Mat(BufferedImage in) {

        Mat out = new Mat(in.getHeight(), in.getWidth(), CvType.CV_8UC3);

        byte[] data = new byte[in.getWidth() * in.getHeight() * (int) out.elemSize()];

        int[] dataBuff = in.getRGB(0, 0, in.getWidth(), in.getHeight(), null, 0, in.getWidth());

        for (int i = 0; i < dataBuff.length; i++) {

            data[i * 3] = (byte) ((dataBuff[i]));

            data[i * 3 + 1] = (byte) ((dataBuff[i]));

            data[i * 3 + 2] = (byte) ((dataBuff[i]));

        }

        out.put(0, 0, data);
        return out;
    }//Final método img2Mat

    /**
     * Método mat2Img BufferedImage to Mat
     *
     * @param in
     * @return
     */
    public static BufferedImage mat2Img(Mat in) {
        BufferedImage out;
        byte[] data = new byte[320 * 240 * (int) in.elemSize()];
        int type;
        in.get(0, 0, data);

        if (in.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        out = new BufferedImage(320, 240, type);

        out.getRaster().setDataElements(0, 0, 320, 240, data);
        return out;
    } //final mat2Img

    public static Mat imgMat(BufferedImage in) {
        Mat out;
        byte[] data;
        int r, g, b;

        if (in.getType() == BufferedImage.TYPE_INT_RGB) {
            out = new Mat(240, 320, CvType.CV_8UC3);
            data = new byte[320 * 240 * (int) out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
            for (int i = 0; i < dataBuff.length; i++) {
                data[i * 3] = (byte) ((dataBuff[i] >> 16) & 0xFF);
                data[i * 3 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
                data[i * 3 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
            }
        } else {
            out = new Mat(240, 320, CvType.CV_8UC1);
            data = new byte[320 * 240 * (int) out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
            for (int i = 0; i < dataBuff.length; i++) {
                r = (byte) ((dataBuff[i] >> 16) & 0xFF);
                g = (byte) ((dataBuff[i] >> 8) & 0xFF);
                b = (byte) ((dataBuff[i] >> 0) & 0xFF);
                data[i] = (byte) ((0.21 * r) + (0.71 * g) + (0.07 * b)); //luminosity
            }
        }
        out.put(0, 0, data);
        return out;
    }

    public static Mat mainGaussian(Mat source) {
        Mat destination = source;
       
        try {

            destination = new Mat(source.rows(), source.cols(), source.type());

            Imgproc.GaussianBlur(source, destination, new Size(45, 45), 0);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return destination;
    }//final 
    
    /**
     * 
     * @param source
     * @return 
     */
    public static Mat mainThresholding(Mat source){
       Mat destination = source;
       
        try{
            //Imgproc.threshold(source, destination, 125, 255, Imgproc.THRESH_TOZERO);
            //Imgproc.threshold(source, destination, 125, 255, Imgproc.THRESH_BINARY);
            //Imgproc.threshold(source, destination, 125, 255, Imgproc.THRESH_BINARY_INV);
            //Imgproc.threshold(source, destination, 125, 255, Imgproc.THRESH_TOZERO_INV);
            Imgproc.threshold(source, destination, 125, 255, Imgproc.THRESH_TRUNC);
             
        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return destination;
    }

}
