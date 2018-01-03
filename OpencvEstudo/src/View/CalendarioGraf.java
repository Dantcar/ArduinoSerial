/**
 * Praia Grande 02/01/2018
 * Class Calendario.java
 * Java Cookbook - pg161-162
 * modificado para saida em BufferedImagem
 * 
 * @author Decio A Carvalho
 * @serial 0.5
 * @since Janeiro 2018
 *
 * Retomada dos Estudos com manipulacao de imagens utilizando:
 * Java.awt.Graphcs2d, Java.awt.Graphics, Java.awt.image, Java.awt.Color,
 * Java.awt.Robot, Java.awt.geom, Java.io, Java.net, Java.util, Java.imageio,
 * Java.swing, Java.text, Java.awt.AWTException Java.awt.Rectangle,
 */
package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author decio_000
 */
public class CalendarioGraf extends JPanel {
    private int leadGap;
    
    /** The names of the months */
    private final String[] months = {
        "Janeiro", "Fevereiro", "Marco", "Abril",
        "Maio", "Junho", "Julho", "Agosto",
        "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    
    private final String[] days = {"Dom","Seg","Ter","Qua","Qui","Sex","Sab"};
    
    /** The days in each month. */
    public final static int DOM[] = {
        31, 28, 31, 30, /* jan feb mar apr */
        31, 30, 31, 31, /* may jun jul aug */
        30, 31, 30, 31  /* sep oct nov dec */
    };
    
    Calendar c = Calendar.getInstance( );
    //BufferedImage texto = printxt(c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    BufferedImage calendario = printxt(4, 2018);
    /** Compute which days to put where, in the Cal panel */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(calendario,0,0,this);
    }
 
    /**
     * Metodo que retorna um calendario do mês corrente
     * @param mm - Mes
     * @param yy - Ano
     * @return Image do calendario do mes: mm e ano yy.
     */
    public BufferedImage printxt (int mm, int yy){
        BufferedImage bufferedImage = new
                BufferedImage(250, 180, BufferedImage.TYPE_INT_RGB);
        
        Graphics g = bufferedImage.getGraphics();
        
        /** The number of days to leave blank at the start of this month */
        leadGap = 0;
        int  eh = 0; //espacoHorizontal
        int  ev = 0; //espacoVertical
        
        ev = 10;
        eh = 26;
        
        g.drawString(months[mm] + " " + yy, eh, ev);  // print month and year
        //g.drawString(yy+"", 5, 25);
        
        if (mm < 0 || mm > 11){
            throw new IllegalArgumentException("Month " + mm + " bad, "
                    + "must be 0-11");
        }

        GregorianCalendar calendar = new GregorianCalendar(yy, mm, 1);
        ev = ev + 30;
        
        //for para montagem do cabecalho ("Do Se Te Qu Qu Se Sa").
        for( int i=0; i<7; i++){
         g.drawString(days[i], eh, ev);
         eh = eh + 28;
        }
        eh = 28;
        ev = ev + 15;
        
        // Compute how much to leave before the first.
        // getDay()  returns 0 for Sunday, which is just right.
        leadGap = calendar.get(Calendar.DAY_OF_WEEK);
        
        
        //Define o numero total de dias que tem no mes do calendario
        int daysInMonth = DOM[mm];
        
        //if que acrescenta 1 dia ao total de dias de fevereiro se for ano 
        //bissexto
        if (calendar.isLeapYear(calendar.get(Calendar.YEAR))
                &&  mm == 1){
           ++daysInMonth;
        }
        
        /*
        // formula para colocar o primeiro dia da primeira semana no dia correto
        for (int i = 1; i < leadGap; i++){
            eh = eh + 28*i;
            System.out.println("dia: " + i + "  pos.Horizontal: " 
                    + eh +"  pos.Vertical: " + ev);
        }//final for1
        */
        eh = eh * leadGap;
        //System.out.println("leadGap: "+leadGap);
        //System.out.println(eh);
        
        
        // Fill in numbers for the day of month.
        for (int i = 1; i <= daysInMonth; i++){
            
        // This "if"  statement is simpler than fiddling with NumberFormat
        g.drawString(String.valueOf(i), eh, ev);
        //System.out.println("dia: " + i + "  pos.Horizontal: " 
                    //+ eh +"  pos.Vertical: " + ev);
            if (eh > 190){
               ev = ev+15;
               eh = 0;
            }
            eh=eh+28;
            
        }//final for2
        
        return bufferedImage;
 
    }//final metodo printtxt
  
    
    
 /** For testing, a main program */
public static void main(String[] av) {
    CalendarioGraf cp = new CalendarioGraf( );
    JFrame frame = new JFrame();
    frame.add(cp);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 180);
    frame.setVisible(true);
}
    
}//final classe CalendarPage
