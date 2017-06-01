/*
 * Este Software tem Objetivo Educacional
 * Para fins de TCC
 * do Curso de Analise de Sistemas da Fatec - Ipiranga
 * Ano 2016 - Julho a Dezembro  
 * Aluno Decio Antonio de Carvalho  * 
 * ultima revisao : 01-junho-2017
 */
/**
 * Métodos desta classe
 *
 *  01 - logarUsuario() // retorna verdadeiro se o usuario e senha estao corretos
 */
 
package controle;


import modelo.UsuarioDAO;

public class UsuarioCtrl {

    /**
     * 01 - Receber verdadeiro se o usuario/senha esta cadastrado
     * @param login
     * @param password
     * @return boolean 
     */
    public static boolean logarUsuario(String login, String password){
         boolean resposta = false;
         UsuarioDAO usuario = new UsuarioDAO();
         resposta = usuario.logarPetfast(login, password);
        return resposta;
    }
}//final classe UsuarioCtrl
