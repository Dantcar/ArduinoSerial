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

    /**
     * Método para validar e-mail
     *  O método abaixo é utilizado para validação de e-mail, considerando seu formato com @ e .(ponto):
     *
     * @param email
     * @return email
     */
    public static boolean validaEmail(String email) {
        //System.out.println("Metodo de validacao de email");
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(email);
     return m.find(); //System.out.println("O email "+email+" e valido");
     //System.out.println("O E-mail "+email+" é inválido");
    }
    
    public static boolean validaCPF(String CPF) {
        Pattern p;
     p = Pattern.compile("^(\\d)\\1{2}.\\1{3}.\\1{3}-\\1{2}$");
        Matcher m = p.matcher(CPF);
     return m.find(); //System.out.println("O email "+email+" e valido");
     //System.out.println("O E-mail "+email+" é inválido");
    }

}
