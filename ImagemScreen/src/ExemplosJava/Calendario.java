/**
 * Sao Paulo 21-12-2017
 * Class Calendario.java
 * Java Cookbook - pg161-162
 * 
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
package ExemplosJava;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author decio_000
 */
public class Calendario {
    /** The names of the months */
    String[] months = {
        "Janeiro", "Fevereiro", "Marco", "Abril",
        "Maio", "Junho", "Julho", "Agosto",
        "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    
    /** The days in each month. */
    public final static int dom[] = {
        31, 28, 31, 30, /* jan feb mar apr */
        31, 30, 31, 31, /* may jun jul aug */
        30, 31, 30, 31  /* sep oct nov dec */
    };
    
    /** Compute which days to put where, in the Cal panel */
    
    public void print (int mm, int yy){
        /** The number of days to leave blank at the start of this month */
        int leadGap = 0;
        
        System.out.print(months[mm]);  // print month and year
        System.out.print(" ");
        System.out.print(yy);
        System.out.println(  );
        
        if (mm < 0 || mm > 11)
            throw new IllegalArgumentException("Month " + mm + " bad, "
                    + "must be 0-11");
        
        GregorianCalendar calendar = new GregorianCalendar(yy, mm, 1);
        
        System.out.println("Do Se Te Qu Qu Se Sa");
        
        // Compute how much to leave before the first.
        // getDay()  returns 0 for Sunday, which is just right.
        leadGap = calendar.get(Calendar.DAY_OF_WEEK)-1;
        
        int daysInMonth = dom[mm];
        if (calendar.isLeapYear(calendar.get(Calendar.YEAR))
                &&  mm == 1){
           ++daysInMonth;
        }

        // Blank out the labels before 1st day of month
        for (int i = 0; i < leadGap; i++){
            System.out.print("   ");
        }//final for1
        
        // Fill in numbers for the day of month.
        for (int i = 1; i <= daysInMonth; i++){
            
        // This "if"  statement is simpler than fiddling with NumberFormat
            if (i<=9){
                System.out.print(' ');
            } 
            
            System.out.print(i);
            
            // wrap if end of line.
            if ((leadGap + i) % 7 == 0 ){
                System.out.println(  );
            }else{
                 System.out.print(' ');
            }
            
        }//final for2
        
        System.out.println(  );
            
    }//final metodo print
 
 /** For testing, a main program */
public static void main(String[] av) {
    int month, year;
    Calendario cp = new Calendario( );
    
    // print the current month.
    if (av.length == 2) {
        cp.print(Integer.parseInt(av[0])-1,
        Integer.parseInt(av[1]));
    } else {
        Calendar c = Calendar.getInstance( );
        cp.print(c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    }
}
    
}//final classe CalendarPage
