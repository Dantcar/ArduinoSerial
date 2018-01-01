/**
 * Praia Grande 31-12-2017
 * Class DuplaImagem.java
 * LearnigJava - cap.17
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
package View;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author decio_000
 */
public class DuplaImagem {
    
    private JButton buttonLeft, buttonRight, buttonEnd, buttonExtra;
    
    private JFileChooser fileChooser;

    private JLabel leftImage, rightImage;

    private String fileOne = "D:\\images\\teste4.png";
    private String fileTwo = "D:\\images\\novidade.png";

    public DuplaImagem(JButton buttonLeft, JButton buttonRight, 
            JButton buttonEnd, JButton buttonExtra, 
            JFileChooser fileChooser, JLabel leftImage, 
            JLabel rightImage) {
        
        this.buttonLeft = buttonLeft;
        this.buttonRight = buttonRight;
        this.buttonEnd = buttonEnd;
        this.buttonExtra = buttonExtra;
        this.fileChooser = fileChooser;
        this.leftImage = leftImage;
        this.rightImage = rightImage;
    }

    /**
     * 
     */
    public DuplaImagem() {
         //metodo para carregar interface e seus componentes
        initComponentes();

        //metodo para colocar acao aos botoes
        initActionBotoes();
        
        //metodo para colocar acao aos Labels das imagens esquerda e direita.
        initActionLabels();
    }//final metodo construtor DuplaImagem

    /**
     * Utilizaçao uso geral
     * Metodo que retorna uma String 
     * com o caminho completo de uma imagem selecionada
     * @return 
     */
    private String arqVideo() {
        fileChooser = new JFileChooser("D:\\images");
        //acima ou abaixo são opcoes unicas
   //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

       //desabilita o default do JFileChooser tipo de arquivos. 
       fileChooser.setAcceptAllFileFilterUsed(false);
             
       fileChooser.setFileView(new ImageFileView());
       //Add the preview pane.
        fileChooser.setAccessory(new ImagePreview(fileChooser));
       
        
        //parte final e comum de um JFileChooser
        int result = fileChooser.showOpenDialog(buttonEnd);
        //se o usuario clicou no botao Cancel no dialogo, retorna
        if (result == JFileChooser.CANCEL_OPTION) {
             try {
                this.finalize();
                //System.exit(1);
            } catch (Throwable ex) {
                System.out.println("Erro:" + ex);
                Logger.getLogger(DuplaImagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File fileName = fileChooser.getSelectedFile();

        //exibe erro se invalido
        if ((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(buttonEnd, "Invalido nome de arquivo",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);
            try {
                this.finalize();
                //System.exit(1);
            } catch (Throwable ex) {
                System.out.println("Erro:" + ex);
                Logger.getLogger(DuplaImagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return fileName.getAbsolutePath();
        
    }//final metodo arqVideo

    /**
     * metodo para carregar interfacegrafica e seus componentes
     */
    private void initComponentes() {
        //Todas as bordas
        //Borda do painel
        Color bl = new Color(204, 23, 204);
        LineBorder lborderP = new LineBorder(bl, 4);
        //Borda do painel
        Color bpb = new Color(10, 200, 200);
        LineBorder lborderPB = new LineBorder(bpb, 4);
        //Borda do split
        Color bs = new Color(10, 230, 20);
        LineBorder lborderS = new LineBorder(bs, 4);

        //Borda do leftImage
        Color bli = new Color(10, 10, 10);
        LineBorder lborderLI = new LineBorder(bli, 4);

        //Borda do rightImage
        Color blir = new Color(10, 10, 10);
        LineBorder lborderRI = new LineBorder(blir, 4);

        //Montagem do painel (Panel) principal
        JPanel jPanel = new javax.swing.JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel.setBorder(lborderP);
        jPanel.setSize(600, 300);
        
        //Montagem do painelBotoes (Panel) botoes
        JPanel jPanelBotoes = new javax.swing.JPanel();
        jPanelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelBotoes.setBorder(lborderPB);
        jPanelBotoes.setSize(300,50);
                
        //JFrame frame principal
        JFrame frame = new JFrame("DuplaImagem v1.0");
        
        frame.setSize(700, 450);
        //JButton left
        buttonLeft = new JButton();
        buttonLeft.setFont(new java.awt.Font("Arial", 1, 14));
        buttonLeft.setText("Escolher Imagem Esquerda");

        //JButton Right
        buttonRight = new JButton();
        buttonRight.setFont(new java.awt.Font("Arial", 1, 14));
        buttonRight.setText("Escolher Imagem Direita");

        //JButton End
        buttonEnd = new JButton();
        buttonEnd.setFont(new java.awt.Font("Arial", 1, 14));
        buttonEnd.setText("Sair");
        
        //JButton beep
        buttonExtra = new JButton();
        buttonExtra.setFont(new java.awt.Font("Arial", 1, 14));
        buttonExtra.setText("Extra");
        
        //buttonBeep.setBounds(150, 60, 80, 30);
        
        //Imagem da esquerda
        leftImage = new JLabel(new ImageIcon(fileOne));
        leftImage.setBorder(lborderLI);
        //leftImage.setToolTipText("Imagems Carregada: " + fileOne);
        Component left = new JScrollPane(leftImage);

        //Imagem da direita
        rightImage = new JLabel(new ImageIcon(fileTwo));
        rightImage.setBorder(lborderRI);
        //rightImage.setToolTipText("Imagems Carregada: " + fileTwo);

        Component right = new JScrollPane(rightImage);

        //Acrescentar funcionalidade Acessibilidade toolTipText
        loadTooltip();
        
        //Criacao do split
        JSplitPane split
                = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        split.setBorder(lborderS);
        split.setDividerLocation(500);

        //Adicionando os componentes split ao jPanel
       
        //Adicionando os botoes ao jPanelBotoes
        jPanelBotoes.add(buttonLeft);
        jPanelBotoes.add(buttonRight);
        jPanelBotoes.add(buttonExtra);
        jPanelBotoes.add(buttonEnd);
        //Adicionando o jPanelBotoes ao painel principal (jPanel)
        jPanel.add(jPanelBotoes);
        jPanel.add(split);
        
        //Adicionando o jPanel ao frame principal
        frame.getContentPane().add(jPanel);
        
        //frame.setSize(700, 350);
        //frame.getContentPane().add(split);
        //configurando frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }//final metodo initComponentes

    /**
     * Metodo responsavel em adicionar acoes aos botoes
     * 
     */
    private void initActionBotoes() {
        //Acao para o botao Left
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Esquerda Avante");

                fileOne = arqVideo();
                // fileName.getAbsolutePath();
                System.out.println(fileOne);
                leftImage.setIcon(new ImageIcon(fileOne));
                loadTooltip();

            }

        });
        
        //Acao para o botao Right
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Direita Abaixo");

                fileTwo = arqVideo();
                // fileName.getAbsolutePath();
                System.out.println(fileOne);
                rightImage.setIcon(new ImageIcon(fileTwo));
                loadTooltip();
            }

        });
        
        //Acao para o botao End
        buttonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saindo....");
                System.exit(0);
            }

        });
        
        //Acao para o botao End
        buttonExtra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = GetScreenImage();
                String path = "ScreenShot.png";
                File name = new File( path );
                rightImage.setIcon(new ImageIcon(fileTwo));
                
            }

        });
        
    }//final metodo initActionBotoes
    
    /**
     * Metodo responsavel em adicionar acoes aos Labels
     * que são utilizados para exibir as imagens selecionadas.
     * 
     */
    
    /**
     * Metodo para capturar mouse clicado na imagem da esquerda
     */
    private void initActionLabels() {
        
        /**
        * Metodo para capturar mouse clicado na imagem da esquerda
        */
        leftImage.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.out.println("Mouse clicado na figura esquerda");
            }
        });
        
        /**
        * Metodo para capturar mouse clicado na imagem da direita
        */
        rightImage.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                System.out.println("Mouse clicado na figura direita");
            }
        });  
       
    }//final metodo initActionLabels
    
    /**
     * Metodo Acessivel para acrescentar a descricao do nome e tipo de foto
     */
    private void loadTooltip() {
        leftImage.setToolTipText("Imagems Carregada: " + fileOne);
        rightImage.setToolTipText("Imagems Carregada: " + fileTwo);
    }
    /**
     * Metodo main
     *
     * @param args
     */
    public static void main(String[] args) {
        DuplaImagem form = new DuplaImagem();

    }//final main

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
    //To change body of generated methods, choose Tools | Templates.
        System.out.println("clickeid");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
*/
    /**
     * 
     * @return
     * @throws AWTException
     * @throws IOException 
     */
     public BufferedImage GetScreenImage() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(DuplaImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension d = new Dimension();
        d.height = 10;
        d.width = 10;
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(d));
        BufferedImage bgrScreenshot = new BufferedImage(screenShot.getWidth(),
                screenShot.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        boolean done = bgrScreenshot.getGraphics().drawImage(screenShot, 0, 0, null);
        
        return bgrScreenshot;
    }//final metodo GetCurrentScreenImage
    
    /**
     * 
     * @return
     * @throws AWTException
     * @throws IOException 
     */
     public static byte[] GetCurrentScreenImage() throws AWTException,
            IOException {
        Robot robot = new Robot();
        Dimension d = new Dimension();
        d.height = 10;
        d.width = 10;
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(d));
        BufferedImage bgrScreenshot = new BufferedImage(screenShot.getWidth(),
                screenShot.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        boolean done = bgrScreenshot.getGraphics().drawImage(screenShot, 0, 0, null);
        return ((DataBufferByte) bgrScreenshot.getRaster().getDataBuffer())
                .getData();
    }//final metodo GetCurrentScreenImage
    
}//final Classe DuplaImagem
