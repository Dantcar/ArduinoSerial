/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author deciodecarvalho
 */
public class ValidaCampos {
    
    /**
     * Construtor
     */   

    public ValidaCampos() {
    
    }
    
    public static boolean validaVazio(String texto) {
    Pattern p;
    p = Pattern.compile("[^$]");
    Matcher m = p.matcher(texto);
    return m.find();
    }
    
    public static boolean validaVazioComboBox(String uf) {
    Pattern p;
    p = Pattern.compile("[^\\[\\]$]");
    Matcher m = p.matcher(uf);
    return m.find();
    }
    
    public static boolean validaEmail(String email) {
    Pattern p;
    p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
    Matcher m = p.matcher(email);
    return m.find();
    }
    
    public static boolean validaRG(String RG) {
    Pattern p;
    //p = Pattern.compile  ("^[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9]$");
    p = Pattern.compile("^[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9]|[A-Z]$");
    Matcher m = p.matcher(RG);
    return m.find();
    }

    public static boolean validaCPF(String CPF) {
    Pattern p;
    p = Pattern.compile("^[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]$");
    Matcher m = p.matcher(CPF);
    return m.find();
    }
    public static boolean validaCEP(String CEP) {
    Pattern p;
    p = Pattern.compile("^[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9]$");
    Matcher m = p.matcher(CEP);
    return m.find();
    }
    public static boolean validaData(String nasc) {
    Pattern p;
    //p = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
    p = Pattern.compile("^[0123][0-9]/[0123][0-9]/[12][0-9][0-9][0-9]$");
    Matcher m = p.matcher(nasc);//System.out.println("O campo nascimento: "+nasc+" é inválido");
    return m.find();
    }


}
