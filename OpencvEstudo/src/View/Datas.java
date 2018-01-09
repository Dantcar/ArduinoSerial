/**
* Utilitarios 
* Diversas funções utilitarias para Java
* Início: 22/09/2016
* 
*
*/


package View;
 import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * @version 
 * @author Dantcar
 * @since 
 */
public class Datas {

    /**
     * getDiaSemanaCurto
     * @param date
     * @return Dia da semana em português
     */
    public static String getDiaSemanaCurto(GregorianCalendar date){
	String ret = "";
	
	switch(date.get(Calendar.DAY_OF_WEEK)){
	case Calendar.SUNDAY:
	    ret = ret.concat("Dom");
	    break;
	case Calendar.MONDAY:
	    ret = ret.concat("Seg");
	    break;
	case Calendar.TUESDAY:
	    ret = ret.concat("Ter");
	    break;
	case Calendar.WEDNESDAY:
	    ret = ret.concat("Qua");
	    break;
	case Calendar.THURSDAY:
	    ret = ret.concat("Qui");
	    break;
	case Calendar.FRIDAY:
	    ret = ret.concat("Sex");
	    break;
	case Calendar.SATURDAY:
	    ret = ret.concat("Sab");
	    break;
	default:
	    System.out.println("Error!");
	}
	return ret;
    }
   

    /**
     * getDiaSemanaLongo
     * @param date
     * @return Dia completo da semana em português
     */
    public static String getDiaSemanaLongo(GregorianCalendar date){
	String ret = "";
	
	switch(date.get(Calendar.DAY_OF_WEEK)){
	case Calendar.SUNDAY:
	    ret = ret.concat("Domingo");
	    break;
	case Calendar.MONDAY:
	    ret = ret.concat("Segunda-Feira");
	    break;
	case Calendar.TUESDAY:
	    ret = ret.concat("Terça-Feira");
	    break;
	case Calendar.WEDNESDAY:
	    ret = ret.concat("Quarta-Feira");
	    break;
	case Calendar.THURSDAY:
	    ret = ret.concat("Quinta-Feira");
	    break;
	case Calendar.FRIDAY:
	    ret = ret.concat("Sexta-Feira");
	    break;
	case Calendar.SATURDAY:
	    ret = ret.concat("Sabado");
	    break;
	default:
	    System.out.println("------");
	}
	return ret;
    }
    /**
     * Método que retorna o dia do mês com o formato de dois digitos se o
     * segundo parametro enviado for 'true' 
     * @param date
     * @param two
     * @return dia modificado sempre com dois dias ou sem modificar 
     */
     public static String getDia(GregorianCalendar date, boolean two){
	String ret = "";

	int day = date.get(Calendar.DAY_OF_MONTH);

	if(day < 10 && two){
	    ret = ret.concat("0");
	} else {
	    ret = ret.concat(" ");
	}

	ret = ret.concat((new Integer(day)).toString());

	return ret;
    }
     
     /**
      * Funcão que retorna o mês curto em português
      * @param date
      * @return mês
      */
     public static String getMes(GregorianCalendar date){

	String ret = "";

	switch(date.get(Calendar.MONTH)){
	case Calendar.JANUARY:
	    ret = ret.concat("Jan");
	    break;
	case Calendar.FEBRUARY:
	    ret = ret.concat("Fev");
	    break;
	case Calendar.MARCH:
	    ret = ret.concat("Mar");
	    break;
	case Calendar.APRIL:
	    ret = ret.concat("Abr");
	    break;
	case Calendar.MAY:
	    ret = ret.concat("Mai");
	    break;
	case Calendar.JUNE:
	    ret =ret.concat("Jun");
	    break;
	case Calendar.JULY:
	    ret = ret.concat("Jul");
	    break;
	case Calendar.AUGUST:
	    ret = ret.concat("Ago");
	    break;
	case Calendar.SEPTEMBER:
	    ret = ret.concat("Set");
	    break;
	case Calendar.OCTOBER:
	    ret = ret.concat("Out");
	    break;
	case Calendar.NOVEMBER:
	    ret = ret.concat("Nov");
	    break;
	case Calendar.DECEMBER:
	    ret = ret.concat("Dez");
	    break;
	default:
	    ret = ret.concat("Jan");

	}

	return ret;
    }
     
     /**
      * Funcão que retorna o mês longo em português
      * @param date
      * @return mês
      */
     public static String getMesLongo(GregorianCalendar date){

	String ret = "";

	switch(date.get(Calendar.MONTH)){
	case Calendar.JANUARY:
	    ret = ret.concat("Janeiro");
	    break;
	case Calendar.FEBRUARY:
	    ret = ret.concat("Fevereiro");
	    break;
	case Calendar.MARCH:
	    ret = ret.concat("Março");
	    break;
	case Calendar.APRIL:
	    ret = ret.concat("Abril");
	    break;
	case Calendar.MAY:
	    ret = ret.concat("Maio");
	    break;
	case Calendar.JUNE:
	    ret =ret.concat("Junho");
	    break;
	case Calendar.JULY:
	    ret = ret.concat("Julho");
	    break;
	case Calendar.AUGUST:
	    ret = ret.concat("Agosto");
	    break;
	case Calendar.SEPTEMBER:
	    ret = ret.concat("Setembro");
	    break;
	case Calendar.OCTOBER:
	    ret = ret.concat("Outubro");
	    break;
	case Calendar.NOVEMBER:
	    ret = ret.concat("Novembro");
	    break;
	case Calendar.DECEMBER:
	    ret = ret.concat("Dezembro");
	    break;
	default:
	    ret = ret.concat("Janeiro");

	}

	return ret;
    }
     /**
      * 
      * Método que retorna o ano com 4 digitos se o segundo parametro for 'true'
      * @param date
      * @param four
      * @return 
      */
     public static String getAno(GregorianCalendar date, boolean four){
	String ret = "";

	int year = date.get(Calendar.YEAR);

	if(year < 10){
	    if(four){
		ret = ret.concat("000");
	    } else {
		ret =ret.concat("0");
	    }
	    ret =ret.concat(""+year);
	} else if (year < 100){
	    if(four){
		ret = ret.concat("00"+year);
	    } else {
		ret =ret.concat(""+(year%100));
	    }
	} else if (year < 1000){
	    if(four){
		ret = ret.concat("0"+year);
	    } else {
		ret = ret.concat(""+(year%100));
	    }
	} else {
	    if(four){
		ret = ret.concat(""+year);
	    } else {
		ret = ret.concat(""+(year%100));
	    }
	}

	return ret;
    }
     
     /**
      * 
      * @param date
      * @return 
      */
      public static String getHora(GregorianCalendar date){
	String ret = "";

	int sec = date.get(Calendar.SECOND);
	int min = date.get(Calendar.MINUTE);
	int hour = date.get(Calendar.HOUR_OF_DAY);

	if(hour < 10){
	    ret = ret.concat("0");
	}
	ret = ret.concat(hour+":");

	if(min < 10){
	    ret = ret.concat("0");
	}

	ret = ret.concat(min+":");

	if(sec < 10){
	    ret = ret.concat("0");
	}

	ret = ret.concat(""+sec);

	return ret;
    }
     
      /**
       * retorna 'Fri, 05 Jul 1963 08:49:37 GMT'
       * @param date
       * @return 'Sex, 05 Jul 1963 08:49: GMT'
       */
     public static String dateRFC1123PTBR(GregorianCalendar date){
	
	String ret = "";

	/* Date */
	ret = ret.concat(Datas.getDiaSemanaCurto(date)+", ");
	ret = ret.concat(Datas.getDia(date, true)+" ");
	ret = ret.concat(Datas.getMes(date)+" ");
	ret = ret.concat(Datas.getAno(date, true)+" ");

	/* Time */
	ret = ret.concat(Datas.getHora(date)+" GMT");
;

	return ret;
    }
     
     /**
      * 
      * @param date
      * @return 'Sexta-Feira, 05-Jul-63 08:49:37 GMT'
      */
     public static String dateRFC850PTBR(GregorianCalendar date){

	String ret = "";

	ret = ret.concat(Datas.getDiaSemanaLongo(date)+", ");
	ret = ret.concat(Datas.getDia(date, true)+"-");
	ret = ret.concat(Datas.getMes(date)+"-");
	ret = ret.concat(Datas.getAno(date, false)+" ");
	
	ret = ret.concat(Datas.getTime(date)+" GMT");

	return ret;
    }
     
     /**
     * 
     * @param date
     * @return 
     */
    public static String dateAsctimePTBR(GregorianCalendar date){

	String ret = "";

	ret = ret.concat(Datas.getDiaSemanaCurto(date)+" ");
	ret = ret.concat(Datas.getMes(date)+" ");
	ret = ret.concat(Datas.getDia(date, false)+" ");

	ret = ret.concat(Datas.getHora(date)+" ");
	ret = ret.concat(Datas.getAno(date, true));

	return ret;
    }
    
     
    /**
     * 
     * @param date
     * @return Dia curto da semana English
     */    
    public static String getDayOfWeekShort(GregorianCalendar date){
	String ret = "";
	
	switch(date.get(Calendar.DAY_OF_WEEK)){
	case Calendar.SUNDAY:
	    ret = ret.concat("Sun");
	    break;
	case Calendar.MONDAY:
	    ret = ret.concat("Mon");
	    break;
	case Calendar.TUESDAY:
	    ret = ret.concat("Tue");
	    break;
	case Calendar.WEDNESDAY:
	    ret = ret.concat("Wed");
	    break;
	case Calendar.THURSDAY:
	    ret = ret.concat("Thu");
	    break;
	case Calendar.FRIDAY:
	    ret = ret.concat("Fri");
	    break;
	case Calendar.SATURDAY:
	    ret = ret.concat("Sat");
	    break;
	default:
	    System.out.println("Duh!");
	}
	return ret;
    }
    /**
     * 
     * @param date
     * @return Dia longo da semana English
     */
    public static String getDayOfWeekLong(GregorianCalendar date){
	String ret = "";
	
	switch(date.get(Calendar.DAY_OF_WEEK)){
	case Calendar.SUNDAY:
	    ret = ret.concat("Sunday");
	    break;
	case Calendar.MONDAY:
	    ret = ret.concat("Monday");
	    break;
	case Calendar.TUESDAY:
	    ret = ret.concat("Tuesday");
	    break;
	case Calendar.WEDNESDAY:
	    ret = ret.concat("Wednesday");
	    break;
	case Calendar.THURSDAY:
	    ret = ret.concat("Thursday");
	    break;
	case Calendar.FRIDAY:
	    ret = ret.concat("Friday");
	    break;
	case Calendar.SATURDAY:
	    ret = ret.concat("Saturday");
	    break;
	default:
	    System.out.println("Duh!");
	}
	return ret;
    }
    
    /**
     * 
     * @param date
     * @param two
     * @return day of month with one or ever with two digits, only depends if 
     * second parameter is 'true' or 'false'
     */
    public static String getDay(GregorianCalendar date, boolean two){
	String ret = "";

	int day = date.get(Calendar.DAY_OF_MONTH);

	if(day < 10 && two){
	    ret = ret.concat("0");
	} else {
	    ret = ret.concat(" ");
	}

	ret = ret.concat((new Integer(day)).toString());

	return ret;
    }
    
    /**
     * 
     * Método que retorna o mes curto em inglês
     * @param date
     * @return short month
     */
    public static String getMonth(GregorianCalendar date){

	String ret = "";

	switch(date.get(Calendar.MONTH)){
	case Calendar.JANUARY:
	    ret = ret.concat("Jan");
	    break;
	case Calendar.FEBRUARY:
	    ret = ret.concat("Feb");
	    break;
	case Calendar.MARCH:
	    ret = ret.concat("Mar");
	    break;
	case Calendar.APRIL:
	    ret = ret.concat("Apr");
	    break;
	case Calendar.MAY:
	    ret = ret.concat("May");
	    break;
	case Calendar.JUNE:
	    ret =ret.concat("Jun");
	    break;
	case Calendar.JULY:
	    ret = ret.concat("Jul");
	    break;
	case Calendar.AUGUST:
	    ret = ret.concat("Aug");
	    break;
	case Calendar.SEPTEMBER:
	    ret = ret.concat("Sep");
	    break;
	case Calendar.OCTOBER:
	    ret = ret.concat("Oct");
	    break;
	case Calendar.NOVEMBER:
	    ret = ret.concat("Nov");
	    break;
	case Calendar.DECEMBER:
	    ret = ret.concat("Dec");
	    break;
	default:
	    ret = ret.concat("Jan");

	}

	return ret;
    }

    
    /**
     * if true return year with 4 digits
     * @param date
     * @param four
     * @return 
     */
    public static String getYear(GregorianCalendar date, boolean four){
	String ret = "";

	int year = date.get(Calendar.YEAR);

	if(year < 10){
	    if(four){
		ret = ret.concat("000");
	    } else {
		ret =ret.concat("0");
	    }
	    ret =ret.concat(""+year);
	} else if (year < 100){
	    if(four){
		ret = ret.concat("00"+year);
	    } else {
		ret =ret.concat(""+(year%100));
	    }
	} else if (year < 1000){
	    if(four){
		ret = ret.concat("0"+year);
	    } else {
		ret = ret.concat(""+(year%100));
	    }
	} else {
	    if(four){
		ret = ret.concat(""+year);
	    } else {
		ret = ret.concat(""+(year%100));
	    }
	}

	return ret;
    }
    
    /**
     * 
     * @param date
     * @return 
     */
    public static String getTime(GregorianCalendar date){
	String ret = "";

	int sec = date.get(Calendar.SECOND);
	int min = date.get(Calendar.MINUTE);
	int hour = date.get(Calendar.HOUR_OF_DAY);

	if(hour < 10){
	    ret = ret.concat("0");
	}
	ret = ret.concat(hour+":");

	if(min < 10){
	    ret = ret.concat("0");
	}

	ret = ret.concat(min+":");

	if(sec < 10){
	    ret = ret.concat("0");
	}

	ret = ret.concat(""+sec);

	return ret;
    }
    
    /**
     * 
     * @param date
     * @return 
     */
    public static String dateRFC1123(GregorianCalendar date){
	
	String ret = "";

	/* Date */
	ret = ret.concat(Datas.getDayOfWeekShort(date)+", ");
	ret = ret.concat(Datas.getDay(date, true)+" ");
	ret = ret.concat(Datas.getMonth(date)+" ");
	ret = ret.concat(Datas.getYear(date, true)+" ");

	/* Time */
	ret = ret.concat(Datas.getTime(date)+" GMT");


	return ret;
    }
    
    /**
     * 
     * @param date
     * @return 
     */
    public static String dateRFC850(GregorianCalendar date){

	String ret = "";

	ret = ret.concat(Datas.getDayOfWeekLong(date)+", ");
	ret = ret.concat(Datas.getDay(date, true)+"-");
	ret = ret.concat(Datas.getMonth(date)+"-");
	ret = ret.concat(Datas.getYear(date, false)+" ");
	
	ret = ret.concat(Datas.getTime(date)+" GMT");

	return ret;
    }

    /**
     * 
     * @param date
     * @return 
     */
    public static String dateAsctime(GregorianCalendar date){

	String ret = "";

	ret = ret.concat(Datas.getDayOfWeekShort(date)+" ");
	ret = ret.concat(Datas.getMonth(date)+" ");
	ret = ret.concat(Datas.getDay(date, false)+" ");

	ret = ret.concat(Datas.getTime(date)+" ");
	ret = ret.concat(Datas.getYear(date, true));

	return ret;
    }
    
    
    public static void main(String args[]){
        //GregorianCalendar(AAAA,Calendar.mês,dia,hora,minuto,segundo)
	GregorianCalendar cal = new GregorianCalendar(1963,Calendar.JULY,5,8,49,37);

	System.out.println(cal.toString());
	System.out.println(Datas.dateRFC1123(cal));
	System.out.println(Datas.dateRFC850(cal));
	System.out.println(Datas.dateAsctime(cal));

        System.out.println(Datas.getDia(cal, true));
        System.out.println(Datas.getDia(cal, false));
        System.out.println(Datas.getDiaSemanaCurto(cal));
        System.out.println(Datas.getDiaSemanaLongo(cal));
        System.out.println(Datas.getMes(cal));
        System.out.println(Datas.getMesLongo(cal));
        
        System.out.println(Datas.getAno(cal, true));
        System.out.println(Datas.getAno(cal, false));
        System.out.println(Datas.dateRFC1123PTBR(cal));
        System.out.println(Datas.dateRFC850PTBR(cal));
        System.out.println(Datas.dateAsctimePTBR(cal));
        
        String dia,dia1,mes,ano;
        dia = Datas.getDiaSemanaLongo(cal);
        dia1 = Datas.getDay(cal, true);
        mes = Datas.getMesLongo(cal);
        ano = Datas.getYear(cal, true);
        
        System.out.println(
                dia +", "
                +dia1 + " "
                +mes +" "
                + "" + ano
                );
        
        
        
        
        
	System.exit(0);
    }
}

